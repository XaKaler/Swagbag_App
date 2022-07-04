package com.shopping.swagbag.common.adapter

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shopping.swagbag.R
import com.shopping.swagbag.brand.details.AboutBrandModel
import com.shopping.swagbag.common.RecycleItemClickListener
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.common.model.AllTimeSliderModel
import com.shopping.swagbag.databinding.SingleBrandDetailBinding
import com.shopping.swagbag.databinding.SingleSliderProductsBinding
import com.shopping.swagbag.products.product_details.ProductDetailsFragmentDirections


class BrandDetailsAdapter(
    private val context: Context,
    private val data: List<AboutBrandModel>
) :
    RecyclerView.Adapter<BrandDetailsAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val viewBinding: SingleBrandDetailBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

            fun bind(singleData: AboutBrandModel){
                with(viewBinding){
                    // set image
                    Glide.with(context)
                        .load(singleData.file)
                        .error(R.drawable.glide_error)
                        .placeholder(R.drawable.glide_error)
                        .fitCenter()
                        .into(imgBrand)

                    tvDesc.text = singleData.desc
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(SingleBrandDetailBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount()= data.size
}