package com.shopping.swagbag.products.filter.filter_color

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shopping.swagbag.databinding.SingleFilterColorBinding


class FilterColorAdapter(
    private val context: Context,
    private val data: List<String>
) :
    RecyclerView.Adapter<FilterColorAdapter.MyViewHolder>() {

    inner class MyViewHolder(private val viewBinding: SingleFilterColorBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(singleData: String) {
            with(viewBinding) {
                Log.e("color : -> ", singleData)
                try {
                    imgColor.setBackgroundColor(Color.parseColor(singleData))
                } catch (e: Exception) {
                    Log.e("error is -> ", e.message.toString())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(SingleFilterColorBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount()= data.size
}