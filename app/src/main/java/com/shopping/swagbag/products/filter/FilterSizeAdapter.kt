package com.shopping.swagbag.products.filter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shopping.swagbag.databinding.SingleFilterSizeBinding
import com.shopping.swagbag.dummy.ProductFilter


class FilterSizeAdapter(
    private val context: Context,
    private val data: List<String>
) :
    RecyclerView.Adapter<FilterSizeAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val viewBinding: SingleFilterSizeBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

            fun bind(singleData: String){
                with(viewBinding){
                    sizeType.text = singleData
                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(SingleFilterSizeBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount()= data.size
}