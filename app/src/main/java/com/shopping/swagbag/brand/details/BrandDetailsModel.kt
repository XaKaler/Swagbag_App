package com.shopping.swagbag.brand.details


import com.google.gson.annotations.SerializedName

data class BrandDetailsModel(
    val brands: Brands,
    @SerializedName("brands_products")
    val brandsProducts: List<BrandsProduct>,
    val menu: Menu,
    val message: String,
    val status: String // success
) {
    data class Brands(
        val active: Int, // 1
        @SerializedName("created_date")
        val createdDate: String, // 2022-06-07T15:33:21.502Z
        val deleted: Int, // 0
        val desc: String, // Cleaning Wipes
        val desc2: String,
        val desc3: String,
        val `file`: String, // https://swagbag-files.s3.amazonaws.com/165466307558360kcn.png
        val file2: String,
        val file3: String,
        val file4: String,
        @SerializedName("_id")
        val id: String, // 62a027a50ecf0e5d454b25ba
        val name: String, // Presto
        @SerializedName("seo_desc")
        val seoDesc: String,
        @SerializedName("seo_title")
        val seoTitle: String,
        @SerializedName("short_desc")
        val shortDesc: String,
        val slug: String, // presto
        @SerializedName("slug_history")
        val slugHistory: List<String>,
        @SerializedName("update_date")
        val updateDate: String, // 2022-06-07T15:33:21.502Z
        @SerializedName("__v")
        val v: Int // 0
    )

    data class BrandsProduct(
        val active: Int, // 1
        @SerializedName("added_by")
        val addedBy: String, // 5fe463f5a9e14206002dd63e
        @SerializedName("additional_description")
        val additionalDescription: String, // <p style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0); margin-right: 0px; margin-bottom: 0px; margin-left: 0px;"><font face="Times New Roman" color="#000000" style="font-stretch: normal; font-size: 12px; line-height: normal; font-family: &quot;Times New Roman&quot;; font-variant-ligatures: common-ligatures;">Cautions:</font></p><p style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0); margin-right: 0px; margin-bottom: 0px; margin-left: 0px;"><font face="Times New Roman" color="#000000" style="font-stretch: normal; font-size: 12px; line-height: normal; font-family: &quot;Times New Roman&quot;; font-variant-ligatures: common-ligatures;"><span class="Apple-tab-span" style="white-space: pre;">	</span>Please read instructions before use. Test on an inconspicuous area before complete application.</font></p><p style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0); margin-right: 0px; margin-bottom: 0px; margin-left: 0px;"><font face="Times New Roman" color="#000000" style="font-stretch: normal; font-size: 12px; line-height: normal; font-family: &quot;Times New Roman&quot;; font-variant-ligatures: common-ligatures;"><span class="Apple-tab-span" style="white-space: pre;">	</span>Storage instruction : Ambient with care.</font></p>
        val attribute: String,
        val backorders: String,
        val batchno: String,
        val brand: String, // 62a027a50ecf0e5d454b25ba
        val category: List<String>,
        val cgst: String,
        @SerializedName("combo_products")
        val comboProducts: Any?, // null
        val commission: String,
        val createdAt: String, // 2022-06-08T04:46:24.479Z
        @SerializedName("created_date")
        val createdDate: String, // 2022-06-07T15:33:21.505Z
        val cuisine: Any?, // null
        val deal: Any?, // null
        val deleted: Int, // 0
        val desc: String, // <p style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0); margin-right: 0px; margin-bottom: 0px; margin-left: 0px;"><font face="Times New Roman" color="#000000" style="font-stretch: normal; font-size: 12px; line-height: normal; font-family: &quot;Times New Roman&quot;; font-variant-ligatures: common-ligatures;">Presto's moistened glass and mirror cleaning wipes are intended for cleaning the glass surfaces of windows, mirrors, and tables. They efficiently remove dirt and fingerprints thanks to active substances. The formula contains alcohol, which means that the surface is left shiny and smudge-free. They also prevent misting due to an anti-steam agent.</font></p>
        val details: String, // <p style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0); margin-right: 0px; margin-bottom: 0px; margin-left: 0px;"><font face="Times New Roman" color="#000000" style="font-stretch: normal; font-size: 12px; line-height: normal; font-family: &quot;Times New Roman&quot;; font-variant-ligatures: common-ligatures;">Quantity : 30</font></p><p style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0); margin-right: 0px; margin-bottom: 0px; margin-left: 0px;"><font face="Times New Roman" color="#000000" style="font-stretch: normal; font-size: 12px; line-height: normal; font-family: &quot;Times New Roman&quot;; font-variant-ligatures: common-ligatures;">Brand : Presto</font></p>
        @SerializedName("discounted_price")
        val discountedPrice: Any?, // null
        @SerializedName("end_date")
        val endDate: String, // 2022-06-07T15:33:21.505Z
        val express: Boolean, // false
        val featured: Any?, // null
        val `file`: List<File>,
        val height: String,
        @SerializedName("_id")
        val id: String, // 62a029a00ecf0e5d454b26bb
        val igst: String,
        val length: String,
        @SerializedName("manage_stock")
        val manageStock: Int, // 1
        @SerializedName("master_category")
        val masterCategory: List<String>,
        val name: String, // PRESTO HOUSEHOLD WIPES FOR GLASS
        val options: List<Any>,
        @SerializedName("packaging_charge")
        val packagingCharge: String,
        val point: Int, // 0
        @SerializedName("point_exp_date")
        val pointExpDate: String, // 2022-06-07T15:33:21.505Z
        val price: Double, // 8.7
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
        val shortDesc: String, // The product does not irritate the skin of the hands
        val sku: String, // 66929874216
        val slug: String, // presto-household-wipes-for-glass
        @SerializedName("slug_history")
        val slugHistory: List<String>,
        @SerializedName("start_date")
        val startDate: String, // 2022-06-07T15:33:21.505Z
        @SerializedName("stock_qty")
        val stockQty: String, // 10
        @SerializedName("sub_category")
        val subCategory: List<String>,
        val tags: String, // Home Essentials
        @SerializedName("tax_status")
        val taxStatus: String,
        val threshold: String, // 2
        @SerializedName("update_date")
        val updateDate: String, // 2022-06-07T15:33:21.505Z
        val updatedAt: String, // 2022-06-08T04:46:24.479Z
        @SerializedName("__v")
        val v: Int, // 0
        val vendor: String, // 6299bfa32628522274d09e43
        @SerializedName("video_url")
        val videoUrl: String,
        val weight: String,
        val width: String
    ) {
        data class File(
            val acl: String, // public-read
            val bucket: String, // swagbag-files
            val contentDisposition: Any?, // null
            val contentEncoding: Any?, // null
            val contentType: String, // application/octet-stream
            val encoding: String, // 7bit
            val etag: String, // "75948701d02b7b6cd5a9188cd0092e5d"
            val fieldname: String, // upload
            val key: String, // 16546635839019y9fs.jpeg
            val location: String, // https://swagbag-files.s3.amazonaws.com/16546635839019y9fs.jpeg
            val metadata: Any?, // null
            val mimetype: String, // image/jpeg
            val originalname: String, // 7. PRESTO HOUSEHOLD WIPES FOR GLASS 30s.jpg
            val serverSideEncryption: Any?, // null
            val size: Int, // 21067
            val storageClass: String // STANDARD
        )
    }

    class Menu
}