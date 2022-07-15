package com.shopping.swagbag.search


import com.google.gson.annotations.SerializedName

data class MobileProductSearchModel(
    val result: List<Result>,
    val status: String // success
) {
    data class Result(
        @SerializedName("master_category")
        val masterCategory: MasterCategory,
        val product: List<Product>
    ) {
        data class MasterCategory(
            val active: Int, // 1
            @SerializedName("created_date")
            val createdDate: String, // 2021-09-23T13:53:06.672Z
            val deleted: Int, // 0
            val desc: String, // Kids
            val `file`: String, // https://swagbag-files.s3.amazonaws.com/1649940046666fx2zw.jpeg
            @SerializedName("_id")
            val id: String, // 615ae14c63d6a6435a183db7
            val name: String, // Kids
            @SerializedName("short_desc")
            val shortDesc: String, // Kids
            val slug: String, // kids
            @SerializedName("slug_history")
            val slugHistory: List<String>,
            val sort: Int, // 0
            @SerializedName("update_date")
            val updateDate: String, // 2022-04-14T12:40:47.000Z
            @SerializedName("__v")
            val v: Int // 0
        )

        data class Product(
            val active: Int, // 1
            @SerializedName("added_by")
            val addedBy: String, // 5fe463f5a9e14206002dd63e
            @SerializedName("additional_description")
            val additionalDescription: String, // <table border="0" cellpadding="0" cellspacing="0" width="300" style="width: 225pt;"><tbody><tr height="145" style="mso-height-source:userset;height:109.0pt">  <td height="145" class="xl65" width="300" style="height:109.0pt;width:225pt">It is  formulated with maral root that is rich in antioxidants and possesses  powerful cleaning action. For naturally clean and fresh-looking fur.</td></tr></tbody></table>
            val attribute: String,
            val backorders: String,
            val batchno: String,
            val brand: Brand,
            val category: List<String>,
            val cgst: String,
            @SerializedName("combo_products")
            val comboProducts: Any?, // null
            val commission: String,
            val createdAt: String, // 2022-05-24T05:39:02.770Z
            @SerializedName("created_date")
            val createdDate: String, // 2022-05-20T08:44:57.318Z
            val cuisine: Any?, // null
            val deal: Int?, // 0
            val deleted: Int, // 0
            val desc: String, // <table border="0" cellpadding="0" cellspacing="0" width="300" style="width: 225pt;"><tbody><tr height="145" style="mso-height-source:userset;height:109.0pt">  <td height="145" class="xl65" width="300" style="height:109.0pt;width:225pt">Features:<br>    Organic, Natural &amp; Vegan product<br>    Inspired By Wild Animals from Pure Siberia Region.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <br>The shampoo is formulated with botanical acids and vitamin C, obtained  from cloudberry, which counteracts melanin production</td></tr></tbody></table>
            val details: String, // <table border="0" cellpadding="0" cellspacing="0" width="300" style="width: 225pt;"><tbody><tr height="145" style="mso-height-source:userset;height:109.0pt">  <td height="145" class="xl65" width="300" style="height:109.0pt;width:225pt">0.5  kg/ 22x30x13 cm<br>    400 ml</td></tr></tbody></table>
            @SerializedName("discounted_price")
            val discountedPrice: Any?, // null
            @SerializedName("end_date")
            val endDate: String, // 2022-05-20T00:00:00.000Z
            val express: Boolean, // false
            val featured: Int?, // 0
            val `file`: List<File>,
            val height: String, // 13cm
            @SerializedName("_id")
            val id: String, // 628c6f76077b7f070a05f5b3
            val igst: String,
            val length: String, // 22cm
            @SerializedName("manage_stock")
            val manageStock: Int, // 1
            @SerializedName("master_category")
            val masterCategory: List<String>,
            val name: String, // Urban-Detox Pet Shampoo
            val options: List<Option>,
            @SerializedName("packaging_charge")
            val packagingCharge: String,
            val point: Int, // 0
            @SerializedName("point_exp_date")
            val pointExpDate: String, // 2022-05-20T08:44:57.318Z
            val price: Double, // 60.5
            @SerializedName("product_types")
            val productTypes: List<String>,
            @SerializedName("return_day")
            val returnDay: String,
            val returnable: String,
            @SerializedName("selling_price")
            val sellingPrice: Any?, // null
            val sgst: String,
            @SerializedName("shelving_location")
            val shelvingLocation: String, // Sharjah
            @SerializedName("short_desc")
            val shortDesc: String, // Perfect for cats and dogs living in the city that require a refreshing and thorough cleanse.
            val sku: String, // 2863
            val slug: String, // urban-detox-pet-shampoo
            @SerializedName("slug_history")
            val slugHistory: List<String>,
            @SerializedName("start_date")
            val startDate: String, // 2022-05-20T00:00:00.000Z
            @SerializedName("stock_qty")
            val stockQty: String, // 10
            @SerializedName("sub_category")
            val subCategory: List<String>,
            val tags: String, // Organic, Natural, Vegan, Dogs,Cats, Bath Essentials
            @SerializedName("tax_status")
            val taxStatus: String,
            val threshold: String, // 2
            @SerializedName("update_date")
            val updateDate: String, // 2022-05-20T08:44:57.318Z
            val updatedAt: String, // 2022-05-24T06:06:47.684Z
            @SerializedName("__v")
            val v: Int, // 0
            val vendor: String, // 628c6474077b7f070a05f2cb
            @SerializedName("video_url")
            val videoUrl: String,
            val weight: String, // 0.5 kg
            val width: String // 30cm
        ) {
            data class Brand(
                val active: Int, // 1
                @SerializedName("created_date")
                val createdDate: String, // 2022-02-19T09:53:51.911Z
                val deleted: Int, // 0
                val desc: String, // Do as wild animals do! - WILDA SIBERICA offers a well-thought-out and pampering range of natural pet care products for four-legged animals.
                val desc2: String,
                val desc3: String,
                val `file`: String, // https://swagbag-files.s3.amazonaws.com/16486163804063rbvl.webp
                val file2: String,
                val file3: String,
                val file4: String,
                @SerializedName("_id")
                val id: String, // 6211fd260fe91d273d217a3f
                val name: String, // Wilda Siberica
                @SerializedName("seo_desc")
                val seoDesc: String,
                @SerializedName("seo_title")
                val seoTitle: String,
                @SerializedName("short_desc")
                val shortDesc: Any?, // null
                val slug: String, // wilda-siberica
                @SerializedName("slug_history")
                val slugHistory: List<String>,
                @SerializedName("update_date")
                val updateDate: String, // 2022-03-30T04:59:42.000Z
                @SerializedName("__v")
                val v: Int // 0
            )

            data class Option(
                val name: String, // Colour
                val value: String // #FFA500:68.08:2023424:10
            )

            data class File(
                val acl: String, // public-read
                val bucket: String, // swagbag-files
                val contentDisposition: Any?, // null
                val contentEncoding: Any?, // null
                val contentType: String, // application/octet-stream
                val encoding: String, // 7bit
                val etag: String, // "c6f324e09f96b31cf95689ecd7ad684c"
                val fieldname: String, // upload
                val key: String, // 165337074219331ydy.jpeg
                val location: String, // https://swagbag-files.s3.amazonaws.com/165337074219331ydy.jpeg
                val metadata: Any?, // null
                val mimetype: String, // image/jpeg
                val originalname: String, // 1. Wilda Siberica - Urban Detox Shampoo 1.jpg
                val serverSideEncryption: Any?, // null
                val size: Int, // 9253
                val storageClass: String, // STANDARD
                val versionId: Any? // null
            )
        }
    }
}