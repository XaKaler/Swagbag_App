package com.shopping.swagbag.blog

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shopping.swagbag.R
import com.shopping.swagbag.common.RecycleItemClickListener
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.common.model.BestProductModel
import com.shopping.swagbag.databinding.SingleBestProductsBinding
import com.shopping.swagbag.databinding.SingleBlogBinding
import com.shopping.swagbag.products.product_details.ProductDetailsFragmentDirections

class BlogAdapter(
    private val context: Context,
    private val data: List<BlogListModel.Result>,
    private val itemClick: RecycleViewItemClick
) :
    RecyclerView.Adapter<BlogAdapter.BestProductViewHolder>() {

    inner class BestProductViewHolder(private val viewBinding: SingleBlogBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

            fun bind(singleData: BlogListModel.Result,itemClick: RecycleViewItemClick , position: Int){
                with(viewBinding){
                    // set imgae
                    Glide.with(context)
                        .load(singleData.image)
                        .error(R.drawable.ic_launcher_foreground)
                        .placeholder(R.drawable.logo)
                        .into(imgNews)

                    // set text
                    tvDate.text = singleData.createdAt
                    tvBlogType.text = singleData.blogCategory.name
                    tvBlogHeading.text = singleData.title

                    itemView.setOnClickListener{
                        itemClick.onItemClickWithName("blog details", position)
                    }

                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestProductViewHolder {
        return BestProductViewHolder(SingleBlogBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: BestProductViewHolder, position: Int) {
        holder.bind(data[position],itemClick, position)
    }

    override fun getItemCount()= data.size
}