package com.shopping.swagbag.service.apis

import com.shopping.swagbag.blog.BlogListModel
import com.shopping.swagbag.contactus.ContactUsModel
import com.shopping.swagbag.settings.SettingsModel
import com.shopping.swagbag.coupons.GiftCardModel
import com.shopping.swagbag.settings.AllCityModel
import com.shopping.swagbag.settings.AllCountryModel
import retrofit2.http.*

interface SettingApi {

    @GET("gift-card")
    suspend fun giftCard(): GiftCardModel

    @GET("settings")
    suspend fun settings(): SettingsModel

    @GET("all-country")
    suspend fun allCountry(): AllCountryModel

    @GET("all-blogs")
    suspend fun allBlogs(): BlogListModel

    @GET("all-city")
    suspend fun allCity(
        @Query("id")cityId: String
    ): AllCityModel

    @FormUrlEncoded
    @POST("create-contact-now")
    suspend fun contactUs(
        @Field("name") name: String,
        @Field("email")email: String,
        @Field("subject")subject: String,
        @Field("message")message: String
    ): ContactUsModel
}