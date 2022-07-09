package com.shopping.swagbag.products.filter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shopping.swagbag.databinding.SingleFilterBrandBinding
import com.shopping.swagbag.dummy.DummyModel


class FilterBrandAdapter(
    private val context: Context,
    private val data: List<FilterModel.Brand>
) :
    RecyclerView.Adapter<FilterBrandAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val viewBinding: SingleFilterBrandBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

            fun bind(singleData: FilterModel.Brand){
                with(viewBinding){
                    chBrand.text = singleData.name
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(SingleFilterBrandBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount()= data.size
}