package com.shopping.swagbag.coupons

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.shopping.swagbag.R
import com.shopping.swagbag.databinding.DialogBuyGiftcardBinding

class DialogBuyGiftCard : DialogFragment(R.layout.dialog_buy_giftcard) {

    private lateinit var viewBinding: DialogBuyGiftcardBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = DialogBuyGiftcardBinding.bind(view)

        // get image url
        val args: DialogBuyGiftCardArgs by navArgs()
        val coupon = Gson().fromJson(args.coupon, GiftCardModel.Result::class.java)

        with(viewBinding){
            // set image
            context?.let {
                Glide.with(it)
                    .load(coupon.file)
                    .into(imgCoupon)
            }

            //click events
            btnProceedToPay.setOnClickListener {
                collectUserInfo()
            }
            btnCancel.setOnClickListener {
                dismiss()
            }
        }
    }

    private fun collectUserInfo() {
        with(viewBinding){
            val fName = edtFirstName.text.toString()
            val lName = edtLastName.text.toString()
            val email = edtEmail.text.toString()
            val phone = edtPhone.text.toString()
            val message = edtMessage.text.toString()

            if(fName.isEmpty() || lName.isEmpty()|| email.isEmpty()|| phone.isEmpty())
                Toast.makeText(context, "Fill all details", Toast.LENGTH_SHORT).show()
            else
                dismiss()
        }
    }
}