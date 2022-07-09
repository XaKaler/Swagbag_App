package com.shopping.swagbag.products.filter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.databinding.SingleFilterCategoryBinding
import kotlin.math.max

class FiltersAllCategoriesAdapter(
    private val context: Context,
    private val data: List<FilterModel.Category>

) : RecyclerView.Adapter<FiltersAllCategoriesAdapter.MyViewHolder>() {

    var selectedPosition = -1
    val map = mutableMapOf<Int, Boolean>()
    var subCategoryVisible = false

    inner class MyViewHolder(private val viewBinding: SingleFilterCategoryBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        private val dataSize: Int = data.size

        fun bind(singleData: FilterModel.Category, parentPosition: Int) {
            setMap()
            with(viewBinding) {
                tvCatName.text = singleData.name

                if (selectedPosition == parentPosition) {
                    with(viewBinding) {
                        rvSubCategory.apply {
                            layoutManager = LinearLayoutManager(context)
                            adapter = FilterSubCategoryAdapter(
                                context,
                                data[parentPosition].subCategory,
                                object : RecycleViewItemClick {
                                    override fun onItemClickWithName(name: String, position: Int) {}
                                })
                        }
                    }
                    if (subCategoryVisible) {
                        imgCatArrow.rotation = max(0f, 0f)
                        rvSubCategory.visibility = View.GONE
                    } else {
                        imgCatArrow.rotation = max(180f, 180f)
                        rvSubCategory.visibility = View.VISIBLE
                    }
                } else {
                    imgCatArrow.rotation = max(0f, 0f)
                    rvSubCategory.visibility = View.GONE
                }
                // click listener
                singleCategory.setOnClickListener {
                    selectedPosition = position
                    // setSubCategory(position, viewBinding)
                    notifyDataSetChanged()
                }
            }
        }

        private fun setMap() {
            for (i in 0..data.size) {
                map[i] = false
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        SingleFilterCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        data[position].let { holder.bind(it, position) }
    }

    override fun getItemCount() = data.size

}