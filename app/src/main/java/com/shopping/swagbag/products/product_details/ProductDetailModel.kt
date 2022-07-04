package com.shopping.swagbag.products.product_details


import com.google.gson.annotations.SerializedName

data class ProductDetailModel(
    @SerializedName("category_related")
    val categoryRelated: List<CategoryRelated>,
    val menu: Menu,
    val message: String,
    val related: List<Related>,
    val result: Result,
    val review: List<Any>,
    val status: String // success
) {
    data class CategoryRelated(
        val active: Int, // 1
        @SerializedName("added_by")
        val addedBy: String, // 5fe463f5a9e14206002dd63e
        @SerializedName("additional_description")
        val additionalDescription: String, // <span data-sheets-value="{&quot;1&quot;:2,&quot;2&quot;:&quot;Exquisitely hand-woven yoga mat&quot;}" data-sheets-userformat="{&quot;2&quot;:14845,&quot;3&quot;:{&quot;1&quot;:1},&quot;5&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:4144959}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;6&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:10855845}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;7&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:10855845}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;8&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:10855845}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;9&quot;:1,&quot;10&quot;:1,&quot;11&quot;:4,&quot;14&quot;:{&quot;1&quot;:2,&quot;2&quot;:0},&quot;15&quot;:&quot;Times New Roman&quot;,&quot;16&quot;:12}" style="color: rgb(0, 0, 0); font-size: 12pt; font-family: &quot;Times New Roman&quot;; text-align: center;">Exquisitely hand-woven yoga mat</span>
        val attribute: String,
        val backorders: String,
        val batchno: String,
        val brand: Brand,
        val category: List<Category>,
        val cgst: String,
        @SerializedName("combo_products")
        val comboProducts: Any?, // null
        val commission: String,
        val createdAt: String, // 2022-05-25T08:43:10.916Z
        @SerializedName("created_date")
        val createdDate: String, // 2022-05-20T08:44:57.318Z
        val cuisine: Any?, // null
        val deal: Int?, // 0
        val deleted: Int, // 0
        val desc: String, // <span data-sheets-value="{&quot;1&quot;:2,&quot;2&quot;:&quot;Product Details:\n\n100% organic cotton and natural ingredients \nFree from synthetic dyes and chemicals\nDyed with herbs to bring in the goodness of nature\nAnti-skid ribs and superior grip \n&quot;}" data-sheets-userformat="{&quot;2&quot;:15357,&quot;3&quot;:{&quot;1&quot;:0},&quot;5&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:4144959}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;6&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:10855845}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;7&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:10855845}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;8&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:10855845}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;9&quot;:1,&quot;10&quot;:1,&quot;11&quot;:4,&quot;12&quot;:0,&quot;14&quot;:{&quot;1&quot;:2,&quot;2&quot;:0},&quot;15&quot;:&quot;Times New Roman&quot;,&quot;16&quot;:12}" style="color: rgb(0, 0, 0); font-size: 12pt; font-family: &quot;Times New Roman&quot;; text-align: center;">Product Details:<br><br>100% organic cotton and natural ingredients<br>Free from synthetic dyes and chemicals<br>Dyed with herbs to bring in the goodness of nature<br>Anti-skid ribs and superior grip<br></span>
        val details: String, // <span data-sheets-value="{&quot;1&quot;:2,&quot;2&quot;:&quot;L 72′′ x W 28′′ (L 182cm x W 71cm) &quot;}" data-sheets-userformat="{&quot;2&quot;:15357,&quot;3&quot;:{&quot;1&quot;:0},&quot;5&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:4144959}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;6&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:10855845}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;7&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:10855845}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;8&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:10855845}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;9&quot;:1,&quot;10&quot;:1,&quot;11&quot;:4,&quot;12&quot;:0,&quot;14&quot;:{&quot;1&quot;:2,&quot;2&quot;:0},&quot;15&quot;:&quot;Times New Roman&quot;,&quot;16&quot;:12}" style="color: rgb(0, 0, 0); font-size: 12pt; font-family: &quot;Times New Roman&quot;; text-align: center;">L 72′′ x W 28′′ (L 182cm x W 71cm)</span><div><span data-sheets-value="{&quot;1&quot;:2,&quot;2&quot;:&quot;L 72′′ x W 28′′ (L 182cm x W 71cm) &quot;}" data-sheets-userformat="{&quot;2&quot;:15357,&quot;3&quot;:{&quot;1&quot;:0},&quot;5&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:4144959}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;6&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:10855845}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;7&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:10855845}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;8&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:10855845}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;9&quot;:1,&quot;10&quot;:1,&quot;11&quot;:4,&quot;12&quot;:0,&quot;14&quot;:{&quot;1&quot;:2,&quot;2&quot;:0},&quot;15&quot;:&quot;Times New Roman&quot;,&quot;16&quot;:12}" style="color: rgb(0, 0, 0); font-size: 12pt; font-family: &quot;Times New Roman&quot;; text-align: center;">1.3 kg</span></div>
        @SerializedName("discounted_price")
        val discountedPrice: String, // null
        @SerializedName("end_date")
        val endDate: String, // 2022-05-20T08:44:57.318Z
        val express: Boolean, // false
        val featured: Int?, // 1
        val `file`: List<File>,
        val height: String, // 71
        @SerializedName("_id")
        val id: String, // 628dec1e077b7f070a06a245
        val igst: String,
        val length: String, // 72
        @SerializedName("manage_stock")
        val manageStock: Int, // 1
        @SerializedName("master_category")
        val masterCategory: List<String>,
        val name: String, // Organic Cotton Yoga Mat
        val options: List<Option>,
        @SerializedName("packaging_charge")
        val packagingCharge: String,
        val point: Int, // 0
        @SerializedName("point_exp_date")
        val pointExpDate: String, // 2022-05-20T08:44:57.318Z
        val price: String, // 68.08
        @SerializedName("product_types")
        val productTypes: List<String>,
        @SerializedName("return_day")
        val returnDay: String,
        val returnable: String,
        @SerializedName("selling_price")
        val sellingPrice: String, // null
        val sgst: String,
        @SerializedName("shelving_location")
        val shelvingLocation: String, // Sharjah
        @SerializedName("short_desc")
        val shortDesc: String, // The Bhumi/Earth-inspired yoga mat is infused with the goodness of Holy Basil and other herbs to help you stay balanced and grounded.
        val sku: String, // 17003
        val slug: String, // organic-cotton-yoga-mat-1
        @SerializedName("slug_history")
        val slugHistory: List<String>,
        @SerializedName("start_date")
        val startDate: String, // 2022-05-20T08:44:57.318Z
        @SerializedName("stock_qty")
        val stockQty: String, // 10
        @SerializedName("sub_category")
        val subCategory: List<SubCategory>,
        val tags: String, // Sustainable, Eco Friendly, Organic Cotton, Self Love, Women, Men
        @SerializedName("tax_status")
        val taxStatus: String,
        val threshold: String, // 2
        @SerializedName("update_date")
        val updateDate: String, // 2022-05-20T08:44:57.318Z
        val updatedAt: String, // 2022-05-25T08:43:10.916Z
        @SerializedName("__v")
        val v: Int, // 0
        val vendor: Vendor,
        @SerializedName("video_url")
        val videoUrl: String,
        val weight: String, // 1.3 kg
        val width: String // 28
    ) {
        data class Brand(
            @SerializedName("_id")
            val id: String, // 6211f5c90fe91d273d21798e
            val name: String // The Eco Loop
        )

        data class Category(
            @SerializedName("_id")
            val id: String, // 625d05bfad10bc2c6a9bb90e
            val name: String // Self Love
        )

        data class File(
            val acl: String, // public-read
            val bucket: String, // swagbag-files
            val contentDisposition: Any?, // null
            val contentEncoding: Any?, // null
            val contentType: String, // application/octet-stream
            val encoding: String, // 7bit
            val etag: String, // "022e81cb9c15a14854ca681ddf6470ef"
            val fieldname: String, // upload
            val key: String, // 16534681887008a4lr.jpeg
            val location: String, // https://swagbag-files.s3.amazonaws.com/16534681887008a4lr.jpeg
            val metadata: Any?, // null
            val mimetype: String, // image/jpeg
            val originalname: String, // 01-Product-image.jpg
            val serverSideEncryption: Any?, // null
            val size: Int, // 31313
            val storageClass: String // STANDARD
        )

        data class Option(
            val name: String, // Colour
            val value: String // #FFA500:68.08:2023424:10
        )

        data class SubCategory(
            @SerializedName("_id")
            val id: String, // 625d0ac0ad10bc2c6a9bb9a5
            val name: String // Yoga
        )

        data class Vendor(
            @SerializedName("full_name")
            val fullName: String, // Eco Loop
            @SerializedName("_id")
            val id: String // 628dbf66077b7f070a0637ae
        )
    }

    class Menu

    data class Related(
        val active: Int, // 1
        @SerializedName("added_by")
        val addedBy: String, // 5fe463f5a9e14206002dd63e
        @SerializedName("additional_description")
        val additionalDescription: String,
        val attribute: String,
        val backorders: String,
        val batchno: String,
        val brand: Brand,
        val category: List<Category>,
        val cgst: String,
        @SerializedName("combo_products")
        val comboProducts: Any?, // null
        val commission: String,
        val createdAt: String, // 2022-06-23T12:54:04.242Z
        @SerializedName("created_date")
        val createdDate: String, // 2022-06-23T07:18:18.154Z
        val cuisine: Any?, // null
        val deal: Int?, // 0
        val deleted: Int, // 0
        val desc: String, // <span data-sheets-value="{&quot;1&quot;:2,&quot;2&quot;:&quot;Hair tie&quot;}" data-sheets-userformat="{&quot;2&quot;:12861,&quot;3&quot;:{&quot;1&quot;:0},&quot;5&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:0}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;6&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:0}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;7&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:0}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;8&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:0}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;12&quot;:0,&quot;15&quot;:&quot;Helvetica Neue&quot;,&quot;16&quot;:10}" style="color: rgb(0, 0, 0); font-size: 10pt; font-family: &quot;Helvetica Neue&quot;, Arial;">Hair tie</span>
        val details: String,
        @SerializedName("discounted_price")
        val discountedPrice: String, // null
        @SerializedName("end_date")
        val endDate: String, // 2022-06-23T07:18:18.154Z
        val express: Boolean, // false
        val featured: Int?, // 0
        val `file`: List<File>,
        val height: String,
        @SerializedName("_id")
        val id: String, // 62b4626c7f34526db619d295
        val igst: String,
        val length: String,
        @SerializedName("manage_stock")
        val manageStock: Int, // 1
        @SerializedName("master_category")
        val masterCategory: List<String>,
        val name: String, // Double Loop Mauve And Pink Hair Tie With Silver Heart
        val options: List<Option>,
        @SerializedName("packaging_charge")
        val packagingCharge: String,
        val point: Int, // 0
        @SerializedName("point_exp_date")
        val pointExpDate: String, // 2022-06-23T07:18:18.154Z
        val price: String, // 74
        @SerializedName("product_types")
        val productTypes: List<String>,
        @SerializedName("return_day")
        val returnDay: String,
        val returnable: String,
        @SerializedName("selling_price")
        val sellingPrice: String, // null
        val sgst: String,
        @SerializedName("shelving_location")
        val shelvingLocation: String, // Sharjah
        @SerializedName("short_desc")
        val shortDesc: String, // Look beautiful with this range of simple and elegant, fashionable and durable hair jewelry, they are elegant handcrafted hair ornaments by Moliabal Milano
        val sku: String, // 0000
        val slug: String, // double-loop-mauve-and-pink-hair-tie-with-silver-heart
        @SerializedName("slug_history")
        val slugHistory: List<String>,
        @SerializedName("start_date")
        val startDate: String, // 2022-06-23T07:18:18.154Z
        @SerializedName("stock_qty")
        val stockQty: String, // 10
        @SerializedName("sub_category")
        val subCategory: List<SubCategory>,
        val tags: String, // Sustainable, Women, Self Love, Accessories
        @SerializedName("tax_status")
        val taxStatus: String,
        val threshold: String, // 2
        @SerializedName("update_date")
        val updateDate: String, // 2022-06-23T07:18:18.154Z
        val updatedAt: String, // 2022-06-23T12:54:04.242Z
        @SerializedName("__v")
        val v: Int, // 0
        val vendor: Vendor,
        @SerializedName("video_url")
        val videoUrl: String,
        val weight: String,
        val width: String
    ) {

        data class Option(
            val name: String, // Colour
            val value: String // #FFA500:68.08:2023424:10
        )

        data class Brand(
            @SerializedName("_id")
            val id: String, // 6211ec380fe91d273d217961
            val name: String // Moliabal Milano
        )

        data class Category(
            @SerializedName("_id")
            val id: String, // 625d05bfad10bc2c6a9bb90e
            val name: String // Self Love
        )

        data class File(
            val acl: String, // public-read
            val bucket: String, // swagbag-files
            val contentDisposition: Any?, // null
            val contentEncoding: Any?, // null
            val contentType: String, // application/octet-stream
            val encoding: String, // 7bit
            val etag: String, // "58b58cbf754267956c4566336c691a52"
            val fieldname: String, // upload
            val key: String, // 1655988843557lv289.jpeg
            val location: String, // https://swagbag-files.s3.amazonaws.com/1655988843557lv289.jpeg
            val metadata: Any?, // null
            val mimetype: String, // image/jpeg
            val originalname: String, // Double Loop Mauve And Pink Hair Tie With Silver Heart.jpg
            val serverSideEncryption: Any?, // null
            val size: Int, // 8985
            val storageClass: String, // STANDARD
            val versionId: Any? // null
        )

        data class SubCategory(
            @SerializedName("_id")
            val id: String, // 625d0b84ad10bc2c6a9bb9bd
            val name: String // Accessories
        )

        data class Vendor(
            @SerializedName("full_name")
            val fullName: String, // Wellness United
            @SerializedName("_id")
            val id: String // 62a8404859f9f60990eb5320
        )
    }

    data class Result(
        val active: Int, // 1
        @SerializedName("added_by")
        val addedBy: String, // 5fe463f5a9e14206002dd63e
        @SerializedName("additional_description")
        val additionalDescription: String, // Hair Claw
        val attribute: String,
        val backorders: String,
        val batchno: String,
        val brand: Brand,
        val category: List<Category>,
        val cgst: String,
        @SerializedName("combo_products")
        val comboProducts: Any?, // null
        val commission: String,
        val createdAt: String, // 2022-06-24T13:14:56.076Z
        @SerializedName("created_date")
        val createdDate: String, // 2022-06-23T07:18:18.154Z
        val cuisine: Any?, // null
        val deal: Any?, // null
        val deleted: Int, // 0
        val desc: String, // <span data-sheets-value="{&quot;1&quot;:2,&quot;2&quot;:&quot;Stylish jewelry from MOLIABAL, the first Italian brand dedicated to luxury hair accessories, will allow you to find a unique personality and artistic charm. Hairpins add a little romantic touch to your look. The products are very dense, resistant to changes over time, but also delicate, as they are handmade, elegant and pleasant to touch. They have a strong reliable mechanism&quot;}" data-sheets-userformat="{&quot;2&quot;:13117,&quot;3&quot;:{&quot;1&quot;:0},&quot;5&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:0}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;6&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:0}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;7&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:0}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;8&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:0}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;11&quot;:4,&quot;12&quot;:0,&quot;15&quot;:&quot;Helvetica Neue&quot;,&quot;16&quot;:10}" style="color: rgb(0, 0, 0); font-size: 10pt; font-family: &quot;Helvetica Neue&quot;, Arial;">Stylish jewelry from MOLIABAL, the first Italian brand dedicated to luxury hair accessories, will allow you to find a unique personality and artistic charm. Hairpins add a little romantic touch to your look. The products are very dense, resistant to changes over time, but also delicate, as they are handmade, elegant and pleasant to touch. They have a strong reliable mechanism</span>
        val details: String,
        @SerializedName("discounted_price")
        val discountedPrice: String, // null
        @SerializedName("end_date")
        val endDate: String, // 2022-06-23T07:18:18.154Z
        val express: Boolean, // false
        val featured: Any?, // null
        val `file`: List<File>,
        val height: String,
        @SerializedName("_id")
        val id: String, // 62b5b8cf7f34526db619ed71
        val igst: String,
        val length: String,
        @SerializedName("manage_stock")
        val manageStock: Int, // 1
        @SerializedName("master_category")
        val masterCategory: List<String>,
        val name: String, // Large Ivory And Black Hair Claw
        val options: List<Option>,
        @SerializedName("packaging_charge")
        val packagingCharge: String,
        val point: Int, // 0
        @SerializedName("point_exp_date")
        val pointExpDate: String, // 2022-06-23T07:18:18.154Z
        val price: String, // 147
        @SerializedName("product_types")
        val productTypes: List<ProductType>,
        @SerializedName("return_day")
        val returnDay: String,
        val returnable: String,
        @SerializedName("selling_price")
        val sellingPrice: String, // null
        val sgst: String,
        @SerializedName("shelving_location")
        val shelvingLocation: String, // Sharjah
        @SerializedName("short_desc")
        val shortDesc: String, // Handmade MOLIABAL MILANO hairpins are made of high quality natural resins and embody a democratic European design and a special Italian chic. 
        val sku: String, // 0000
        val slug: String, // large-ivory-and-black-hair-claw
        @SerializedName("slug_history")
        val slugHistory: List<String>,
        @SerializedName("start_date")
        val startDate: String, // 2022-06-23T07:18:18.154Z
        @SerializedName("stock_qty")
        val stockQty: String, // 10
        @SerializedName("sub_category")
        val subCategory: List<SubCategory>,
        val tags: String, // Sustainable, Women, Self Love, Accessories
        @SerializedName("tax_status")
        val taxStatus: String,
        val threshold: String, // 2
        @SerializedName("update_date")
        val updateDate: String, // 2022-06-23T07:18:18.154Z
        val updatedAt: String, // 2022-06-24T13:14:56.076Z
        @SerializedName("__v")
        val v: Int, // 0
        val vendor: Vendor,
        @SerializedName("video_url")
        val videoUrl: String,
        val weight: String,
        val width: String
    ) {
        data class Option(
            val name: String, // Color
            val value: String // #d41367:500:SKU123:51, #1913d4:1000:SKU456:50, #4dd413:0:SKU4578:50
        )

        data class Brand(
            @SerializedName("_id")
            val id: String, // 6211ec380fe91d273d217961
            val name: String // Moliabal Milano
        )

        data class Category(
            @SerializedName("_id")
            val id: String, // 625d05bfad10bc2c6a9bb90e
            val name: String // Self Love
        )

        data class File(
            val acl: String, // public-read
            val bucket: String, // swagbag-files
            val contentDisposition: Any?, // null
            val contentEncoding: Any?, // null
            val contentType: String, // application/octet-stream
            val encoding: String, // 7bit
            val etag: String, // "c0dab2539fc011f5334aba0f10a0f1d7"
            val fieldname: String, // upload
            val key: String, // 1656076495289uhva4.jpeg
            val location: String, // https://swagbag-files.s3.amazonaws.com/1656076495289uhva4.jpeg
            val metadata: Any?, // null
            val mimetype: String, // image/jpeg
            val originalname: String, // Large Ivory And Black Hair Claw.jpg
            val serverSideEncryption: Any?, // null
            val size: Int, // 13733
            val storageClass: String // STANDARD
        )

        data class ProductType(
            val active: Int, // 1
            @SerializedName("created_date")
            val createdDate: String, // 2022-05-20T08:44:57.532Z
            val deleted: Int, // 0
            val `file`: String, // https://swagbag-files.s3.amazonaws.com/1653541273188sz0gk.png
            @SerializedName("_id")
            val id: String, // 628f0999077b7f070a06ca4d
            val name: String, // Sustainable
            @SerializedName("update_date")
            val updateDate: String, // 2022-05-20T08:44:57.532Z
            @SerializedName("__v")
            val v: Int // 0
        )

        data class SubCategory(
            @SerializedName("_id")
            val id: String, // 625d0b84ad10bc2c6a9bb9bd
            val name: String // Accessories
        )

        data class Vendor(
            @SerializedName("full_name")
            val fullName: String, // Wellness United
            @SerializedName("_id")
            val id: String // 62a8404859f9f60990eb5320
        )
    }
}