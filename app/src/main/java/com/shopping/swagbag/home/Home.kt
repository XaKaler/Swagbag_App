package com.shopping.swagbag.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.shopping.swagbag.category.CategoryToBegModel
import com.shopping.swagbag.common.GridSpaceItemDecoration
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.common.adapter.AutoImageSliderAdapter
import com.shopping.swagbag.common.adapter.BestProductAdapter
import com.shopping.swagbag.common.adapter.CategoryToBegAdapter
import com.shopping.swagbag.common.base.BaseFragment
import com.shopping.swagbag.common.model.BestProductModel
import com.shopping.swagbag.databinding.FragmentHomeBinding
import com.shopping.swagbag.databinding.LytBottomSheetBinding
import com.shopping.swagbag.main_activity.MainActivity
import com.shopping.swagbag.products.ProductRepository
import com.shopping.swagbag.products.ProductSearchParameters
import com.shopping.swagbag.products.ProductViewModel
import com.shopping.swagbag.products.product_details.ProductDetailsFragmentDirections
import com.shopping.swagbag.service.Resource
import com.shopping.swagbag.service.apis.ProductApi
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView


class Home : BaseFragment<
        FragmentHomeBinding,
        ProductViewModel,
        ProductRepository
        >(FragmentHomeBinding::inflate), RecycleViewItemClick {

    private lateinit var mainActivity: MainActivity
    private lateinit var homeResult: HomeModel
    private lateinit var bottomSheet: LytBottomSheetBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity

        if(mainActivity !is MainActivity) {
            Log.e("TAG", "onAttach: is instance of main activity")
        }
        else{
            Log.e("TAG", "onAttach:not is instance of main activity")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // handle back pressed
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            mainActivity.finish()
        }

        mainActivity.showToolbarAndBottomNavigation()
        mainActivity.setMasterCategories()

        homeResult = mainActivity.getHome()
        setData()
        setUpBottomSheet()
    }

    private fun setUpBottomSheet() {
        bottomSheet = viewBinding.includeBtmSheet
        with(bottomSheet) {
            mainActivity.run {
                //facebook
                facebook.setOnClickListener {
                    val fbLink = getSettingResult("Facebook")
                    val url = Uri.parse(fbLink)
                    val intent = Intent(Intent.ACTION_VIEW, url)
                    startActivity(intent)
                }
                //instagram
                instagram.setOnClickListener {
                    val instaLink = getSettingResult("Instagram")
                    val url = Uri.parse(instaLink)
                    val intent = Intent(Intent.ACTION_VIEW, url)
                    startActivity(intent)
                }
                //twitter
                twitter.setOnClickListener {
                    val twitterLink = getSettingResult("Twitter")
                    val url = Uri.parse(twitterLink)
                    val intent = Intent(Intent.ACTION_VIEW, url)
                    startActivity(intent)
                }
                //linkedIn
                linkedIn.setOnClickListener {
                    val linkedInLink = getSettingResult("Linkdin")
                    val url = Uri.parse(linkedInLink)
                    val intent = Intent(Intent.ACTION_VIEW, url)
                    startActivity(intent)
                }
                //message
                message.setOnClickListener {
                    val phone = getSettingResult("Mobile")
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("sms:$phone"))
                    startActivity(intent)
                }
                //email
                email.setOnClickListener {
                    val mailId = getSettingResult("Email")
                    val intent = Intent(
                        Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto", mailId, null
                        )
                    )
                    startActivity(Intent.createChooser(intent, "Choose an Email client :"))
                }
                //whatsapp
                whatsapp.setOnClickListener {
                    val phone = getSettingResult("Mobile")
                    val uri = Uri.parse("smsto:$phone")
                    val i = Intent(Intent.ACTION_SENDTO, uri)
                    i.setPackage("com.whatsapp")
                    startActivity(Intent.createChooser(i, ""))
                }
            }
        }
    }

    private fun setData() {
        setAutoImageSlider(homeResult.result.slider)
        setCategoryToBeg(homeResult.result.masterCategory)
        showOfferImages()
        setTopTrending(homeResult.result.section)
        setDealOfTheDay(homeResult.result.deals)
        //setBestOffer(homeResult.result.randomCategory)
        setFetured(homeResult.result.featured)
    }

    private fun getHomeData() {
         viewModel.getHome().observe(viewLifecycleOwner){
             when(it){
                 is Resource.Loading ->  showLoading()

                 is Resource.Success -> {
                     stopShowingLoading()

                     Log.e("TAG", "getHomeData: $it")

                     homeResult = it.value

                     setData()
                 }

                 is Resource.Failure -> Log.e("TAG", "getHomeData: $it")
             }
         }

    }

    private fun showOfferImages() {
        with(viewBinding) {
            context?.let {
                Glide.with(it)
                    .load("https://uae.swagbag.com/img/down1.png")
                    .centerCrop()
                    .into(homeImg3)

                Glide.with(it)
                    .load("https://uae.swagbag.com/img/down2.jpg")
                    .centerCrop()
                    .into(homeImg5)


            }
        }
    }

    private fun setTopTrending(sections: List<HomeModel.Result.Section>) {
        val topTrendingData = ArrayList<HomeModel.Result.Section.Banner>()

        for(section in sections){
            for(banner in section.banner){
                topTrendingData.add(banner)
            }
        }

        with(viewBinding) {
            rvTopTrending.apply {
                addItemDecoration(GridSpaceItemDecoration(20))
                layoutManager = GridLayoutManager(context, 2)
                adapter =
                    HomeTopTrendingAdapter(context, topTrendingData, object : RecycleViewItemClick {
                        override fun onItemClickWithName(name: String, position: Int) {
                            mainActivity.hideToolbarAndBottomNavigation()
                            when(name){
                                "brand" -> {
                                    val productSearchParameters = ProductSearchParameters(
                                    "",
                                    topTrendingData[position].brand!!.id,
                                    "",
                                    "",
                                    "",
                                    "",
                                    "",
                                    topTrendingData[position].masterCategory,
                                    ""
                                )
                                    val action =
                                        HomeDirections.actionHome2ToProductsFragment(
                                            Gson().toJson(
                                                productSearchParameters,
                                                ProductSearchParameters::class.java
                                            )
                                        )
                                    findNavController().navigate(action)}

                                "category" -> {
                                    val productSearchParameters = ProductSearchParameters(
                                        "",
                                        "",
                                        "",
                                        topTrendingData[position].category,
                                        "",
                                        "",
                                        "",
                                        topTrendingData[position].masterCategory,
                                        ""
                                    )
                                    val action =
                                        HomeDirections.actionHome2ToProductsFragment(
                                            Gson().toJson(
                                                productSearchParameters,
                                                ProductSearchParameters::class.java
                                            )
                                        )
                                    findNavController().navigate(action)
                                }
                                "product" -> {}
                            }
                        }
                    })
            }
        }
    }

    private fun setCategoryToBeg(data: List<HomeModel.Result.MasterCategory>) {
        val master = ArrayList<CategoryToBegModel>()

        for (item in data) {/*
            val data1 = GsonBuilder().create().toJson(item)
            master.add(GsonBuilder().create().fromJson(data1, CategoryToBegModel::class.java))*/
            master.add(
                CategoryToBegModel(
                    item.desc,
                    item.file,
                    item.id,
                    item.name,
                    item.slug,
                    item.shortDesc
                )
            )
        }

        with(viewBinding) {
            rvCategoryToBag.apply {
                layoutManager = GridLayoutManager(context, 3)
                adapter = CategoryToBegAdapter(context, master, object: RecycleViewItemClick{
                    override fun onItemClickWithName(name: String, position: Int) {
                        when(name){
                            "products" -> {
                                mainActivity.hideToolbarAndBottomNavigation()
                                val productSearchParameters = ProductSearchParameters(
                                    "",
                                    "",
                                    "",
                                    "",
                                    "",
                                    "",
                                    "",
                                    homeResult.result.masterCategory[position].slug,
                                    ""
                                )
                                val action = HomeDirections.actionHome2ToProductsFragment(Gson().toJson(productSearchParameters, ProductSearchParameters::class.java))
                                findNavController().navigate(action)
                            }
                        }
                    }
                })
            }
        }

    }

