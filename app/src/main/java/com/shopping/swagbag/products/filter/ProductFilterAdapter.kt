package com.shopping.swagbag.products.filter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shopping.swagbag.R
import com.shopping.swagbag.common.RecycleViewItemClick
import com.shopping.swagbag.databinding.SingleFilterBinding
import com.shopping.swagbag.dummy.ProductFilter
import com.shopping.swagbag.products.filter.filter_color.FilterColorAdapter


class ProductFilterAdapter(
    private val context: Context,
    private val filterName: List<ProductFilter>,
    private val filterValue: Map<String, Any>,
    private val itemClick: RecycleViewItemClick
) :
    RecyclerView.Adapter<ProductFilterAdapter.MyViewHolder>() {

    var selectedPosition = -1
    private lateinit var visibleView: View

    inner class MyViewHolder(private val viewBinding: SingleFilterBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

            fun bind(singleData: ProductFilter, itemClick: RecycleViewItemClick, position: Int){
                with(viewBinding){
                    visibleView = edtFilterByKeyword
                    if(selectedPosition == position){
                        btnShowHideFilter.setImageResource(R.drawable.ic_baseline_remove_24)
                        visibleView.visibility = View.VISIBLE
                    }
                    else{
                        btnShowHideFilter.setImageResource(R.drawable.ic_round_add_24)
                        visibleView.visibility = View.GONE
                    }

                    itemView.setOnClickListener {
                        selectedPosition = position
                        Log.e("itemClick", filterName.text.toString())
                        itemClick.onItemClickWithName(filterName.text.toString(), 0)
                        when(filterName.text.toString()){
                            "Filter by keyword" -> {
                                visibleView = edtFilterByKeyword
                                edtFilterByKeyword.visibility = View.VISIBLE
                            }
                            "Filter with Deal" -> {
                                visibleView = chFilterWithDeals
                                chFilterWithDeals.visibility = View.VISIBLE
                            }
                            "All Categories" -> {
                                visibleView = rvAllCategories
                                rvAllCategories.visibility = View.VISIBLE
                            }
                            "Filter by Price" -> {
                                visibleView = lytFilterByPrice
                                lytFilterByPrice.visibility = View.VISIBLE
                            }
                            "Brands" -> {
                                visibleView = rvBrand
                                rvBrand.visibility = View.VISIBLE
                            }
                            "Color" -> {
                                visibleView = rvColor
                                rvColor.visibility = View.VISIBLE
                            }
                            "Size" -> {
                                visibleView = rvSize
                                rvSize.visibility = View.VISIBLE
                            }
                            "Colour" -> {
                                visibleView = rvColour
                                rvColour.visibility = View.VISIBLE
                            }
                        }
                    }

                    //set filter name
                    filterName.text = singleData.filterName

                    //set filter values
                    //1. all categories
                    @Suppress("UNCHECKED_CAST")
                    val allCategories: List<FilterModel.Category> = filterValue["All Categories"] as List<FilterModel.Category>
                    rvAllCategories.run{
                        layoutManager = LinearLayoutManager(context)
                        adapter = FiltersAllCategoriesAdapter(context, allCategories)
                    }
                    //2. brand
                    @Suppress("UNCHECKED_CAST")
                    val allBrands: List<FilterModel.Brand> = filterValue["Brands"] as List<FilterModel.Brand>
                    rvBrand.run{
                        layoutManager = LinearLayoutManager(context)
                        adapter = FilterBrandAdapter(context, allBrands)
                    }
                   /* //3. colors
                    @Suppress("UNCHECKED_CAST")
                    val allColors: List<String> = filterValue["Color"] as List<String>
                    rvColor.run{
                        layoutManager = LinearLayoutManager(context)
                        adapter = FilterColorAdapter(context, allColors)
                    }
                    //3. size
                    @Suppress("UNCHECKED_CAST")
                    val allSizes: List<String> = filterValue["Size"] as List<String>
                    rvSize.run{
                        layoutManager = LinearLayoutManager(context)
                        adapter = FilterSizeAdapter(context, allSizes)
                    }
                    //3. colour
                    @Suppress("UNCHECKED_CAST")
                    val allColours: List<String> = filterValue["Colour"] as List<String>
                    rvColour.run{
                        layoutManager = LinearLayoutManager(context)
                        adapter = FilterColorAdapter(context, allColours)
                    }*/
                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(SingleFilterBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(filterName[position],itemClick = itemClick, position)
    }

    override fun getItemCount()= filterName.size
}