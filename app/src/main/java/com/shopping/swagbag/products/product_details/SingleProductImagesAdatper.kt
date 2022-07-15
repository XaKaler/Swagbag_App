package com.shopping.swagbag.products.product_details

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shopping.swagbag.R
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.databinding.*

class SingleProductImagesAdatper(
    private val context: Context,
    private val data: List<ProductDetailModel.Result.File>,
    private val itemClick: RecycleViewItemClick
) :
    RecyclerView.Adapter<SingleProductImagesAdatper.MyViewHolder>() {

    inner class MyViewHolder(private val viewBinding: SingleProductImageBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(singleData: ProductDetailModel.Result.File, itemClick: RecycleViewItemClick, position: Int){
            with(viewBinding){

                Glide.with(context)
                    .load(singleData.location)
                    .error(R.drawable.ic_launcher_foreground)
                    .placeholder(R.drawable.ic_swagbug_logo)
                    .into(productImg)

                itemView.setOnClickListener {
                    itemClick.onItemClickWithName("", position)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            SingleProductImageBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position], itemClick, position)
    }

    override fun getItemCount()= data.size
}