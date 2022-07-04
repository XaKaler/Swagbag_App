package com.shopping.swagbag.common.base

import android.util.Log
import com.google.gson.Gson
import com.shopping.swagbag.service.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.lang.reflect.Type

abstract class BaseRepository {

    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                Log.e("throwable", "safeApiCall: $throwable", )
                when (throwable) {
                    is HttpException -> {
                        Resource.Failure(false, throwable.code(), throwable.response()?.errorBody().toString())
                    }
                    else -> {
                        Resource.Failure(true,null, throwable.message.toString())
                    }
                }
            }
        }
    }


  /*  fun hitApi(
        apiCall: Call<ResponseBody>,
        apiCallListener: ApiCallListener,
        key: String
    ) {
        apiCall.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(
                call: Call<ResponseBody>,
                response: Response<ResponseBody>
            ) {
                try {
                    val responseBody = response.body()!!.string().trim { it <= ' ' }
                    val tx = response.raw().receivedResponseAtMillis
                    val rx = response.raw().sentRequestAtMillis
                    Log.d("TAG", "onResponse: Amit_code : " + (rx - tx) + " ms")
                    apiCallListener.onSuccess(responseBody, key)
                } catch (e: Exception) {
                    apiCallListener.onError(e.message.toString(), key)
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                apiCallListener.onError(t.message.toString(), key)
            }
        })
    }

    fun <T> getPayloadAsList(listType: Type, jsonData: String): List<T>? {
        return Gson().fromJson<List<T>>(jsonData, listType)
    }

    fun <T> getPayload(payloadClass: Class<T>, jsonData: String): T {
        return Gson().fromJson(jsonData, payloadClass)
    }*/
}