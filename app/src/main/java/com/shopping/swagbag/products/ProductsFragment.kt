package com.shopping.swagbag.products

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.shopping.swagbag.R
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.common.base.BaseFragment
import com.shopping.swagbag.common.base.GeneralFunction
import com.shopping.swagbag.common.views.BottomFilterDialog
import com.shopping.swagbag.databinding.FragmentProductsBinding
import com.shopping.swagbag.databinding.LytProductMenuBinding
import com.shopping.swagbag.databinding.ToolbarWithThreeMenusBinding
import com.shopping.swagbag.products.filter.FilterModel
import com.shopping.swagbag.service.Resource
import com.shopping.swagbag.service.apis.ProductApi
import com.shopping.swagbag.utils.AppUtils


class ProductsFragment : BaseFragment<
        FragmentProductsBinding,
        ProductViewModel,
        ProductRepository
        >(FragmentProductsBinding::inflate) {

    private lateinit var toolbarBinding: ToolbarWithThreeMenusBinding
    private lateinit var productMenuBinding: LytProductMenuBinding
    private lateinit var productSearchParameters: ProductSearchParameters
    private lateinit var appUtils: AppUtils
    private lateinit var categoryFilter: FilterModel
    private var filterMap = mutableMapOf<String, Any>()
    private lateinit var products: ArrayList<ProductSearchModel.Result>
    private lateinit var filterDialog: BottomFilterDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarBinding = viewBinding.include
        productMenuBinding = viewBinding.includeProductMenu

        initViews()
    }

    private fun initViews() {
        setToolbar()

        // set or get product related to category or sub-category
        if (this::products.isInitialized)
            setProducts()
        else
            getProducts()

        getCategoryFilter()
        setProductMenu()
        appUtils = context?.let { AppUtils(it) }!!
    }

    private fun getCategoryFilter() {
        viewModel.getFilter(productSearchParameters.master).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    stopShowingLoading()
                    categoryFilter = it.value
                }
                is Resource.Failure -> {
                    stopShowingLoading()
                    Log.e("filter", it.errorBody.toString())
                }
            }
        }
    }

    private fun setProductMenu() {
        with(productMenuBinding){
            //to sort products
            tvSortBy.setOnClickListener {
                openListDialog(
                    tvSortBy,
                    GeneralFunction.getSortBY(),
                    false
                ) { result ->
                    when (result) {
                        "Default" -> {
                            setProducts()
                        }
                        "Latest" -> {
                            products.sortBy { r -> r.createdDate }
                            setProducts()
                        }
                        "Sort forward price low" -> {
                            products.sortBy { r -> r.price }
                            setProducts()
                        }
                        "Sort forward price high" -> {
                            products.sortByDescending { r -> r.price }
                            setProducts()
                        }
                    }
                }
            }

            //set master category name
            //masterCategoryName.text = productSearchParameters.master

            //filter product according to master category
            tvFilter.setOnClickListener {
                BottomFilterDialog(categoryFilter) { color ->
                    Log.e("color", color)
                }.show(childFragmentManager, "filter")
            }
        }
    }

    private fun getProducts() {
        val args: ProductsFragmentArgs by navArgs()
        productSearchParameters =
            Gson().fromJson(args.productSearchParameters, ProductSearchParameters::class.java)

        Log.e("products", "$productSearchParameters")

        productSearchParameters.run {
            viewModel.productSearch(
                deal,
                brand,
                subCategory,
                categroy,
                price,
                option,
                sortBy,
                master,
                s
            )
                .observe(viewLifecycleOwner) {
                    when (it) {
                        is Resource.Loading -> showLoading()

                        is Resource.Success -> {
                            stopShowingLoading()

                            products = it.value.result as ArrayList<ProductSearchModel.Result>
                            setProducts()
                        }

                        is Resource.Failure -> {
                            stopShowingLoading()
                            tryAgain()
                            findNavController().popBackStack()
                            Log.e("TAG", "setProducts: $it")
                    }
                }
            }
        }
    }

    private fun setProducts() {
        if (products.isEmpty()) {
            toast("No product found")
            findNavController().popBackStack()
        } else {
            viewBinding.rvProducts.apply {
                layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
                //addItemDecoration(GridSpaceItemDecoration(5))
                adapter = ProductAdapter(context, products, object: RecycleViewItemClick{
                    override fun onItemClickWithName(name: String, position: Int) {
                        when(name){
                            "product details" -> {
                                val productName = products[position].slug
                                val action = ProductsFragmentDirections.actionProductsFragmentToProductDetailsFragment(productName)
                                findNavController().navigate(action)
                            }
                        }
                    }

                    override fun onItemClickWithView(name: String, view: View, position: Int) {
                        super.onItemClickWithView(name, view, position)
                        when(name){
                            "wishlist" -> addToWishlist(view, position)
                        }
                    }
                })
            }
        }
    }

    private fun addToWishlist(view: View, position:Int) {
        if(AppUtils(context!!).isUserLoggedIn()) {
            val productId = products[position].id
            val userId = AppUtils(context!!).getUserId()
            viewModel.addToWishList(productId, userId).observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> showLoading()
                    is Resource.Success -> {
                        stopShowingLoading()
                        val img = view as ImageView
                        img.setImageResource(R.drawable.product_in_wishlist)
                        toast(it.value.message)
                    }
                    is Resource.Failure -> stopShowingLoading()
                }
            }
        }
        else
            findNavController().navigate(R.id.action_global_signInFragment)
    }

    private fun setToolbar() {
        with(toolbarBinding){
            // set title
            tvTitle.text = getString(R.string.products)

            // back button click
            imgBack.setOnClickListener{
                findNavController().popBackStack()
            }

            imgSearch.setOnClickListener{
                findNavController().navigate(R.id.action_global_searchFragment)
            }

            imgWishlist.setOnClickListener{
                if (appUtils.isUserLoggedIn())
                    findNavController().navigate(R.id.action_global_wishlistWithProductFragment)
                else
                    findNavController().navigate(R.id.action_global_signInFragment)
            }

            imgCart.setOnClickListener{
                if (appUtils.isUserLoggedIn())
                findNavController().navigate(R.id.action_global_shoppingBegWithProductFragment)
                else
                    findNavController().navigate(R.id.action_global_signInFragment)
            }

        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentProductsBinding.inflate(inflater, container, false)

    override fun getViewModel() = ProductViewModel::class.java

    override fun getFragmentRepository() = ProductRepository(remoteDataSource.getBaseUrl().create(
        ProductApi::class.java))
}