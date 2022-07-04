package com.shopping.swagbag.common.model

import com.google.gson.annotations.SerializedName

data class TopTrendingModel(
    val brand: String?,
    val category: String?,
    val `file`: String,
    val id: String,
    val masterCategory: String,
    val product: String?,
)
