package com.shopping.swagbag.coupons

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.shopping.swagbag.R
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.service.apis.SettingApi
import com.shopping.swagbag.settings.SettingRepository
import com.shopping.swagbag.common.base.BaseFragment
import com.shopping.swagbag.databinding.FragmentCouponsBinding
import com.shopping.swagbag.databinding.ToolbarWithNoMenuWhiteBgBinding
import com.shopping.swagbag.service.Resource
import com.shopping.swagbag.utils.SettingViewModel

class CouponsFragment :
    BaseFragment<FragmentCouponsBinding, SettingViewModel, SettingRepository>(FragmentCouponsBinding::inflate) {

    private lateinit var toolbarBinding: ToolbarWithNoMenuWhiteBgBinding
    private lateinit var giftCardList: List<GiftCardModel.Result>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarBinding = viewBinding.include

        initViews()

    }

    private fun initViews() {
        setToolbar()

        getGiftCards()
    }

    private fun getGiftCards() {
        viewModel.giftCard().observe(viewLifecycleOwner){
            when(it){
                is Resource.Loading -> showLoading()

                is Resource.Success -> {
                    stopShowingLoading()

                    Log.e("TAG", "getGiftCards: $it", )
                    giftCardList = it.value.result
                    setCoupons(giftCardList)
                }

                is Resource.Failure -> Log.e("TAG", "getGiftCards: $it", )
            }
        }
    }

    private fun setCoupons(data: List<GiftCardModel.Result>) {
        with(viewBinding){
            rvCoupons.apply{
                layoutManager = GridLayoutManager(context, 2)
                adapter = CouponAdapter(context, data, object: RecycleViewItemClick{
                    override fun onItemClickWithName(name: String, position: Int) {
                        when(name){
                            "buy coupon" -> {
                                val coupon = Gson().toJson(giftCardList[position], GiftCardModel.Result::class.java)
                                val action = CouponsFragmentDirections.actionCouponsFragmentToDialogBuyCoupon(coupon)
                                findNavController().navigate(action)
                            }
                        }
                    }
                })
            }
        }
    }

    private fun setToolbar() {
        with(toolbarBinding) {
            // set title
            tvTitle.text = getString(R.string.mycoupons)

            // back button click
            imgBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCouponsBinding.inflate(inflater, container, false)

    override fun getViewModel() = SettingViewModel::class.java

    override fun getFragmentRepository() =
        SettingRepository(remoteDataSource.getBaseUrl().create(SettingApi::class.java))
}