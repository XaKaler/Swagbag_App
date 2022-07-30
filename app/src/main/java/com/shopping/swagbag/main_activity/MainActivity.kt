package com.shopping.swagbag.main_activity

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.badge.BadgeDrawable
import com.google.gson.Gson
import com.shopping.swagbag.R
import com.shopping.swagbag.category.*
import com.shopping.swagbag.category.particular_category.ParticularCategoryFragmentDirections
import com.shopping.swagbag.common.ProgressDialogFragment
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.common.adapter.CategorySliderAdapter
import com.shopping.swagbag.common.base.GeneralFunction
import com.shopping.swagbag.databinding.ActivityMainBinding
import com.shopping.swagbag.databinding.MainToolbarBinding
import com.shopping.swagbag.databinding.NavigationDrawerBinding
import com.shopping.swagbag.databinding.NavigationHeaderBinding
import com.shopping.swagbag.home.HomeModel
import com.shopping.swagbag.products.ProductRepository
import com.shopping.swagbag.products.ProductViewModel
import com.shopping.swagbag.products.ProductViewModelFactory
import com.shopping.swagbag.products.filter.ExtraFilterModel
import com.shopping.swagbag.service.RemoteDataSource
import com.shopping.swagbag.service.Resource
import com.shopping.swagbag.service.apis.CategoryApi
import com.shopping.swagbag.service.apis.ProductApi
import com.shopping.swagbag.service.apis.SettingApi
import com.shopping.swagbag.service.apis.UserApi
import com.shopping.swagbag.settings.SettingRepository
import com.shopping.swagbag.settings.SettingViewModelFactory
import com.shopping.swagbag.settings.SettingsModel
import com.shopping.swagbag.user.UserViewModelFactory
import com.shopping.swagbag.user.auth.UserRepository
import com.shopping.swagbag.user.auth.UserViewModel
import com.shopping.swagbag.user.wallet.WalletModel
import com.shopping.swagbag.utils.AppUtils
import com.shopping.swagbag.utils.SettingViewModel