/*
    private fun setBestOffer(data: List<HomeModel.Result.RandomCategory>) {
        val allTimeSliderModel = ArrayList<AllTimeSliderModel>()
        for (item in data) {
            allTimeSliderModel.add(
                AllTimeSliderModel(
                    item.description,
                    item.file,
                    item.id,
                    item.master,
                    item.name
                )
            )
        }

        // Log.e("TAG", "setBestOffer: $allTimeSliderModel")

        with(viewBinding) {
            rvBestOffer.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = AllTimeSliderAdapter(context, allTimeSliderModel, this@Home)
            }
        }

    }*/

    private fun setDealOfTheDay(data: List<HomeModel.Result.Deal>) {
        val bestProductModel = ArrayList<BestProductModel>()

        for (item in data) {
            val file = ArrayList<BestProductModel.File>()
            for (fileItem in item.file) {
                file.add(
                    BestProductModel.File(
                        fileItem.location
                    )
                )
            }

            bestProductModel.add(
                BestProductModel(
                    html2Text(item.desc),
                    item.shortDesc,
                    file,
                    item.id,
                    item.name,
                    item.slug
                )
            )
        }

        with(viewBinding) {
            rvDealOfTheDay.apply {
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
                adapter = BestProductAdapter(context, bestProductModel, this@Home )
            }
        }
    }

    private fun setFetured(data: List<HomeModel.Result.Featured>) {
        val bestProductModel = ArrayList<BestProductModel>()

        for (item in data) {
            val file = ArrayList<BestProductModel.File>()
            for (fileItem in item.file) {
                file.add(
                    BestProductModel.File(
                        fileItem.location
                    )
                )
            }

            bestProductModel.add(
                BestProductModel(
                    html2Text(item.desc),
                    item.shortDesc,
                    file,
                    item.id,
                    item.name,
                    item.slug
                )
            )
        }

        with(viewBinding) {
            rvKidsPicks.apply {
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
                adapter = BestProductAdapter(context, bestProductModel, this@Home)
            }
        }
    }

    private fun setAutoImageSlider(data: List<HomeModel.Result.Slider>) {
        with(viewBinding) {
            sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR;

            // below method is used to
            // set adapter to sliderview.
            context?.let { AutoImageSliderAdapter(it, data) }
                ?.let { sliderView.setSliderAdapter(it) }

            // below method is use to set
            // scroll time in seconds.
            sliderView.scrollTimeInSec = 5

            // to set it scrollable automatically
            // we use below method.
            sliderView.isAutoCycle = true

            sliderView.setIndicatorAnimation(IndicatorAnimationType.THIN_WORM)
            sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
            sliderView.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH

            // to start auto cycle below method is used.
            sliderView.startAutoCycle()
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun getViewModel() = ProductViewModel::class.java

    override fun getFragmentRepository() =
        ProductRepository(remoteDataSource.getBaseUrl().create(ProductApi::class.java))

    override fun onItemClickWithName(name: String, position: Int) {
        mainActivity.hideToolbarAndBottomNavigation()
        val action = ProductDetailsFragmentDirections.actionGlobalProductDetailsFragment(name)
        findNavController().navigate(action)
    }

}
