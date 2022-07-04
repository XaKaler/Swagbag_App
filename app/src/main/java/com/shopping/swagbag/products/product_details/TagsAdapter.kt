package com.shopping.swagbag.products.product_details

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.databinding.SingleCard10Binding
import com.shopping.swagbag.databinding.SingleProductDetailsTagBinding
import com.shopping.swagbag.products.product_details.ProductDetailsProductModel

class TagsAdapter(
    private val context: Context,
    private val data: List<String>,
    private val itemClick: RecycleViewItemClick

) :
    RecyclerView.Adapter<TagsAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val viewBinding: SingleProductDetailsTagBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(singleData: String, position: Int, itemClick: RecycleViewItemClick){
            with(viewBinding){
                tvTag.text = singleData

                // click listener
                itemView.setOnClickListener{
                    itemClick.onItemClickWithName(singleData, position)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            SingleProductDetailsTagBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position], position, itemClick)
    }

    override fun getItemCount()= data.size
}