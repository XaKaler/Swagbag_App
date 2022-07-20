package com.shopping.swagbag.common.base

import android.util.Log
import com.shopping.swagbag.products.product_details.ProductOptionModel
import java.text.SimpleDateFormat
import java.util.*

object GeneralFunction {
    var walletItemCount = 0
    var cartItemCount = 0

    fun getProductQty() = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    fun getSortBY() = arrayOf("Default", "Latest", "Sort forward price low", "Sort forward price high")


    fun convertServerDateToUserTimeZoneTask(
        serverDate: String?,
        serverdateFormat: String = "yyyy-MM-dd'T'HH:mm:ss.SSS",
        ourDateFormat: String = "EEE, d MMM yyyy"
    ): String {
        val ourdate: String = try {
            val formatter = SimpleDateFormat(serverdateFormat)
            formatter.timeZone = TimeZone.getTimeZone("Asia/Kolkata")
            val value: Date = formatter.parse(serverDate)
            value.hours = value.hours+5
            value.minutes = value.minutes+30
            val millis: Long = value.time
            val timeZone: TimeZone = TimeZone.getDefault()
            val dateFormatter =
                SimpleDateFormat(ourDateFormat, Locale.getDefault()) //this format changeable
            dateFormatter.timeZone = timeZone
            dateFormatter.format(value)
            //Log.d("OurDate", OurDate);
        } catch (e: Exception) {
            "0000-00-00 00:00:00"
        }/*
        val serverdateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS"
        val ourDateFormat = "EEE, d MMM yyyy"*/
        return ourdate
    }


    fun stringToList(optionValue: String): ArrayList<ProductOptionModel> {
        //1. remove all white spaces from string
        //2. iterate string
        //3. value:price:sku:qty these are 4 parameters in string
        //make list of them

        val updatedOptionValue = optionValue.replace("\\s".toRegex(), "")

        Log.e("TAG", "Remove white space: $updatedOptionValue")

        val list = ArrayList<ProductOptionModel>()

        var colonCount = 0
        var value = ""
        var price = ""
        var sku = ""
        var qty = ""

        for (option in updatedOptionValue) {

            when (option) {
                ':' -> colonCount += 1
                ',' -> {
                    colonCount = 0
                    list.add(ProductOptionModel(value, price, sku, qty))

                    Log.e("TAG", "option == ,: $list  ")

                    value = ""
                    price = ""
                    sku = ""
                    qty = ""
                }
                else -> {
                    when (colonCount) {
                        0 -> value += option
                        1 -> price += option
                        2 -> sku += option
                        3 -> qty += option
                    }
                }
            }
        }
        list.add(ProductOptionModel(value, price, sku, qty))
        return list
    }

}