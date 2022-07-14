package com.shopping.swagbag.search

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.shopping.swagbag.R
import com.shopping.swagbag.common.Dialogs
import com.shopping.swagbag.common.GridSpaceItemDecoration
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.common.base.BaseFragment
import com.shopping.swagbag.common.base.GeneralFunction
import com.shopping.swagbag.common.views.BottomFilterDialog
import com.shopping.swagbag.databinding.FragmentSearchBinding
import com.shopping.swagbag.databinding.LytProductMenuBinding
import com.shopping.swagbag.databinding.SearchBarBinding
import com.shopping.swagbag.databinding.ToolbarWithNoMenuWhiteBgBinding
import com.shopping.swagbag.products.ProductRepository
import com.shopping.swagbag.products.ProductViewModel
import com.shopping.swagbag.service.Resource
import com.shopping.swagbag.service.apis.ProductApi
import com.shopping.swagbag.utils.AppUtils


class SearchFragment : BaseFragment<
        FragmentSearchBinding,
        ProductViewModel,
        ProductRepository
        >( FragmentSearchBinding::inflate), View.OnClickListener {

    private lateinit var toolbarBinding: ToolbarWithNoMenuWhiteBgBinding
    private lateinit var productMenuBinding: LytProductMenuBinding
    private lateinit var searchBarBinding: SearchBarBinding
    private lateinit var filterDialog: BottomFilterDialog
    private lateinit var searchBar: EditText
    private lateinit var searchProduct: MobileProductSearchModel
    private val masterCategoryList = ArrayList<String>()
    private var currentMasterCategory = ""
    private var currentMasterCategoryItems = ArrayList<MobileProductSearchModel.Result.Product>()
    private val productMap = mutableMapOf<String, List<MobileProductSearchModel.Result.Product>>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarBinding = viewBinding.include
        searchBarBinding = viewBinding.lytSearchBar
        productMenuBinding = viewBinding.includeProductMenu

        searchBar = view.findViewById(R.id.searchBar) as EditText

        initViews()
    }

    private fun initViews() {
        // click listeners
        with(searchBarBinding) {
            searchByImage.setOnClickListener(this@SearchFragment)
            searchByVoice.setOnClickListener(this@SearchFragment)
        }

        if (this::searchProduct.isInitialized)
            showSearchResult(currentMasterCategoryItems)
        else
            showSoftKeyboard(searchBar)

        searchBar.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                // get text that user enter
                val userSearch = searchBarBinding.searchBar.text.toString()
                productSearch(userSearch)

                return@OnEditorActionListener true
            }
            false
        })
        searchBar.requestFocus()

        setToolbar()
    }

    private fun showSoftKeyboard(view: View) {
        if (view.requestFocus()) {
            val imm: InputMethodManager =
                context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    private fun productSearch(userSearch: String) {
        viewModel.productSearch(userSearch)
            .observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> showLoading()

                    is Resource.Success -> {
                        stopShowingLoading()
                        searchProduct = it.value
                        if (it.value.result.isEmpty())
                            showNoProductFound()
                        else {/*
                            viewBinding.lytSearchBar.root.visibility = View.GONE
                            viewBinding.includeProductMenu.root.visibility = View.VISIBLE*/

                            //separate data
                            masterCategoryList.clear()
                            productMap.clear()
                            for (singleResult in searchProduct.result) {
                                if (singleResult.product.isNotEmpty()) {
                                    masterCategoryList.add(singleResult.masterCategory.name)
                                    productMap[singleResult.masterCategory.name] =
                                        singleResult.product

                                    //show 1st category data
                                    currentMasterCategory = masterCategoryList[0]
                                    currentMasterCategoryItems =
                                        productMap[currentMasterCategory]!! as ArrayList

                                    //when user click on master category then show him a list dialog
                                    //after click on any item in list then show related result
                                    setProductMenu()
                                    showSearchResult(currentMasterCategoryItems)
                                }
                            }

                            //if no product found related search query then show sorry! no product found
                            if(masterCategoryList.isEmpty())
                                showNoProductFound()
                        }
                    }

                    is Resource.Failure -> {
                        stopShowingLoading()

                        toast("try again")

                        Log.e("productSearch", "$it")
                    }
                }
            }
    }

    private fun setProductMenu() {
        with(productMenuBinding) {
            //set sort by list
            tvSortBy.setOnClickListener {
                openListDialog(
                    tvSortBy,
                    GeneralFunction.getSortBY(),
                    false
                ) { result ->
                    when (result) {
                        "Default" -> {
                            showSearchResult(currentMasterCategoryItems)
                        }
                        "Latest" -> {
                            currentMasterCategoryItems.sortByDescending { r -> r.createdDate }
                            showSearchResult(currentMasterCategoryItems)
                        }
                        "Sort forward price low" -> {
                            currentMasterCategoryItems.sortBy { r -> r.price }
                            showSearchResult(currentMasterCategoryItems)
                        }
                        "Sort forward price high" -> {
                            currentMasterCategoryItems.sortByDescending { r -> r.price }
                            showSearchResult(currentMasterCategoryItems)
                        }
                    }
                }
            }

            //set master category list
            masterCategoryName.setOnClickListener {
                openListDialog(
                    masterCategoryName,
                    masterCategoryList.toTypedArray(),
                    true
                ) { result ->
                    for (singleMasterCategory in masterCategoryList) {
                        if (result == singleMasterCategory) {
                            currentMasterCategory = result
                            currentMasterCategoryItems =
                                productMap[currentMasterCategory]!! as ArrayList
                            showSearchResult(currentMasterCategoryItems)
                        }
                    }
                }
            }

            //filter
            tvFilter.setOnClickListener {
                    filterDialog.show(childFragmentManager, "filter")
            }
        }
    }

    private fun showNoProductFound() {
        productMenuBinding.root.visibility = View.GONE
        with(viewBinding) {
            rvSearchProducts.visibility = View.GONE
            noProductFound.visibility = View.VISIBLE
        }
    }

    private fun showSearchResult(product: List<MobileProductSearchModel.Result.Product>) {

        viewBinding.includeProductMenu.root.visibility = View.VISIBLE
        productMenuBinding.masterCategoryName.text = currentMasterCategory

        //filterDialog = BottomFilterDialog(currentMasterCategory)
//        filterDialog.getCategoryFilter()

        with(viewBinding) {
            rvSearchProducts.visibility = View.VISIBLE
            noProductFound.visibility = View.GONE

            rvSearchProducts.apply {
                layoutManager = GridLayoutManager(context, 2)
                addItemDecoration(GridSpaceItemDecoration(5))
                adapter = HeaderSearchAdapter(context, product, object : RecycleViewItemClick {
                    override fun onItemClickWithName(name: String, position: Int) {
                        val action =
                            SearchFragmentDirections.actionGlobalProductDetailsFragment(name)
                        findNavController().navigate(action)
                    }

                    override fun onItemClickWithView(name: String, view: View, position: Int) {
                        super.onItemClickWithView(name, view, position)
                        if (AppUtils(context!!).isUserLoggedIn())
                            addToWishlist(name, view)
                        else
                            findNavController().navigate(R.id.action_global_signInFragment)
                    }
                })
            }
        }
    }

    private fun addToWishlist(productId: String, view: View) {
        val imgView = view as ImageView
        val userId = AppUtils(context!!).getUserId()
        viewModel.addToWishList(productId, userId).observe(viewLifecycleOwner){
            when(it){
                is Resource.Loading -> showLoading()
                is Resource.Success -> {
                    stopShowingLoading()
                    toast(it.value.message)
                    imgView.setImageResource(R.drawable.product_in_wishlist)
                }
                is Resource.Failure -> stopShowingLoading()
            }
        }
    }

    private fun setToolbar() {
        with(toolbarBinding) {
            // set title
            tvTitle.text = getString(R.string.search)

            // back button click
            imgBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.searchByImage -> findNavController().navigate(R.id.action_searchFragment_to_dialogSearchUsing)

            R.id.searchByVoice -> checkMicPermission()
        }
    }

    private fun checkMicPermission() {
        if (context?.let {
                ContextCompat.checkSelfPermission(
                    it,
                    android.Manifest.permission.RECORD_AUDIO
                )
            } == PackageManager.PERMISSION_DENIED) {
            activity?.let {
                ActivityCompat.requestPermissions(
                    it,
                    arrayOf(android.Manifest.permission.RECORD_AUDIO),
                    0
                )
            }
        } else {
            findNavController().navigate(R.id.action_searchFragment_to_search_using_microphone)
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSearchBinding.inflate(inflater, container, false)

    override fun getViewModel() = ProductViewModel::class.java

    override fun getFragmentRepository() =
        ProductRepository(remoteDataSource.getBaseUrl().create(ProductApi::class.java))

}