package com.shopping.swagbag.user.auth.signin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.facebook.AccessToken
import com.facebook.CallbackManager.Factory.create
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignIn.getLastSignedInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.shopping.swagbag.R
import com.shopping.swagbag.common.base.BaseFragment
import com.shopping.swagbag.databinding.FragmentSignInBinding
import com.shopping.swagbag.main_activity.MainActivity
import com.shopping.swagbag.service.Resource
import com.shopping.swagbag.service.apis.UserApi
import com.shopping.swagbag.user.auth.UserRepository
import com.shopping.swagbag.user.auth.UserViewModel
import com.shopping.swagbag.utils.AppUtils


class SignInFragment :
    BaseFragment<
            FragmentSignInBinding,
            UserViewModel,
            UserRepository>
        (FragmentSignInBinding::inflate) {

    private lateinit var mainActivity: MainActivity
    private var callbackManager = create()
    private val signInResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val data: Intent? = it.data
                val task: Task<GoogleSignInAccount> =
                    GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    task.getResult(ApiException::class.java)
                    //signInUserWithGoogle()
                    Log.e("google", task.result.idToken.toString())
                    val gso =
                        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail()
                            .build()
                    val gsc = GoogleSignIn.getClient(context!!, gso)
                    gsc.signOut()
                    moveToHome()
                } catch (e: ApiException) {
                    toast("Something went wrong!")
                }
            }
        }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun moveToHome() {
        findNavController().navigate(R.id.action_global_home2)
    }

    private fun initViews() {
        registerFacebookCallback()

        with(viewBinding) {
            btnSignIn.setOnClickListener { signInUser() }
            btnGoogle.setOnClickListener {
                val gso =
                    GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail()
                        .build()
                val gsc = GoogleSignIn.getClient(context!!, gso)
                val intent = gsc.signInIntent
                signInResultLauncher.launch(intent)
            }
            btnFacebook.setOnClickListener {
                LoginManager.getInstance()
                    .logInWithReadPermissions(this@SignInFragment, listOf("public_profile"))
            }
            signUp.setOnClickListener { findNavController().navigate(R.id.action_signInFragment_to_signUpFragment) }
            forgotPassword.setOnClickListener { findNavController().navigate(R.id.action_signInFragment_to_resetPassword) }
        }
    }

    private fun registerFacebookCallback() {
        LoginManager.getInstance()
            .registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
                override fun onCancel() {
                    Log.e("facebook", "when login is cancel")
                }

                override fun onError(error: FacebookException) {
                    Log.e("facebook", "Error is -> $error")
                }

                override fun onSuccess(result: LoginResult) {
                    val accessToken = AccessToken.getCurrentAccessToken()
                    val request = GraphRequest.newMeRequest(
                        accessToken
                    ) { obj, _ ->
                        //signInUserWithFacebook(accessToken?.token, obj?.getString("email"))
                        Log.e("facebook", obj!!.getString("name"))
                    }

                    val parameters = Bundle()
                    parameters.putString("fields", "id,name,link")
                    request.parameters = parameters
                    request.executeAsync()
                    moveToHome()
                }
            })
        callbackManager = create()
    }

    private fun signInUserWithFacebook(accessToken: String?, email: String?) {
        viewModel.loginWithFacebook(accessToken!!, email!!).observe(viewLifecycleOwner){
            when(it){
                is Resource.Loading -> showLoading()
                is Resource.Success -> stopShowingLoading()
                is Resource.Failure -> stopShowingLoading()
            }
        }
    }

    private fun signInUserWithGoogle() {
        val acct: GoogleSignInAccount? = getLastSignedInAccount(context!!)
        viewModel.loginWithGoogle(acct?.idToken.toString(), acct?.email.toString())
            .observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> showLoading()
                    is Resource.Success -> stopShowingLoading()
                    is Resource.Failure -> stopShowingLoading()
                }
            }
    }

    private fun signInUser() {
        with(viewBinding) {
            val userName = userName.text.toString()
            val password = password.text.toString()

            viewModel.login(userName, password).observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> showLoading()

                    is Resource.Success -> {
                        stopShowingLoading()

                        val loginResponse = it.value

                        if (loginResponse.status == "error")
                            toast(loginResponse.message)
                        else {
                            toast(loginResponse.message)
                            context?.let { it1 -> AppUtils(it1).saveUser(loginResponse) }
                            mainActivity.setUpNavigationHeader()
                            mainActivity.getWallet()
                            moveToHome()
                        }
                    }

                    is Resource.Failure -> toast("${it.errorBody}")
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSignInBinding.inflate(inflater, container, false)

    override fun getViewModel() = UserViewModel::class.java

    override fun getFragmentRepository() =
        UserRepository(remoteDataSource.getBaseUrl().create(UserApi::class.java))

}