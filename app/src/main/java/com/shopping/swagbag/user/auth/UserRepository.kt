package com.shopping.swagbag.user.auth

import com.shopping.swagbag.common.base.BaseRepository
import com.shopping.swagbag.service.apis.UserApi

class UserRepository(private val api: UserApi) : BaseRepository() {

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall { api.login(email, password) }

    suspend fun loginWithGoogle(
        token: String,
        email: String
    ) = safeApiCall { api.loginWithGoogle(token, email) }

    suspend fun loginWithFacebook(
        token: String,
        email: String
    ) = safeApiCall { api.loginWithFacebook(token, email) }

    suspend fun register(
        fName: String,
        lName: String,
        email: String,
        password: String,
        reffer_by: String,
    ) = safeApiCall { api.register(fName, lName, email, password, reffer_by) }

    suspend fun registerGoogle(
        token: String,
        email: String,
        fName: String,
        lName: String,
    ) = safeApiCall { api.registerGoogle(token, email, fName, lName) }

    suspend fun registerFacebook(
        token: String,
        email: String,
        fName: String,
        lName: String,
    ) = safeApiCall { api.registerFacebook(token, email, fName, lName) }

    suspend fun passwordResetEmailSend(
        email: String
    ) = safeApiCall { api.passwordResetEmailSend(email) }

    suspend fun passwordReset(
        email: String,
        otp: String,
        password: String
    ) = safeApiCall { api.passwordReset(email, otp, password) }

    suspend fun addAddress(
        userid: String,
        title: String,
        address: String,
        address2: String,
        city: String,
        country: String,
        post_office: String,
        pincode: String,
        contact_name: String,
        contact_mobile: String,
        lat: String,
        lng: String,
    ) = safeApiCall {
        api.addAddress(
            userid,
            title,
            address,
            address2,
            city,
            country,
            post_office,
            pincode,
            contact_name,
            contact_mobile,
            lat,
            lng
        )
    }

    suspend fun editAddress(
        userid: String,
        title: String,
        address: String,
        address2: String,
        city: String,
        country: String,
        post_office: String,
        pincode: String,
        contact_name: String,
        contact_mobile: String,
        addressId: String,
        lat: String,
        lng: String,
    ) = safeApiCall {
        api.editAddress(
            userid,
            title,
            address,
            address2,
            city,
            country,
            post_office,
            pincode,
            contact_name,
            contact_mobile,
            addressId,
            lat,
            lng
        )
    }



    suspend fun allAddress(userId: String)= safeApiCall { api.allAddress(userId) }

    suspend fun deleteAddress(addressId: String) = safeApiCall { api.deleteAddress(addressId) }

    suspend fun userUpdate(userid: String, token: String, fName: String, lName: String, email: String) =
        safeApiCall { api.userUpdate(userid, token, fName, lName, email) }

    suspend fun wallet(userId: String,limit: String, page: String) = safeApiCall { api.wallet(userId, limit, page) }
}