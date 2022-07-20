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
import com.shopping.swagbag.databinding.SingleParticularCategoryBrandBinding
import com.shopping.swagbag.products.product_details.ProductDetailsFragmentDirections

class ParticularCategoryBrandAdapter(
    private val context: Context,
    private val data: List<ParticularCategoryModel.Result.Brand>,
    private val itemClick: RecycleViewItemClick
) :
    RecyclerView.Adapter<ParticularCategoryBrandAdapter.BestProductViewHolder>() {

    inner class BestProductViewHolder(private val viewBinding: SingleParticularCategoryBrandBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

            fun bind(singleData: ParticularCategoryModel.Result.Brand,itemClick: RecycleViewItemClick , position: Int){

              //  Log.e("home", "home page deals single data $singleData", )

                with(viewBinding){
                    // set image
                    Glide.with(context)
                        .load(singleData.file)
                        .error(R.drawable.ic_launcher_foreground)
                        .placeholder(R.drawable.logo)
                        .into(imgBrand)


                    itemView.setOnClickListener{
                        itemClick.onItemClickWithName("brand", position)
                    }

                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestProductViewHolder {
        return BestProductViewHolder(SingleParticularCategoryBrandBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: BestProductViewHolder, position: Int) {
        holder.bind(data[position],itemClick, position)
    }

    override fun getItemCount()= data.size
}