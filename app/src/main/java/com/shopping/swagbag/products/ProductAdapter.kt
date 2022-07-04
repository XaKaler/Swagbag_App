package com.shopping.swagbag.products

import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shopping.swagbag.R
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.common.adapter.BestOfferAdapter
import com.shopping.swagbag.databinding.SingleBestOffersBinding
import com.shopping.swagbag.databinding.SingleProductBinding
import com.shopping.swagbag.dummy.DummyModel
import com.shopping.swagbag.search.HeaderSearchModel

class ProductAdapter(
    private val context: Context,
    private val data: List<ProductSearchModel.Result>,
    private val itemClick: RecycleViewItemClick
) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(private val viewBinding: SingleProductBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(singleData: ProductSearchModel.Result, position: Int, itemClick: RecycleViewItemClick){
            with(viewBinding){
                // set imgae
                Glide.with(context)
                    .load(singleData.file[0].location)
                    .into(imgProduct)

                // set text
                tvProductName.text = singleData.name
                tvBrandName.text = singleData.brand.name
                tvProductPrice.text = "${context.getString(R.string.Rs)} ${singleData.price}"

                imgWishlist.setOnClickListener{
                    itemClick.onItemClickWithView("wishlist",viewBinding.imgWishlist, position)
                }

                singlePrdouct.setOnClickListener{
                    itemClick.onItemClickWithName("product details", position)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            SingleProductBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(data[position], position, itemClick)
    }

    override fun getItemCount()= data.size
}