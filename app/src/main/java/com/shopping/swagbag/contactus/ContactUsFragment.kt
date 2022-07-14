package com.shopping.swagbag.contactus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.shopping.swagbag.R
import com.shopping.swagbag.common.base.BaseFragment
import com.shopping.swagbag.databinding.FragmentContactUsBinding
import com.shopping.swagbag.databinding.ToolbarWithNoMenuWhiteBgBinding
import com.shopping.swagbag.service.Resource
import com.shopping.swagbag.service.apis.SettingApi
import com.shopping.swagbag.settings.SettingRepository
import com.shopping.swagbag.utils.SettingViewModel


class ContactUsFragment : BaseFragment<
        FragmentContactUsBinding,
        SettingViewModel,
        SettingRepository>(FragmentContactUsBinding::inflate) {

    private lateinit var toolbarBinding: ToolbarWithNoMenuWhiteBgBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarBinding = viewBinding.include

        viewBinding.btnSubmit.setOnClickListener {
            contactCustomerCare()
        }

        setToolbar()
    }

    private fun contactCustomerCare() {
        with(viewBinding) {
            val email = edtEmail.text.toString()
            val name = edtName.text.toString()
            val subject = edtSubject.text.toString()
            val message = edtMessage.text.toString()

            if (email.isNotEmpty() &&
                name.isNotEmpty() &&
                subject.isNotEmpty() &&
                message.isNotEmpty()
            ) {
                viewModel.contactUs(name, email, subject, message).observe(viewLifecycleOwner) {
                    when (it) {
                        is Resource.Loading -> showLoading()
                        is Resource.Success -> {
                            stopShowingLoading()
                            toast(it.value.message)
                            //empty all fields
                            setEmptyAllFields()
                        }
                        is Resource.Failure -> stopShowingLoading()
                    }
                }
            } else
                toast("Fill all fields")
        }
    }

    private fun setEmptyAllFields() {
        with(viewBinding) {
            edtName.setText("")
            edtEmail.setText("")
            edtSubject.setText("")
            edtMessage.setText("")
        }
    }

    private fun setToolbar() {
        with(toolbarBinding) {
            // set title
            tvTitle.text = getString(R.string.contact_us)

            // back button click
            imgBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentContactUsBinding.inflate(inflater, container, false)

    override fun getViewModel() = SettingViewModel::class.java

    override fun getFragmentRepository() =
        SettingRepository(remoteDataSource.getBaseUrl().create(SettingApi::class.java))
}