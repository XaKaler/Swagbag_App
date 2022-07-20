package com.shopping.swagbag.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shopping.swagbag.common.base.BaseFragment
import com.shopping.swagbag.databinding.FragmentBlogDetailsBinding
import com.shopping.swagbag.service.apis.SettingApi
import com.shopping.swagbag.settings.SettingRepository
import com.shopping.swagbag.utils.SettingViewModel

class BlogDetailsFragment : BaseFragment<
        FragmentBlogDetailsBinding,
        SettingViewModel,
        SettingRepository>(FragmentBlogDetailsBinding::inflate) {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentBlogDetailsBinding.inflate(inflater, container, false)

    override fun getViewModel() = SettingViewModel::class.java

    override fun getFragmentRepository() =
        SettingRepository(remoteDataSource.getBaseUrl().create(SettingApi::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}