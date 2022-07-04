package com.shopping.swagbag.brand

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shopping.swagbag.R
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.databinding.*

class BrandAdapter(
    private val context: Context,
    private val data: List<BrandModel.Result>,
    private val itemClick: RecycleViewItemClick
) :
    RecyclerView.Adapter<BrandAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val viewBinding: SingleBrandBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(singleData: BrandModel.Result, itemClick: RecycleViewItemClick, position: Int){
            with(viewBinding){

                // set text
                brandName.text = singleData.name
                aboutBrand.text = singleData.desc

                Glide.with(context)
                    .load(singleData.file)
                    .error(R.drawable.category_background)
                    .placeholder(R.drawable.category_background)
                    .into(imgBrand)

                itemView.setOnClickListener {
                    itemClick.onItemClickWithName("brand detail", position)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            SingleBrandBinding.inflate(
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