package com.shopping.swagbag.search


import com.google.gson.annotations.SerializedName

data class MobileProductSearchModel(
    val result: List<Result>,
    val status: String // success
) {
    data class Result(
        val active: Int, // 1
        @SerializedName("added_by")
        val addedBy: String, // 5fe463f5a9e14206002dd63e
        @SerializedName("additional_description")
        val additionalDescription: String, // <ul style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0);"><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">How does macadamia oil help your hair and scalp?<br>Macadamia oil is great for calming the hair of frizz, tangles, and dullness. This lightweight, non-greasy nutty oil adds shine and vitality to your strands while coating your ends and keeping your scalp moisturized. An overall beauty oil for scalp, skin and hair, macadamia oil has been a staple for years because it can produce positive results. From hot oil treatments to scalp massages, this oil is here to stay as a favorite with its potent composition and lightweight nature.</font></li></ul><p style="margin-right: 0px; margin-bottom: 0px; margin-left: 0px; font-stretch: normal; line-height: normal; font-family: Helvetica; color: rgb(0, 0, 0); min-height: 11px;"><font style="font-variant-ligatures: common-ligatures;"></font><br></p><ul style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0);"><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">How to use:</font></li><ul style="list-style-type: disc;"><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Completely saturate your hair with warm, not hot, water.</font></li><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Squirt a small amount of shampoo into the palm of your hand.</font></li><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Apply it to your scalp and massage until it lathers.</font></li><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Work the shampoo through your hair, but pay the most attention to the scalp.</font></li><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Rinse your hair and scalp completely.</font></li></ul></ul>
        val attribute: String,
        val backorders: String,
        val batchno: String,
        val brand: Brand,
        val category: List<String>,
        val cgst: String,
        @SerializedName("combo_products")
        val comboProducts: Any?, // null
        val commission: String,
        val createdAt: String, // 2022-05-18T10:37:11.911Z
        @SerializedName("created_date")
        val createdDate: String, // 2022-05-17T07:49:01.868Z
        val cuisine: Any?, // null
        val deal: Int?, // 0
        val deleted: Int, // 0
        val desc: String, // <p style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0); margin-right: 0px; margin-bottom: 0px; margin-left: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">High content of vitamin E and B vitamins. It effectively restores thin and fragile hair, as well as damaged and colored hair, making it look healthy.</font></p><p style="margin-right: 0px; margin-bottom: 0px; margin-left: 0px; font-stretch: normal; line-height: normal; font-family: Helvetica; color: rgb(0, 0, 0); min-height: 11px;"><font style="font-variant-ligatures: common-ligatures;"></font><br></p><p style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0); margin-right: 0px; margin-bottom: 0px; margin-left: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Features:</font></p><ul style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0);"><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Enriched with vitamin E and B</font></li><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Macadamia oil also has excellent nourishing properties</font></li><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Effectively restores thin and fragile hair, as well as damaged and colored hair, making it look healthy.</font></li></ul>
        val details: String, // <ul style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0);"><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Size : 350 ml</font></li><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Target Hair Type : All Hair Types</font></li><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Scent : Witch Hazel</font></li><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Hair Treatment Type : Volume &amp; Texture</font></li><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Package Dimensions&nbsp;<span class="Apple-converted-space">&nbsp;</span>: &nbsp;22.2 x 5.1 x 5 cm;</font></li><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Weight :&nbsp;0.4KG</font></li><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Manufacturer&nbsp;<span class="Apple-converted-space">&nbsp;</span>: &nbsp;EO Laboratorie natural &amp; organic</font></li><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">SKU : 4627089432162</font></li><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Country of Origin : Russia</font></li><li style="margin: 0px;"><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica;"></font><font face="Helvetica" color="#000000" style="font-stretch: normal; line-height: normal; font-family: Helvetica; font-variant-ligatures: common-ligatures;">Cautions : Store at room temperature</font></li></ul>
        @SerializedName("discounted_price")
        val discountedPrice: Any?, // null
        @SerializedName("end_date")
        val endDate: String, // 2022-05-17T00:00:00.000Z
        val express: Boolean, // false
        val featured: Int?, // 0
        val `file`: List<File>,
        val height: String,
        @SerializedName("_id")
        val id: String, // 6284cc57e8ab8129cbf66469
        val igst: String,
        val length: String,
        @SerializedName("manage_stock")
        val manageStock: Int, // 1
        @SerializedName("master_category")
        val masterCategory: List<String>,
        val name: String, // MACADAMIA OIL SHAMPOO, NOURISHING, DEEP RESTORE AND VOLUME
        val options: List<Any>,
        @SerializedName("packaging_charge")
        val packagingCharge: String,
        val point: Int, // 0
        @SerializedName("point_exp_date")
        val pointExpDate: String, // 2022-05-17T07:49:01.868Z
        val price: Double, // 51.45
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
        val shortDesc: String, // Protects your hair from harmful environmental effects
        val sku: String, // 4627089432162
        val slug: String, // macadamia-oil-shampoo-nourishing-deep-restore-and-volume
        @SerializedName("slug_history")
        val slugHistory: List<String>,
        @SerializedName("start_date")
        val startDate: String, // 2022-05-17T00:00:00.000Z
        @SerializedName("stock_qty")
        val stockQty: String, // 10
        @SerializedName("sub_category")
        val subCategory: List<String>,
        val tags: String, // Women Care, Men Care, Hair Care, Silicon Free, Paraben Free, Sulfate Free
        @SerializedName("tax_status")
        val taxStatus: String,
        val threshold: String, // 2
        @SerializedName("update_date")
        val updateDate: String, // 2022-05-17T07:49:01.868Z
        val updatedAt: String, // 2022-05-18T10:38:26.282Z
        @SerializedName("__v")
        val v: Int, // 0
        val vendor: String, // 62750231fc9ddb176c788d22
        @SerializedName("video_url")
        val videoUrl: String,
        val weight: String, // 0.4KG
        val width: String
    ) {
        data class Brand(
            val active: Int, // 1
            @SerializedName("created_date")
            val createdDate: String, // 2022-02-19T09:53:51.911Z
            val deleted: Int, // 0
            val desc: String, // Organic Cosmetics
            val desc2: String,
            val desc3: String,
            val `file`: String, // https://swagbag.sgp1.digitaloceanspaces.com/1645438293843ok7a8.webp
            val file2: String,
            val file3: String,
            val file4: String,
            @SerializedName("_id")
            val id: String, // 6211dc2f0fe91d273d2178b9
            val name: String, // Green Cosmetics
            @SerializedName("seo_desc")
            val seoDesc: String,
            @SerializedName("seo_title")
            val seoTitle: String,
            @SerializedName("short_desc")
            val shortDesc: Any?, // null
            val slug: String, // green-cosmetics
            @SerializedName("slug_history")
            val slugHistory: List<String>,
            @SerializedName("update_date")
            val updateDate: String, // 2022-02-21T10:11:35.000Z
            @SerializedName("__v")
            val v: Int // 0
        )

        data class File(
            val acl: String, // public-read
            val bucket: String, // swagbag-files
            val contentDisposition: Any?, // null
            val contentEncoding: Any?, // null
            val contentType: String, // application/octet-stream
            val encoding: String, // 7bit
            val etag: String, // "00f12baca9cad98aa7cacef78d4626bf"
            val fieldname: String, // upload
            val key: String, // 16528702279285tcqf.jpeg
            val location: String, // https://swagbag-files.s3.amazonaws.com/16528702279285tcqf.jpeg
            val metadata: Any?, // null
            val mimetype: String, // image/jpeg
            val originalname: String, // 80. MACADAMIA OIL SHAMPOO, NOURISHING, DEEP RESTORE AND VOLUME 1.jpg
            val serverSideEncryption: Any?, // null
            val size: Int, // 8336
            val storageClass: String, // STANDARD
            val versionId: Any? // null
        )
    }
}