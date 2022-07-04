package com.shopping.swagbag.home


import com.google.gson.annotations.SerializedName

data class HomeModel(
    val result: Result,
    val status: String // success
) {
    data class Result(
        val deals: List<Deal>,
        val featured: List<Featured>,
        @SerializedName("master_category")
        val masterCategory: List<MasterCategory>,
        val section: List<Section>,
        val slider: List<Slider>
    ) {
        data class Deal(
            val active: Int, // 1
            @SerializedName("added_by")
            val addedBy: String?, // 5fe463f5a9e14206002dd63e
            @SerializedName("additional_description")
            val additionalDescription: String, // <p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Areas of application:</span></span></span></span></p><p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">For refreshment of facial skin.</span></span></span></span></p><p style="text-align:start"><br /><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Application:</span></span></span></span></p><p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Apply in the morning and in the evening to facial skin after cleaning (as needed with a cotton pad).</span></span></span></span></p><p style="text-align:start">&nbsp;</p><p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Ingredients:</span></span></span></span></p><p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Aqua, Alcohol, Whey*, Glycerin, Sodium Hyaluronate, Aloe Barbadensis Leaf Extract*, Polyglyceryl-10 Laurate, Sodium Phytate, Parfum, Citric Acid, Lactic Acid, Limonene, Linalool</span></span></span></span></p>
            val attribute: String,
            val backorders: String,
            val batchno: String,
            val brand: String, // 62baf0c8370fe81ae998b8d9
            val category: List<String>,
            val cgst: String,
            @SerializedName("combo_products")
            val comboProducts: Any?, // null
            val commission: String,
            val createdAt: String?, // 2022-06-30T05:58:06.663Z
            @SerializedName("created_date")
            val createdDate: String, // 2022-06-29T10:47:46.412Z
            val cuisine: Any?, // null
            val deal: Int, // 1
            val deleted: Int, // 0
            val desc: String, // <p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">The combination of the lacto-intensive active complex, hyaluronan and aloe vera has a regenerating and calming effect and provides intensive moisture.</span></span></span></span></p><p style="text-align:start">&nbsp;</p><p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">The result: Perfectly prepared facial skin for further care with our face creams. The scent matches with&nbsp;Make-up remover milk No.51.</span></span></span></span></p>
            val details: String?, // <p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Size : 150 ml</span></span></span></span></p><p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Certification: : BDIH</span></span></span></span></p><p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Vegan: : No (Lacto-intensive active complex)</span></span></span></span></p><p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Brand : Bioturm</span></span></span></span></p>
            @SerializedName("discounted_price")
            val discountedPrice: Any?, // null
            @SerializedName("end_date")
            val endDate: String, // 2022-06-29T10:47:46.412Z
            val express: Boolean, // false
            val featured: Int, // 1
            val `file`: List<File>,
            val height: String,
            @SerializedName("_id")
            val id: String, // 62bd3b6e9e4e33539100ea6d
            val igst: String,
            val length: String,
            @SerializedName("manage_stock")
            val manageStock: Int, // 1
            @SerializedName("master_category")
            val masterCategory: List<String>,
            val name: String, // Face tonic
            val options: List<Any>,
            @SerializedName("packaging_charge")
            val packagingCharge: String,
            val point: Int, // 0
            @SerializedName("point_exp_date")
            val pointExpDate: String, // 2022-06-29T10:47:46.412Z
            val price: Double, // 42.49
            @SerializedName("product_types")
            val productTypes: List<String>,
            @SerializedName("return_day")
            val returnDay: String, // 1
            val returnable: String, // 7
            @SerializedName("selling_price")
            val sellingPrice: Any?, // null
            val sgst: String,
            @SerializedName("shelving_location")
            val shelvingLocation: String, // Sharjah
            @SerializedName("short_desc")
            val shortDesc: String, // Stimulates and refreshes facial skin.
            val sku: String, // 34705798
            val slug: String, // face-tonic-2
            @SerializedName("slug_history")
            val slugHistory: List<String>,
            @SerializedName("start_date")
            val startDate: String, // 2022-06-29T10:47:46.412Z
            @SerializedName("stock_qty")
            val stockQty: String, // 10
            @SerializedName("sub_category")
            val subCategory: List<String>,
            val tags: String, // Climate Neutral Product, Synthetic Fragrance Free, Synthetic Dyes Free, PEG Free, Paraffin Oil Free, BDIH Certified
            @SerializedName("tax_status")
            val taxStatus: String,
            val threshold: String,
            @SerializedName("update_date")
            val updateDate: String, // 2022-06-29T10:47:46.412Z
            val updatedAt: String, // 2022-06-30T05:58:06.663Z
            @SerializedName("__v")
            val v: Int, // 0
            val vendor: String, // 62baf0a9370fe81ae998b8d2
            @SerializedName("video_url")
            val videoUrl: String,
            val weight: String,
            val width: String
        ) {
            data class File(
                val acl: String?, // public-read
                val bucket: String?, // swagbag-files
                val contentDisposition: Any?, // null
                val contentEncoding: Any?, // null
                val contentType: String?, // application/octet-stream
                val encoding: String?, // 7bit
                val etag: String?, // "b6cf7a9d03d4ed284496bded0b9bc7ae"
                val fieldname: String?, // upload
                val key: String?, // 1650351887558mum5t.jpeg
                val location: String, // https://swagbag-files.s3.amazonaws.com/16565686860564i6qr.jpg
                val metadata: Any?, // null
                val mimetype: String?, // image/jpeg
                val originalname: String?, // Bamboo Soap Dish P1.jpg
                val serverSideEncryption: Any?, // null
                val size: Int?, // 20553
                val storageClass: String? // STANDARD
            )
        }

        data class Featured(
            val active: Int, // 1
            @SerializedName("added_by")
            val addedBy: Any?, // null
            @SerializedName("additional_description")
            val additionalDescription: String, // <p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Areas of application:</span></span></span></span></p><p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Basic care for dry skin.</span></span></span></span></p><p style="text-align:start"><br /><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Application:</span></span></span></span></p><p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Apply several times a day to desired areas of skin.</span></span></span></span></p><p style="text-align:start">&nbsp;</p><p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Ingredients:</span></span></span></span></p><p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Aqua, Glycerin, Cannabis Sativa Seed Oil, Whey*, Oleyl Erucate, Pentylene Glycol**, Squalane, Cetearyl Alcohol, Glyceryl Stearate Citrate, Polyglyceryl-3 Stearate, Jojoba Esters/Helianthus Annuus (Sunflower) Seed Wax/Acacia Decurrens Flower Wax/Polyglycerin-3, Cetyl Palmitate, Butyrospermum Parkii Butter*, Helianthus Annuus Hybrid Oil*, Sesamum Indicum Seed Oil*, Palmitic Acid, Sodium Polyphosphat, Stearic Acid, Cannabidiol (CBD 0,5 %), Dipotassium Glycyrrhizate, Helianthus Annuus Seed Oil, Sodium Hyaluronate, Tocopherol, Sodium Levulinate, Xanthan Gum, Sodium Anisate, Oryzanol</span></span></span></span></p>
            val attribute: String,
            val backorders: String,
            val batchno: String,
            val brand: String, // 62baf0c8370fe81ae998b8d9
            val category: List<String>,
            val cgst: String,
            @SerializedName("combo_products")
            val comboProducts: Any?, // null
            val commission: String,
            val createdAt: String, // 2022-06-30T07:35:15.583Z
            @SerializedName("created_date")
            val createdDate: String, // 2022-06-29T10:47:46.412Z
            val cuisine: Any?, // null
            val deal: Int, // 1
            val deleted: Int, // 0
            val desc: String, // The fragrance-free basic care with cannabidiol nourishes the skin and provides a long-lasting smooth skin feeling. With its high content of omega-3 and omega-6 fatty acids, hemp oil has a regenerating and soothing effect on the skin. The special lacto-intensive active complex normalises the skin’s acid mantle.
            val details: String, // <p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Size : 50 ml / 3 ml sachet</span></span></span></span></p><p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Certification: : BDIH COSMOS</span></span></span></span></p><p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Vegan: : No (Lacto-intensive active complex)</span></span></span></span></p><p style="text-align:start"><span style="color:#000000"><span style="font-family:Helvetica Neue"><span style="font-size:small"><span style="color:#000000">Brand : Bioturm</span></span></span></span></p>
            @SerializedName("discounted_price")
            val discountedPrice: Any?, // null
            @SerializedName("end_date")
            val endDate: String, // 2022-06-29T10:47:46.412Z
            val express: Boolean, // false
            val featured: Int, // 1
            val `file`: List<File>,
            val height: String,
            @SerializedName("_id")
            val id: String, // 62bd52329e4e33539100edbb
            val igst: String,
            val length: String,
            @SerializedName("manage_stock")
            val manageStock: Int, // 1
            @SerializedName("master_category")
            val masterCategory: List<String>,
            val name: String, // CBD ointment
            val options: List<Any>,
            @SerializedName("packaging_charge")
            val packagingCharge: String,
            val point: Int, // 0
            @SerializedName("point_exp_date")
            val pointExpDate: String, // 2022-06-29T10:47:46.412Z
            val price: Double, // 3.69
            @SerializedName("product_types")
            val productTypes: List<String>,
            @SerializedName("return_day")
            val returnDay: String, // 7
            val returnable: String, // 1
            @SerializedName("selling_price")
            val sellingPrice: Any?, // null
            val sgst: String,
            @SerializedName("shelving_location")
            val shelvingLocation: String, // Sharjah
            @SerializedName("short_desc")
            val shortDesc: String, // Fragrance-free basic care with cannabidiol and hemp oil!
            val sku: String, // 34711310
            val slug: String, // cbd-ointment-3
            @SerializedName("slug_history")
            val slugHistory: List<String>,
            @SerializedName("start_date")
            val startDate: String, // 2022-06-29T10:47:46.412Z
            @SerializedName("stock_qty")
            val stockQty: String, // 10
            @SerializedName("sub_category")
            val subCategory: List<String>,
            val tags: String, // Climate Neutral Product, Synthetic Fragrance Free, Synthetic Dyes Free, PEG Free, Paraffin Oil Free
            @SerializedName("tax_status")
            val taxStatus: String,
            val threshold: String,
            @SerializedName("update_date")
            val updateDate: String, // 2022-06-29T10:47:46.412Z
            val updatedAt: String, // 2022-06-30T07:35:15.583Z
            @SerializedName("__v")
            val v: Int, // 0
            val vendor: String, // 62baf0a9370fe81ae998b8d2
            @SerializedName("video_url")
            val videoUrl: String,
            val weight: String,
            val width: String
        ) {
            data class File(
                val location: String // https://swagbag-files.s3.amazonaws.com/1656574514714obhdo.jpg
            )
        }

        data class MasterCategory(
            val active: Int, // 1
            @SerializedName("created_date")
            val createdDate: String, // 2021-12-15T14:49:50.596Z
            val deleted: Int, // 0
            val desc: String, // women
            val `file`: String, // https://swagbag-files.s3.amazonaws.com/16499400355203dlpx.jpeg
            @SerializedName("_id")
            val id: String, // 61bd25a466538a1c1f366ac3
            val name: String, // Women
            @SerializedName("short_desc")
            val shortDesc: String, // women
            val slug: String, // women
            @SerializedName("slug_history")
            val slugHistory: List<String>,
            val sort: Int, // 2
            @SerializedName("update_date")
            val updateDate: String, // 2022-04-14T12:40:36.000Z
            @SerializedName("__v")
            val v: Int // 0
        )

        data class Section(
            val banner: List<Banner>,
            val master: Master
        ) {
            data class Banner(
                val active: Int, // 1
                val brand: Brand?,
                val category: String, // 618e6d4bae7db56d2c44981e
                @SerializedName("created_date")
                val createdDate: String, // 2022-02-16T14:51:03.693Z
                val deleted: Int, // 0
                val `file`: String, // https://swagbag-files.s3.amazonaws.com/1655451879710gvz6o.png
                @SerializedName("_id")
                val id: String, // 6210b7ff5f5e06bee40138b9
                @SerializedName("master_category")
                val masterCategory: String, // 61bd25a466538a1c1f366ac3
                val product: Product?,
                val section: Int, // 4
                @SerializedName("update_date")
                val updateDate: String, // 2022-06-17T07:44:39.000Z
                val url: String,
                @SerializedName("__v")
                val v: Int // 0
            ) {
                data class Brand(
                    val active: Int, // 1
                    @SerializedName("created_date")
                    val createdDate: String, // 2022-02-19T09:53:51.911Z
                    val deleted: Int, // 0
                    val desc: String, // The scented candles and reed diffusers are made with carefully selected waxes and quality fragrances. The colourful range offers a great selection of floral, fruity, and spicy fragrances.
                    val desc2: String,
                    val desc3: String,
                    val `file`: Any?, // null
                    val file2: String,
                    val file3: String,
                    val file4: String,
                    @SerializedName("_id")
                    val id: String, // 621364f20fe91d273d218a8a
                    val name: String, // Aladino
                    @SerializedName("seo_desc")
                    val seoDesc: String,
                    @SerializedName("seo_title")
                    val seoTitle: String,
                    @SerializedName("short_desc")
                    val shortDesc: String?,
                    val slug: String, // aladino
                    @SerializedName("slug_history")
                    val slugHistory: List<String>,
                    @SerializedName("update_date")
                    val updateDate: String, // 2022-02-19T09:53:51.911Z
                    @SerializedName("__v")
                    val v: Int // 0
                )

                data class Product(
                    val active: Int, // 1
                    @SerializedName("added_by")
                    val addedBy: String, // 5fe463f5a9e14206002dd63e
                    @SerializedName("additional_description")
                    val additionalDescription: String, // <p style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0); margin-right: 0px; margin-bottom: 0px; margin-left: 0px;"><font face="Times New Roman" color="#000000" style="font-stretch: normal; font-size: 12px; line-height: normal; font-family: &quot;Times New Roman&quot;; font-variant-ligatures: common-ligatures;">BENEFITS: Burdock Root extract contains vitamins B complex and E. Burdock Root increases circulation to the skin, is mildly soothing and antioxidant. Mango butter is rich in antioxidants and emollients as well as vitamins A &amp; E. It softens and moisturizes dry skin. Milk proteins, amino acids and lactic acid calm and soothe dry, upset skin. . Rice bran powder is full of vitamins A, B2, B12 &amp; E, as well as naturally moisturizing proteins. It exfoliates and absorbs excess oils and dirt while smoothing skin. U.S. FARM HARVEST: Whole Milk from locally raised cows.</font></p><p style="margin-right: 0px; margin-bottom: 0px; margin-left: 0px; font-stretch: normal; font-size: 12px; line-height: normal; font-family: &quot;Times New Roman&quot;; color: rgb(0, 0, 0); min-height: 15px;"><font style="font-variant-ligatures: common-ligatures;"></font><br></p><p style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0); margin-right: 0px; margin-bottom: 0px; margin-left: 0px;"><font face="Times New Roman" color="#000000" style="font-stretch: normal; font-size: 12px; line-height: normal; font-family: &quot;Times New Roman&quot;; font-variant-ligatures: common-ligatures;">INGREDIENTS: Burdock Root, Mango Butter, Rice Powder, Whole Milk. NO PARABENS NO SULFATES NO PHTHALATES. Kaolin, Arctium Lappa Root (Burdock Root) Extract, Sodium Bicarbonate, Oryza Sativa (Rice) Powder, Citric Acid, Milk/Lait, Mangifera Indica (Mango Seed Butter), Vanilla Planifolia (Vanilla) Extract, Parfum*, Sucrose (Sugar). *Natural fragrance derived from 100% natural sources.</font></p><p style="margin-right: 0px; margin-bottom: 0px; margin-left: 0px; font-stretch: normal; font-size: 12px; line-height: normal; font-family: &quot;Times New Roman&quot;; color: rgb(0, 0, 0); min-height: 15px;"><font style="font-variant-ligatures: common-ligatures;"></font><br></p><p style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0); margin-right: 0px; margin-bottom: 0px; margin-left: 0px;"><font face="Times New Roman" color="#000000" style="font-stretch: normal; font-size: 12px; line-height: normal; font-family: &quot;Times New Roman&quot;; font-variant-ligatures: common-ligatures;">HOW TO USE: Pour a quarter-sized amount of Facial Buffing Mask into your palm then add about the same amount of drops of warm water to form a paste. Exfoliate your face in circular motions using your fingertips. Leave paste on your face as a treatment mask for 2-3 minutes to allow the muds, vitamins, milks and extracts to be fully absorbed. Then rinse. Recommended for normal to dry skin.</font></p>
                    val attribute: String,
                    val backorders: String,
                    val batchno: String,
                    val brand: String, // 62120dea0fe91d273d217b35
                    val category: List<String>,
                    val cgst: String,
                    @SerializedName("combo_products")
                    val comboProducts: Any?, // null
                    val commission: String,
                    val createdAt: String, // 2022-06-17T04:22:15.716Z
                    @SerializedName("created_date")
                    val createdDate: String, // 2022-06-16T16:03:02.779Z
                    val cuisine: Any?, // null
                    val deal: Int?, // 0
                    val deleted: Int, // 0
                    val desc: String, // <p style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0); margin-right: 0px; margin-bottom: 0px; margin-left: 0px;"><font face="Times New Roman" color="#000000" style="font-stretch: normal; font-size: 12px; line-height: normal; font-family: &quot;Times New Roman&quot;; font-variant-ligatures: common-ligatures;">To buff, balance, and nourish your skin, simply pour the buffing powder into your palm. Yes! A little bit goes a long way. Add a few drops of water to create an oatmeal-like paste, and exfoliate using circular motions. Whether used as a face mask, an exfoliator or both, your skin will feel like silk! Watch our biscuit video for more details. The powder formula is the same as our original biscuits, just in an easy-to-use form. Sold in a zip-seal package with 4-6 facial treatments, depending on whether you also treat your neck area.</font></p>
                    val details: String, // <p style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0); margin-right: 0px; margin-bottom: 0px; margin-left: 0px;"><font face="Times New Roman" color="#000000" style="font-stretch: normal; font-size: 12px; line-height: normal; font-family: &quot;Times New Roman&quot;; font-variant-ligatures: common-ligatures;">Size : 14.2 g</font></p><p style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0); margin-right: 0px; margin-bottom: 0px; margin-left: 0px;"><font face="Times New Roman" color="#000000" style="font-stretch: normal; font-size: 12px; line-height: normal; font-family: &quot;Times New Roman&quot;; font-variant-ligatures: common-ligatures;">Skin Type : Suitable for all skin types.</font></p><p style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0); margin-right: 0px; margin-bottom: 0px; margin-left: 0px;"><font face="Times New Roman" color="#000000" style="font-stretch: normal; font-size: 12px; line-height: normal; font-family: &quot;Times New Roman&quot;; font-variant-ligatures: common-ligatures;">Skincare That Saves : Your purchase help us rescue and care for forgotten, neglected and abused farm animals that come to live at our FHF Sanctuary. Follow their transformations&nbsp;here.</font></p><p style="caret-color: rgb(0, 0, 0); color: rgb(0, 0, 0); margin-right: 0px; margin-bottom: 0px; margin-left: 0px;"><font face="Times New Roman" color="#000000" style="font-stretch: normal; font-size: 12px; line-height: normal; font-family: &quot;Times New Roman&quot;; font-variant-ligatures: common-ligatures;">Brand : Farmhouse Fresh</font></p>
                    @SerializedName("discounted_price")
                    val discountedPrice: Any?, // null
                    @SerializedName("end_date")
                    val endDate: String, // 2022-06-16T16:03:02.779Z
                    val express: Boolean, // false
                    val featured: Int?, // 0
                    val `file`: List<File>,
                    val height: String,
                    @SerializedName("_id")
                    val id: String, // 62ac01774342c850bf9b2fa9
                    val igst: String,
                    val length: String,
                    @SerializedName("manage_stock")
                    val manageStock: Int, // 1
                    @SerializedName("master_category")
                    val masterCategory: List<String>,
                    val name: String, // Burdock & Butter Facial Buffing Powder Mix
                    val options: List<Any>,
                    @SerializedName("packaging_charge")
                    val packagingCharge: String,
                    val point: Int, // 0
                    @SerializedName("point_exp_date")
                    val pointExpDate: String, // 2022-06-16T16:03:02.779Z
                    val price: Double, // 9.1
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
                    val shortDesc: String, // Get calm, hydrated skin – even on the go
                    val sku: String, // 876087685903
                    val slug: String, // burdock-and-butter-facial-buffing-powder-mix
                    @SerializedName("slug_history")
                    val slugHistory: List<String>,
                    @SerializedName("start_date")
                    val startDate: String, // 2022-06-16T16:03:02.779Z
                    @SerializedName("stock_qty")
                    val stockQty: String, // 10
                    @SerializedName("sub_category")
                    val subCategory: List<String>,
                    val tags: String, // 100% Natural, Vegan. Gluten Free, Nut Free, Paraben Free, Sulfate Free, Phthalate Free Fragrance
                    @SerializedName("tax_status")
                    val taxStatus: String,
                    val threshold: String, // 2
                    @SerializedName("update_date")
                    val updateDate: String, // 2022-06-16T16:03:02.779Z
                    val updatedAt: String, // 2022-06-17T04:22:15.716Z
                    @SerializedName("__v")
                    val v: Int, // 0
                    val vendor: String, // 62a8404859f9f60990eb5320
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
                        val etag: String, // "4918cb78ad73e8e997516e0fa3ce1e8a"
                        val fieldname: String, // upload
                        val key: String, // 165543973515789x73.webp
                        val location: String, // https://swagbag-files.s3.amazonaws.com/165543973515789x73.webp
                        val metadata: Any?, // null
                        val mimetype: String, // image/webp
                        val originalname: String, // 76. Burdock & Butter Facial Buffing Powder Mix 1.webp
                        val serverSideEncryption: Any?, // null
                        val size: Int, // 12088
                        val storageClass: String // STANDARD
                    )
                }
            }

            data class Master(
                val active: Int, // 1
                @SerializedName("created_date")
                val createdDate: String, // 2021-12-15T14:49:50.596Z
                val deleted: Int, // 0
                val desc: String, // women
                val `file`: String, // https://swagbag-files.s3.amazonaws.com/16499400355203dlpx.jpeg
                @SerializedName("_id")
                val id: String, // 61bd25a466538a1c1f366ac3
                val name: String, // Women
                @SerializedName("short_desc")
                val shortDesc: String, // women
                val slug: String, // women
                @SerializedName("slug_history")
                val slugHistory: List<String>,
                val sort: Int, // 2
                @SerializedName("update_date")
                val updateDate: String, // 2022-04-14T12:40:36.000Z
                @SerializedName("__v")
                val v: Int // 0
            )
        }

        data class Slider(
            val active: Int, // 1
            @SerializedName("created_date")
            val createdDate: String, // 2022-04-15T06:12:14.263Z
            val deleted: Int, // 0
            val `file`: String, // https://swagbag-files.s3.amazonaws.com/1650019976132p05x9.jpeg
            @SerializedName("_id")
            val id: String, // 62594e02b7cca62581c332b8
            val name: String, // Slider 1
            @SerializedName("update_date")
            val updateDate: String, // 2022-04-15T10:52:57.000Z
            val url: String, // https://uae.swagbag.com
            @SerializedName("__v")
            val v: Int // 0
        )
    }
}