package com.shopping.swagbag.common.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shopping.swagbag.databinding.SingleCard8Binding
import com.shopping.swagbag.dummy.DummyChild

class CategoryToBegChildAdapter(
    private val context: Context,
    private val data: List<DummyChild>
) :
    RecyclerView.Adapter<CategoryToBegChildAdapter.CategoryToBegViewHolder>() {

    inner class CategoryToBegViewHolder(private val viewBinding: SingleCard8Binding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(singleData: DummyChild){
            with(viewBinding){
                // set image
                Glide.with(context)
                    .load(singleData.image)
                    .into(imageView38)

                productCategory.text = singleData.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryToBegViewHolder {
        return CategoryToBegViewHolder(
            SingleCard8Binding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryToBegViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}