package com.shopping.swagbag.products

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.databinding.SingleCard10Binding
import com.shopping.swagbag.products.product_details.ProductDetailsProductModel

class Card10Adapter(
    private val context: Context,
    private val data: List<ProductDetailsProductModel>,
    private val itemClick: RecycleViewItemClick

) :
    RecyclerView.Adapter<Card10Adapter.MyViewHolder>() {

    inner class MyViewHolder(private val viewBinding: SingleCard10Binding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(singleData: ProductDetailsProductModel, position: Int, itemClick: RecycleViewItemClick){
            with(viewBinding){/*
                oldRate.paintFlags = oldRate.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                textView59.paintFlags = textView59.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG*/

                // set
                Glide
                    .with(context)
                    .load(singleData.file)
                    .into(imgFeatureBrand)

                // set text
                productName.text = singleData.name
                productDetails.text = singleData.shortDesc
                newRate.text = singleData.price

                // click listener
                itemView.setOnClickListener{
                    itemClick.onItemClickWithName(singleData.slug, position)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            SingleCard10Binding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position], position, itemClick)
        if(position == 0){
            val padding: Int = context.resources.getDimensionPixelOffset(com.shopping.swagbag.R.dimen.screen_padding_15)
            holder.itemView.setPadding(padding, 0,0,0)
        }

    }

    override fun getItemCount()= data.size
}