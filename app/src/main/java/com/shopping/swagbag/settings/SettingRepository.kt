package com.shopping.swagbag.settings

import com.shopping.swagbag.common.base.BaseRepository
import com.shopping.swagbag.service.apis.SettingApi

class SettingRepository(private val api: SettingApi) : BaseRepository() {

    suspend fun giftCard() = safeApiCall { api.giftCard() }

    suspend fun settings() = safeApiCall { api.settings() }

    suspend fun allCountry() = safeApiCall { api.allCountry() }

    suspend fun allBlogs() = safeApiCall { api.allBlogs() }

    suspend fun allCity(cityId: String) = safeApiCall { api.allCity(cityId) }

    suspend fun contactUs(
        name: String,
        email: String,
        subject: String,
        message: String
    ) = safeApiCall { api.contactUs(name, email, subject, message) }
}