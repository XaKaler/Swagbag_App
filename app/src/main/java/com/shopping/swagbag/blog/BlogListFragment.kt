package com.shopping.swagbag.blog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.common.base.BaseFragment
import com.shopping.swagbag.databinding.FragmentBlogListBinding
import com.shopping.swagbag.service.Resource
import com.shopping.swagbag.service.apis.SettingApi
import com.shopping.swagbag.settings.SettingRepository
import com.shopping.swagbag.utils.SettingViewModel

class BlogListFragment : BaseFragment<
        FragmentBlogListBinding,
        SettingViewModel,
        SettingRepository>(FragmentBlogListBinding::inflate) {

    private lateinit var blogList: BlogListModel

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentBlogListBinding.inflate(inflater, container, false)

    override fun getViewModel() = SettingViewModel::class.java

    override fun getFragmentRepository() =
        SettingRepository(remoteDataSource.getBaseUrl().create(SettingApi::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbar()

        if (this::blogList.isInitialized)
            setBlogList()
        else
            getBlogList()
    }

    fun setToolbar() {
        with(viewBinding.toolbar) {
            tvTitle.text = "Blog"
            imgBack.setOnClickListener { findNavController().popBackStack() }
        }
    }

    private fun getBlogList() {
        viewModel.allBlogs().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> showLoading()

                is Resource.Success -> {
                    stopShowingLoading()
                    blogList = it.value
                    setBlogList()
                }

                is Resource.Failure -> stopShowingLoading()
            }
        }
    }

    private fun setBlogList() {
        with(viewBinding) {
            rvBlogs.run {
                layoutManager = LinearLayoutManager(context)
                adapter = BlogAdapter(context, blogList.result, object : RecycleViewItemClick {
                    override fun onItemClickWithName(name: String, position: Int) {

                    }
                })
            }
        }
    }

}