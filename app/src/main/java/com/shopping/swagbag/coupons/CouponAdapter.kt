package com.shopping.swagbag.coupons

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.databinding.SingleCouponBinding


class CouponAdapter(
    private val context: Context,
    private val data: List<GiftCardModel.Result>,
    private val itemClick: RecycleViewItemClick
) :
    RecyclerView.Adapter<CouponAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val viewBinding: SingleCouponBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(singleData: GiftCardModel.Result, position: Int, itemClick: RecycleViewItemClick){
            with(viewBinding) {
                singleData.run {
                    Glide.with(context).load(file).into(imgCoupon)
                    tvCouponName.text = coupon
                    tvDescription.text = desc

                    btnBuyNow.setOnClickListener{
                        itemClick.onItemClickWithName("buy coupon", position)
                    }
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            SingleCouponBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position], position, itemClick)
    }

    override fun getItemCount()= data.size
}