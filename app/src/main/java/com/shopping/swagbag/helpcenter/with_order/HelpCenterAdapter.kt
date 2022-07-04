package com.shopping.swagbag.helpcenter.with_order

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shopping.swagbag.R
import com.shopping.swagbag.databinding.*
import com.shopping.swagbag.dummy.DummyModel

class HelpCenterAdapter(
    private val context: Context,
    private val data: List<DummyModel>
) :
    RecyclerView.Adapter<HelpCenterAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val viewBinding: SingleHelpCenterWithOrderBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(singleData: DummyModel){
            with(viewBinding){

                // set text
                tvProductCompnayName.text = singleData.name
                tvProductName.text = singleData.details

                Glide.with(context)
                    .load(singleData.image)
                    .error(R.drawable.ic_launcher_foreground)
                    .placeholder(R.drawable.ic_swagbug_logo)
                    .into(productImg)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            SingleHelpCenterWithOrderBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount()= data.size
}