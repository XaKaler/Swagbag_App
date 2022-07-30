package com.shopping.swagbag.utils

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.gson.Gson
import com.shopping.swagbag.home.HomeModel
import com.shopping.swagbag.products.filter.ExtraFilterModel
import com.shopping.swagbag.user.auth.signin.SignInModel

class AppUtils(private val context: Context) {

    private val _myPrefName = "sharePrefName"
    private val _userData = "user_data"
    private val _isUserLogIn = "user_login"
    private val _extraFilter = "extra_filter"
    private val _homeScreenData = "home_screen_data"

    fun saveUser(user: SignInModel){
        val editor: SharedPreferences.Editor = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE).edit()
        editor.putString("user_data", Gson().toJson(user, SignInModel::class.java))
        editor.putBoolean(_isUserLogIn, true)
        editor.apply()
    }

    fun getUser(): SignInModel?{
        val sharedPreferences = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE)
        val user =sharedPreferences.getString(_userData, "")

        if(TextUtils.isEmpty(user))
            return null
        return Gson().fromJson(user, SignInModel::class.java)
    }

    fun getUserId(): String{
        val sharedPreferences = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE)
        val user =sharedPreferences.getString(_userData, "")

        val singInUser: SignInModel =  Gson().fromJson(user, SignInModel::class.java)
        return singInUser.result.id
    }


    fun getUserToken(): String{
        val sharedPreferences = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE)
        val user =sharedPreferences.getString(_userData, "")

        val singInUser: SignInModel =  Gson().fromJson(user, SignInModel::class.java)
        return singInUser.token
    }



    fun isUserLoggedIn(): Boolean{
        val sharedPreferences = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE)
        val acct: GoogleSignInAccount? = GoogleSignIn.getLastSignedInAccount(context)
        var isLoggedIn = false

        if(sharedPreferences.getBoolean(_isUserLogIn, false))
            isLoggedIn = true
        else if(acct!=null)
            isLoggedIn = true

        return isLoggedIn
    }

    fun logOut() {
        val editor: SharedPreferences.Editor =
            context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE).edit()
        // editor.putBoolean(_isUserLogIn, false)
        editor.clear()
        editor.apply()
    }


    //<---------------   save api data  ------------------>
    //extra filter
    fun saveExtraFilter(extraFilter: ExtraFilterModel) {
        val editor: SharedPreferences.Editor =
            context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE).edit()
        editor.putString(_extraFilter, Gson().toJson(extraFilter, ExtraFilterModel::class.java))
        editor.apply()
    }

    //home page
    fun saveHomePageData(homePage: HomeModel) {
        val editor: SharedPreferences.Editor =
            context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE).edit()
        editor.putString(_homeScreenData, Gson().toJson(homePage, HomeModel::class.java))
        editor.apply()
    }

    fun getHomePageData(): HomeModel? {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE)
        val homePage = sharedPreferences.getString(_homeScreenData, "")

        return if (TextUtils.isEmpty(homePage))
            null
        else
            Gson().fromJson(homePage, HomeModel::class.java)
    }

    fun removeHomePageData(){
        val sharedPreferences = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE).edit()
        sharedPreferences.remove(_homeScreenData)
    }
}
