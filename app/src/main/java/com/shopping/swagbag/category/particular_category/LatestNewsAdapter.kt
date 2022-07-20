package com.shopping.swagbag.category.particular_category

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
import com.shopping.swagbag.common.adapter.ProductImageAdapter
import com.shopping.swagbag.common.model.BestProductModel
import com.shopping.swagbag.databinding.SingleBestProductsBinding
import com.shopping.swagbag.databinding.SingleLatestNewsBinding
import com.shopping.swagbag.products.product_details.ProductDetailsFragmentDirections

class LatestNewsAdapter(
    private val context: Context,
    private val data: List<ParticularCategoryModel.Result.Brand>,
    private val itemClick: RecycleViewItemClick
) :
    RecyclerView.Adapter<LatestNewsAdapter.BestProductViewHolder>() {

    inner class BestProductViewHolder(private val viewBinding: SingleLatestNewsBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

            fun bind(singleData: ParticularCategoryModel.Result.Brand,itemClick: RecycleViewItemClick , position: Int){

              //  Log.e("home", "home page deals single data $singleData", )

                with(viewBinding){
                    // set imgae
                    Glide.with(context)
                        .load(singleData.file)
                        .error(R.drawable.ic_launcher_foreground)
                        .placeholder(R.drawable.logo)
                        .into(imgNews)

                    // set text
                    tvDate.text = singleData.createdDate
                    tvBlogType.text = singleData.slug
                    tvBlogHeading.text = singleData.name

                    itemView.setOnClickListener{
                        itemClick.onItemClickWithName("news", position)
                    }

                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestProductViewHolder {
        return BestProductViewHolder(SingleLatestNewsBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: BestProductViewHolder, position: Int) {
        holder.bind(data[position],itemClick, position)
    }

    override fun getItemCount()= data.size
}