class MainActivity : AppCompatActivity(), RecycleViewItemClick{

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var productViewModel: ProductViewModel
    private lateinit var settingViewModel: SettingViewModel
    private lateinit var userViewModel: UserViewModel
    private lateinit var settingResult: SettingsModel
    private lateinit var walletResult: WalletModel
    private lateinit var homeResult: HomeModel
    private lateinit var extraFilter: ExtraFilterModel
    private lateinit var masterCategories: MasterCategoryModel
    private var appUtils = AppUtils(this@MainActivity)
    private lateinit var progressDialog: ProgressDialogFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setUPToolbar()
        setUpBottomNavigation()
        initializeRepositories()
        setUpNavigationHeader()
        setUpNavigation()
        setMasterCategories()
        apiCalls()
    }

    private fun setUpBottomNavigation() {
        with(viewBinding) {
            //show item count of wishlist and cart
            //cart badge
            val cartBadge: BadgeDrawable = btmNavigation.getOrCreateBadge(
                R.id.btmCart
            )
            cartBadge.backgroundColor = R.color.steel_teal
            if(GeneralFunction.cartItemCount.isNotEmpty()){
                cartBadge.number = GeneralFunction.cartItemCount.toInt()
                cartBadge.isVisible = true
            }else
                cartBadge.isVisible = false

            //wishlist badge
            val wishlistBadge: BadgeDrawable = btmNavigation.getOrCreateBadge(
                R.id.btmCart
            )
            wishlistBadge.backgroundColor = R.color.steel_teal
            if(GeneralFunction.wishlistItemCount.isNotEmpty()){
                wishlistBadge.number = GeneralFunction.wishlistItemCount.toInt()
                wishlistBadge.isVisible = true
            }else
                wishlistBadge.isVisible = false

            //handle bottom navigation click listeners
            btmNavigation.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.btmWishlist -> {
                        hideToolbarAndBottomNavigation()
                        val navHostFragment =
                            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_home) as NavHostFragment
                        val navController = navHostFragment.navController

                        if (appUtils.isUserLoggedIn())
                            navController.navigate(R.id.action_global_wishlistWithProductFragment)
                        else
                            navController.navigate(R.id.action_global_signInFragment)
                    }

                    R.id.btmCart -> {
                        hideToolbarAndBottomNavigation()
                        val navHostFragment =
                            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_home) as NavHostFragment
                        val navController = navHostFragment.navController

                        if (appUtils.isUserLoggedIn())
                            navController.navigate(R.id.action_global_shoppingBegWithProductFragment)
                        else
                            navController.navigate(R.id.action_global_signInFragment)
                    }

                    R.id.btmCategory -> {
                        hideToolbarAndBottomNavigation()
                        val navHostFragment =
                            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_home) as NavHostFragment
                        val navController = navHostFragment.navController
                        navController.navigate(R.id.action_global_categoryFragment)
                    }

                    R.id.btmOffers -> {
                        hideToolbarAndBottomNavigation()
                        val navHostFragment =
                            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_home) as NavHostFragment
                        val navController = navHostFragment.navController
                        navController.navigate(R.id.action_global_brandFragment)
                    }

                    R.id.btmAccount -> {
                        hideToolbarAndBottomNavigation()
                        val navHostFragment =
                            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_home) as NavHostFragment
                        val navController = navHostFragment.navController

                        if (appUtils.isUserLoggedIn())
                            navController.navigate(R.id.action_global_accountFragment)
                        else
                            navController.navigate(R.id.action_global_signInFragment)

                    }
                }
                true
            }
        }
    }

    private fun initializeRepositories() {
        // category repository
        val repository =
            CategoryRepository(RemoteDataSource().getBaseUrl().create(CategoryApi::class.java))
        categoryViewModel = ViewModelProvider(
            this@MainActivity,
            CategoryViewModelFactory(repository)
        )[CategoryViewModel::class.java]

        // setting repository
        val settingRepository =
            SettingRepository(RemoteDataSource().getBaseUrl().create(SettingApi::class.java))
        settingViewModel = ViewModelProvider(
            this@MainActivity,
            SettingViewModelFactory(settingRepository)
        )[SettingViewModel::class.java]

        // product repository
        val productRepository =
            ProductRepository(RemoteDataSource().getBaseUrl().create(ProductApi::class.java))
        productViewModel = ViewModelProvider(
            this@MainActivity,
            ProductViewModelFactory(productRepository)
        )[ProductViewModel::class.java]

        //user repository
        val userRepository =
            UserRepository(RemoteDataSource().getBaseUrl().create(UserApi::class.java))
        userViewModel = ViewModelProvider(
            this@MainActivity,
            UserViewModelFactory(userRepository)
        )[UserViewModel::class.java]

    }

    private fun apiCalls() {
        getSettings()
        getExtraFilter()
    }

    private fun getExtraFilter() {
        productViewModel.extraFilter().observe(this){
            when(it){
                is Resource.Loading -> {}
                is Resource.Success -> {
                    extraFilter = it.value
                    AppUtils(this).saveExtraFilter(extraFilter)
                }
                is Resource.Failure -> {}
            }
        }
    }

    fun setUpNavigationHeader() {
        with(viewBinding.includeNavigation.includeHeader) {
            closeDrawer.setOnClickListener {
                closeDrawer()
            }
            if (AppUtils(this@MainActivity).isUserLoggedIn()) {
                val user = AppUtils(this@MainActivity).getUser()
                navHeaderUserName.text = user?.result?.fname
                navHeaderUserEmail.text = user?.result?.email
            }
        }
    }

    fun setMasterCategories() {
        val intentData = intent
        masterCategories =
                Gson().fromJson(
                    intentData.getStringExtra("masterCategories"),
                    MasterCategoryModel::class.java
            )

        Log.e("master", "$masterCategories\n" +
                "view binding is initialized : ${this::viewBinding.isInitialized}")

        if (this::viewBinding.isInitialized) {
            viewBinding.rvCategorySlider.apply {
                layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter =
                    CategorySliderAdapter(
                        this@MainActivity,
                        masterCategories.result,
                        this@MainActivity
                    )
            }
        }
    }

     fun getMasterCategories(): List<MasterCategoryModel.Result> {
        return if(this::masterCategories.isInitialized)
            masterCategories.result
        else {
            val intentData = intent
                Gson().fromJson(
                    intentData.getStringExtra("masterCategories"),
                    MasterCategoryModel::class.java
                ).result
        }
    }

    private fun setUPToolbar() {
        with(viewBinding.toolbar) {
            imgToggle.setOnClickListener {
                // open drawer when user click on toggle button
                if (!viewBinding.drawerLayout.isDrawerOpen(GravityCompat.START))
                    viewBinding.drawerLayout.openDrawer(GravityCompat.START)
                else
                    viewBinding.drawerLayout.closeDrawer(GravityCompat.END)
            }

            fragmentSearch.setOnClickListener {
                hideToolbarAndBottomNavigation()
                val navHostFragment =
                    supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_home) as NavHostFragment
                val navController = navHostFragment.navController
                navController.navigate(R.id.action_global_searchFragment)
            }

            fragmentNotificaiton.setOnClickListener {
                hideToolbarAndBottomNavigation()
                val navHostFragment =
                    supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_home) as NavHostFragment
                val navController = navHostFragment.navController
                navController.navigate(R.id.action_global_notificationFragment)
            }
        }
    }

    private fun setUpNavigation() {
        val intentData = intent
        val allCategories: CategoryModel =
            Gson().fromJson(
                intentData.getStringExtra("allCategories"),
                CategoryModel::class.java
            )

        //disable the swipe gesture that opens the navigation drawer
        viewBinding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        with(viewBinding.includeNavigation) {
            progressBar.visibility = View.GONE
            // add navigation menu
            val navigationMenu: List<NavigationMenu> = OnNavigationMenu().getNavigationMenu()

            rvnavMenu.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = NavigationMenuAdapter(
                    this@MainActivity,
                    navigationMenu,
                    allCategories.result
                )
            }
        }
    }

    fun showToolbarAndBottomNavigation() {
        if (this::viewBinding.isInitialized) {
            viewBinding.toolbar.root.visibility = View.VISIBLE
            viewBinding.btmNavigation.visibility = View.VISIBLE
            viewBinding.rvCategorySlider.visibility = View.VISIBLE
        }
    }

    fun hideToolbarAndBottomNavigation() {
        viewBinding.toolbar.root.visibility = View.GONE
        viewBinding.btmNavigation.visibility = View.GONE
        viewBinding.rvCategorySlider.visibility = View.GONE
    }

    fun closeDrawer() {
        viewBinding.drawerLayout.closeDrawer(Gravity.LEFT)
    }

    fun getSettingResult(name: String): String {

        var result: String = ""
        for (settingName in settingResult.result) {
            // Log.e("TAG", "setting name is : ${settingName.name}", )
            if (settingName.name == name) {
                result = settingName.value
            }
        }

         Log.e("setting result", "getSettingResult: $name\n" +
                 "setting result is : $result", )

        return result
    }

    fun getReturnReason() = settingResult.returnReason

    fun getDeactivateAccountReason() = settingResult.deactivateReason

    private fun getSettings() {
        settingViewModel.settings().observe(this) {
            when (it) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    settingResult = it.value
                }

                is Resource.Failure -> {
                    Log.e("settings", "getSettings: $it")
                }
            }
        }
    }

    fun getHome(): HomeModel = Gson().fromJson(intent.getStringExtra("home"), HomeModel::class.java)

    fun showLoading() {
        val manager = this.supportFragmentManager
        progressDialog = ProgressDialogFragment.newInstance()
        progressDialog.isCancelable = false
        progressDialog.show(manager, "progress")
    }

    fun stopShowingLoading() {
        if (this::progressDialog.isInitialized) {
            progressDialog.dismiss()
        }
    }

    override fun onItemClickWithName(name: String, position: Int) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_home) as NavHostFragment
        val navController = navHostFragment.navController
        val action = ParticularCategoryFragmentDirections.actionGlobalParticularCategoryFragment(
            masterCategories.result[position].id
        )
        navController.navigate(action)

    }

    override fun onItemClickWithView(name: String, view: View, position: Int) {
        super.onItemClickWithView(name, view, position)
        val rv = view as RecyclerView

    }

    override fun onDestroy() {
        super.onDestroy()
        val appUtils = AppUtils(this)
        appUtils.removeHomePageData()
    }
}