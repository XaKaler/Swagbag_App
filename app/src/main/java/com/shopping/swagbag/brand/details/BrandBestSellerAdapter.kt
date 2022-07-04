package com.shopping.swagbag.brand.details

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shopping.swagbag.R
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.databinding.SingleBrandProductBinding

class BrandBestSellerAdapter(
    private val context: Context,
    private val data: List<BrandDetailsModel.BrandsProduct>,
    private val itemClick: RecycleViewItemClick

) :
    RecyclerView.Adapter<BrandBestSellerAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val viewBinding: SingleBrandProductBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(singleData: BrandDetailsModel.BrandsProduct, position: Int, itemClick: RecycleViewItemClick){
            with(viewBinding){
                Glide.with(context)
                    .load(singleData.file[0].location)
                    .into(imgProduct)

                productName.text = "E"
                productDetails.text = singleData.name
                productDetails.text = singleData.name
                tvPrice.text = "${context.getString(R.string.Rs)} ${singleData.price}"

                // click listener
                itemView.setOnClickListener{
                    itemClick.onItemClickWithName(singleData.slug, position)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            SingleBrandProductBinding.inflate(
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