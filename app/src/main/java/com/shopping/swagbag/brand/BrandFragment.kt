package com.shopping.swagbag.brand

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.common.base.BaseFragment
import com.shopping.swagbag.databinding.FragmentBrandBinding
import com.shopping.swagbag.databinding.ToolbarWithNoMenuBinding
import com.shopping.swagbag.products.ProductRepository
import com.shopping.swagbag.products.ProductViewModel
import com.shopping.swagbag.service.Resource
import com.shopping.swagbag.service.apis.ProductApi


class BrandFragment :
    BaseFragment<FragmentBrandBinding, ProductViewModel, ProductRepository>(FragmentBrandBinding::inflate) {

    private lateinit var toolbarBinding: ToolbarWithNoMenuBinding
    private lateinit var brandList: List<BrandModel.Result>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarBinding = viewBinding.toolbar

        setToolbar()

        if (this::brandList.isInitialized)
            setAllBrands()
        else
            getAllBrands()
    }

    private fun getAllBrands() {
        viewModel.allBrand().observe(viewLifecycleOwner, Observer {

            when (it) {
                is Resource.Loading -> showLoading()

                is Resource.Success -> {
                    stopShowingLoading()
                    brandList = it.value.result
                    setAllBrands()
                }

                is Resource.Failure -> {
                    stopShowingLoading()
                    toast(it.errorBody.toString())
                }
            }
        })
    }

    private fun setAllBrands() {
        viewBinding.rvBrand.run {
            layoutManager = LinearLayoutManager(context)
            adapter = BrandAdapter(context, brandList, object : RecycleViewItemClick {
                override fun onItemClickWithName(name: String, position: Int) {
                    val brand = brandList[position].slug
                    val action =
                        BrandFragmentDirections.actionBrandFragmentToBrandDetailFragment(brand)
                    findNavController().navigate(action)
                }
            })
        }
    }

    private fun setToolbar() {
        with(toolbarBinding) {
            imgBack.setOnClickListener { findNavController().popBackStack() }
            tvTitle.text = "All Brands"
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentBrandBinding.inflate(inflater, container, false)

    override fun getViewModel() = ProductViewModel::class.java

    override fun getFragmentRepository() =
        ProductRepository(remoteDataSource.getBaseUrl().create(ProductApi::class.java))
}