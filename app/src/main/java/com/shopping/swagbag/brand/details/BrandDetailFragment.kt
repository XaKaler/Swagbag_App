package com.shopping.swagbag.brand.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.shopping.swagbag.brand.BrandModel
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.common.adapter.BrandDetailsAdapter
import com.shopping.swagbag.common.base.BaseFragment
import com.shopping.swagbag.databinding.FragmentBrandDetailBinding
import com.shopping.swagbag.databinding.ToolbarWithNoMenuWhiteBgBinding
import com.shopping.swagbag.products.ProductRepository
import com.shopping.swagbag.products.ProductSearchParameters
import com.shopping.swagbag.products.ProductViewModel
import com.shopping.swagbag.service.Resource
import com.shopping.swagbag.service.apis.ProductApi

class BrandDetailFragment :
    BaseFragment<FragmentBrandDetailBinding, ProductViewModel, ProductRepository>(
        FragmentBrandDetailBinding::inflate
    ) {

    private lateinit var toolbarBinding: ToolbarWithNoMenuWhiteBgBinding
    private lateinit var brandSlug: String
    private lateinit var brandDetails: BrandDetailsModel

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentBrandDetailBinding.inflate(inflater, container, false)

    override fun getViewModel() = ProductViewModel::class.java

    override fun getFragmentRepository() = ProductRepository(remoteDataSource.getBaseUrl().create(
        ProductApi::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(this::brandDetails.isInitialized){
            showBrandDetails()
            showBrandBestSeller()
        }
        else {
            getArgument()
            getBrandDetails()
        }

        setToolbar()

        with(viewBinding) {
            //click events
            btnViewMore.setOnClickListener {
                val productSearchParameters =
                    ProductSearchParameters("", brandDetails.brands.id, "", "", "", "", "", "", "")

                val action = BrandDetailFragmentDirections.actionGlobalProductsFragment(
                    Gson().toJson(
                        productSearchParameters,
                        ProductSearchParameters::class.java
                    )
                )
                findNavController().navigate(action)
            }
        }
    }

    private fun getBrandDetails() {
        viewModel.brandDetails(brandSlug).observe(viewLifecycleOwner){
            when(it){
                is Resource.Loading -> showLoading()
                is Resource.Success -> {
                    stopShowingLoading()
                    brandDetails = it.value
                    showBrandDetails()
                    showBrandBestSeller()
                }
                is Resource.Failure -> stopShowingLoading()
            }
        }
    }

    private fun showBrandBestSeller() {
        viewBinding.rvBrandBestSeller.run{
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = BrandBestSellerAdapter(context, brandDetails.brandsProducts, object: RecycleViewItemClick{
                override fun onItemClickWithName(name: String, position: Int) {
                    val action = BrandDetailFragmentDirections.actionGlobalProductDetailsFragment(name)
                    findNavController().navigate(action)
                }
            })
        }
    }

    private fun showBrandDetails() {
        //set brand image
        context?.let {
            Glide.with(it)
                .load(brandDetails.brands.file)
                .into(viewBinding.imgBrand)
        }

        viewBinding.rvBrandDetails.run{
            val aboutBrandList = ArrayList<AboutBrandModel>()

            brandDetails.brands.run {
                aboutBrandList.add(AboutBrandModel(file, desc))
                aboutBrandList.add(AboutBrandModel(file2, desc2))
                aboutBrandList.add(AboutBrandModel(file3, desc3))
            }
            layoutManager = LinearLayoutManager(context)
            adapter = BrandDetailsAdapter(context, aboutBrandList)
        }
    }

    private fun getArgument() {
        val args: BrandDetailFragmentArgs by navArgs()
        brandSlug = args.brandSlug
    }

    private fun setToolbar() {
        toolbarBinding = viewBinding.toolbar

        with(toolbarBinding){
            imgBack.setOnClickListener{
                findNavController().popBackStack()
            }
            tvTitle.text ="Brand Details"
        }
    }
}