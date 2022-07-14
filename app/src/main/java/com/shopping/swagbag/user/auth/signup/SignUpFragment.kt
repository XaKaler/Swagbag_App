package com.shopping.swagbag.user.auth.signup

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.shopping.swagbag.R
import com.shopping.swagbag.common.base.BaseFragment
import com.shopping.swagbag.databinding.FragmentSignUpBinding
import com.shopping.swagbag.service.Resource
import com.shopping.swagbag.service.apis.UserApi
import com.shopping.swagbag.user.auth.UserRepository
import com.shopping.swagbag.user.auth.UserViewModel
import com.shopping.swagbag.utils.AppUtils


class SignUpFragment : BaseFragment<
        FragmentSignUpBinding,
        UserViewModel,
        UserRepository
        >(FragmentSignUpBinding::inflate) {

    private var callbackManager = CallbackManager.Factory.create()
    private val signInResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                Log.e("gogole", it.data.toString())
                val data: Intent? = it.data
                val task: Task<GoogleSignInAccount> =
                    GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    task.getResult(ApiException::class.java)
                    signUpUserWithGoogle()
                    val gso =
                        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail()
                            .build()
                    val gsc = GoogleSignIn.getClient(context!!, gso)
                    gsc.signOut()
                    //moveToHome()
                } catch (e: ApiException) {
                    toast("Something went wrong!")
                }
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        registerFacebookCallback()
        with(viewBinding) {
            signIn.setOnClickListener { findNavController().navigate(R.id.action_signUpFragment_to_signInFragment) }

            btnSignUp.setOnClickListener { signUp() }

            btnFacebook.setOnClickListener {
                LoginManager.getInstance()
                    .logInWithReadPermissions(this@SignUpFragment, listOf("public_profile"))
            }

            btnGoogle.setOnClickListener {
                val web_client_id= getString(R.string.default_google_web_client_id)
                val gso =
                    GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(web_client_id)
                       // .requestServerAuthCode(web_client_id)
                        .requestEmail()
                        .build()
                val gsc = GoogleSignIn.getClient(context!!, gso)
                val intent = gsc.signInIntent
                signInResultLauncher.launch(intent)
            }
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
                       /* signUpUserWithFacebook(
                            accessToken?.token,
                            obj?.getString("email"),
                            obj?.getString("fname"),
                            obj?.getString("lname")
                        )*/
                        Log.e("facebook", obj!!.getString("name"))
                    }

                    val parameters = Bundle()
                    parameters.putString("fields", "id,name,link")
                    request.parameters = parameters
                    request.executeAsync()
                }
            })
        callbackManager = CallbackManager.Factory.create()
    }

    private fun signUp() {
        with(viewBinding) {
            val fName = firstName.text.toString()
            val lName = lastName.text.toString()
            val email = email.text.toString()
            val password = password.text.toString()
            val reffer_by = ""

            // first check any view is not empty
            if (
                fName.isNotEmpty() &&
                lName.isNotEmpty() &&
                email.isNotEmpty() &&
                password.isNotEmpty()
            ) {
                viewModel.register(fName, lName, email, password, reffer_by)
                    .observe(viewLifecycleOwner, Observer {
                        when (it) {
                            is Resource.Loading -> showLoading()

                            is Resource.Success -> {
                                stopShowingLoading()

                                val result = it.value

                                if (result.status == "success") {
                                    //move user to home page
                                    //@todo save user in app utils
                                   // saveUser(email, password)
                                    moveToHome()
                                }

                                toast(result.message)
                            }

                            is Resource.Failure -> {
                                toast(it.errorBody.toString())
                            }
                        }
                    })
            }
        }
    }

    private fun signUpUserWithFacebook(
        accessToken: String?,
        email: String?,
        fName: String?,
        lName: String?
    ) {
        viewModel.registerFacebook(accessToken!!, email!!, fName!!, lName!!)
            .observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> showLoading()
                    is Resource.Success -> stopShowingLoading()
                    is Resource.Failure -> stopShowingLoading()
                }
            }
    }

    private fun signUpUserWithGoogle() {
        val acct: GoogleSignInAccount? = GoogleSignIn.getLastSignedInAccount(context!!)

        Log.e(
            "google sign up ",
            "id : ${acct?.id}\nemail : ${acct?.email}\nfname : ${acct?.displayName}\nlname : ${acct?.givenName}\ntoken : ${acct?.idToken}"
        )

        viewModel.registerGoogle(
            acct?.idToken.toString(),
            acct?.email.toString(),
            acct?.displayName.toString(),
            acct?.givenName.toString()
        )
            .observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Loading -> showLoading()
                    is Resource.Success -> stopShowingLoading()
                    is Resource.Failure -> stopShowingLoading()
                }
            }
    }

    private fun saveUser(email: String, password: String) {
        //@todo save user to app utils
        viewModel.login(email, password).observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    context?.let { context -> AppUtils(context).saveUser(it.value) }
                    moveToHome()
                }

                is Resource.Failure -> {
                    toast(it.errorBody.toString())
                }
                else -> {}
            }
        })
    }

    private fun moveToHome() {
        findNavController().navigate(R.id.action_signUpFragment_to_home2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentSignUpBinding.inflate(inflater, container, false)

    override fun getViewModel() = UserViewModel::class.java

    override fun getFragmentRepository() =
        UserRepository(remoteDataSource.getBaseUrl().create(UserApi::class.java))
}