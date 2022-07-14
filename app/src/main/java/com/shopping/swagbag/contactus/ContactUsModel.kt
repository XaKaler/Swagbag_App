package com.shopping.swagbag.contactus


import com.google.gson.annotations.SerializedName

data class ContactUsModel(
    val message: String, // We will contact you for call.
    val status: String // success
)