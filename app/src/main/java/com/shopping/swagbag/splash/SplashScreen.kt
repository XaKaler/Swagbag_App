package com.shopping.swagbag.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.shopping.swagbag.R
import com.shopping.swagbag.category.*
import com.shopping.swagbag.home.HomeModel
import com.shopping.swagbag.main_activity.MainActivity
import com.shopping.swagbag.products.ProductRepository
import com.shopping.swagbag.products.ProductViewModel
import com.shopping.swagbag.products.ProductViewModelFactory
import com.shopping.swagbag.service.RemoteDataSource
import com.shopping.swagbag.service.Resource
import com.shopping.swagbag.service.apis.CategoryApi
import com.shopping.swagbag.service.apis.ProductApi

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    private lateinit var categoryViewModel: CategoryViewModel
    private lateinit var productViewModel: ProductViewModel
    private lateinit var homeResult: HomeModel
    private lateinit var masterCategories: MasterCategoryModel
    private lateinit var allCategories: CategoryModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        initializeRepositories()
        getAllCategories()
    }

    private fun initializeRepositories() {
        val repository =
            CategoryRepository(RemoteDataSource().getBaseUrl().create(CategoryApi::class.java))
        categoryViewModel = ViewModelProvider(
            this@SplashScreen,
            CategoryViewModelFactory(repository)
        )[CategoryViewModel::class.java]

        // product repository
        val productRepository =
            ProductRepository(RemoteDataSource().getBaseUrl().create(ProductApi::class.java))
        productViewModel = ViewModelProvider(
            this@SplashScreen,
            ProductViewModelFactory(productRepository)
        )[ProductViewModel::class.java]
    }

    fun getHomeResult() = homeResult

    private fun getHomeScreenData() {
        productViewModel.getHome().observe(this) {
            when (it) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    homeResult = it.value
                    getAllCategories()
                    // sendToNext()
                }
                is Resource.Failure -> {
                    Log.e("home", "getHomeScreenData: $it")
                }
            }

        }
    }

    private fun getAllCategories() {
        categoryViewModel.getAllCategories().observe(this) {
            when (it) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    allCategories = it.value
                    getMasterCategories()
                }

                is Resource.Failure ->
                    Log.e("TAG", "setUpNavigation: $it")
            }
        }
    }

    private fun getMasterCategories() {
        categoryViewModel.masterCategory().observe(this) {
            when (it) {
                is Resource.Success -> {
                    masterCategories = it.value
                    sendToNext()
                }

                is Resource.Failure -> Toast.makeText(
                        this,
                        it.errorCode.toString(),
                        Toast.LENGTH_SHORT
                    ).show()

                    else -> {}
                }
            }
    }

    private fun sendToNext() {
        /*if (!this::allCategories.isInitialized)
            getAllCategories()
        else if (!this::homeResult.isInitialized)
            getHomeResult()
        else if (!this::masterCategories.isInitialized)
            getMasterCategories()
        else {*/
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            //intent.putExtra("home", Gson().toJson(homeResult, HomeModel::class.java))
            intent.putExtra(
                "allCategories",
                Gson().toJson(allCategories, CategoryModel::class.java)
            )
            intent.putExtra(
                "masterCategories",
                Gson().toJson(masterCategories, MasterCategoryModel::class.java)
            )
            startActivity(Intent(intent))
            finish()
        }
    //}
}