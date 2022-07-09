package com.shopping.swagbag.products.filter


import com.google.gson.annotations.SerializedName

data class ExtraFilterModel(
    val result: List<Result>,
    val status: String // success
) {
    data class Result(
        val name: String, // Color
        val value: List<String>
    )
}