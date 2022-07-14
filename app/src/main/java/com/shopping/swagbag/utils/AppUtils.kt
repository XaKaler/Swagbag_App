package com.shopping.swagbag.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.gson.Gson
import com.shopping.swagbag.user.auth.signin.SignInModel

class AppUtils(private val context: Context) {

    private val _myPrefName = "sharePrefName"
    private val _userData = "user_data"
    private val _isUserLogIn = "user_login"

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

    fun logOut(){
        val editor: SharedPreferences.Editor = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE).edit()
        // editor.putBoolean(_isUserLogIn, false)
        editor.clear()
        editor.apply()
    }
}
/*
package com.shopping.swagbag.utils

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.gson.Gson
import com.shopping.swagbag.user.auth.signin.SignInModel

class AppUtils(private val context: Context) {

    private val _myPrefName = "sharePrefName"
    private val _userData = "user_data"
    private val _isUserLogIn = "user_login"

    fun saveUser(user: SignInModel){
       val editor: SharedPreferences.Editor = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE).edit()
        editor.putString(_userData, Gson().toJson(user, SignInModel::class.java))
        editor.putBoolean(_isUserLogIn, true)
        editor.apply()
    }

    fun getUser(): Any?{
        return when(signInWith()){
            "Email" -> {
                val sharedPreferences = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE)
                val user =sharedPreferences.getString(_userData, "")
                return Gson().fromJson(user, SignInModel::class.java)
            }
            "Google" -> {
                val signInWithGoogleAccount:GoogleSignInAccount? = GoogleSignIn.getLastSignedInAccount(context)
                signInWithGoogleAccount
            }
            else -> null
        }

    }

    fun getUserId(): String?{
        return when(signInWith()){
            "Email" -> {
                val sharedPreferences = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE)
                val user =sharedPreferences.getString(_userData, "")
                val singInUser: SignInModel =  Gson().fromJson(user, SignInModel::class.java)
                singInUser.result.id
            }
            "Google" -> {
                val signInWithGoogleAccount:GoogleSignInAccount? = GoogleSignIn.getLastSignedInAccount(context)
                signInWithGoogleAccount?.id
            }
            else -> null
        }
    }

    private fun signInWith(): String?{
        val sharedPreferences = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE)
        val signInWithEmail = sharedPreferences.getBoolean(_isUserLogIn, false)
        val signInWithGoogleAccount:GoogleSignInAccount? = GoogleSignIn.getLastSignedInAccount(context)

        return if(signInWithEmail)
            "Email"
        else if(signInWithGoogleAccount!=null)
            "Google"
        else
            null
    }

    fun getUserToken(): String?{
        return when(signInWith()){
            "Email" -> {
                val sharedPreferences = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE)
                val signInWithEmail = sharedPreferences.getBoolean(_isUserLogIn, false)
                val user =sharedPreferences.getString(_userData, "")
                val singInUser: SignInModel =  Gson().fromJson(user, SignInModel::class.java)
                singInUser.token
            }
            "Google" -> {
                val signInWithGoogleAccount:GoogleSignInAccount? = GoogleSignIn.getLastSignedInAccount(context)
                signInWithGoogleAccount?.idToken
            }
            else -> null
        }
    }


    fun isUserLoggedIn(): Boolean{
        val sharedPreferences = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE)
        val signInWithEmail = sharedPreferences.getBoolean(_isUserLogIn, false)
        val signInWithGoogle = GoogleSignIn.getLastSignedInAccount(context)?.account

        Log.e("google", signInWithGoogle.toString())

        return signInWithEmail || signInWithGoogle!=null
    }

    fun logOut(){
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(_myPrefName, Context.MODE_PRIVATE)
        val signInWithEmail = sharedPreferences.getBoolean(_isUserLogIn, false)
        val signInWithGoogle = GoogleSignIn.getLastSignedInAccount(context)?.account
       // editor.putBoolean(_isUserLogIn, false)

        if(signInWithEmail) {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
        }
        else if(signInWithGoogle != null){
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
            val gsc = GoogleSignIn.getClient(context, gso)
            gsc.signOut()
        }
    }
}
*/
