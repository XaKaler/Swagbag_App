package com.shopping.swagbag.blog


import com.google.gson.annotations.SerializedName

data class BlogListModel(
    val result: List<Result>,
    val status: String // success
) {
    data class Result(
        @SerializedName("blog_category")
        val blogCategory: BlogCategory,
        val createdAt: String, // 2022-05-24T17:31:14.636Z
        val description: String, // <p class="MsoNormal" style="margin-bottom: 0cm; line-height: normal; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;"><span style="font-size: 12pt; font-family: &quot;Open Sans&quot;, sans-serif;">Lorem Ipsum issimply dummy text of the printing and typesetting industry. Lorem Ipsum hasbeen the industry's standard dummy text ever since the 1500s, when an unknownprinter took a galley of type and scrambled it to make a type specimen book. Ithas survived not only five centuries, but also the leap into electronictypesetting, remaining essentially unchanged. It was popularised in the 1960swith the release of Letraset sheets containing Lorem Ipsum passages, and morerecently with desktop publishing software like Aldus PageMaker includingversions of Lorem Ipsum.<o:p></o:p></span></p><p class="MsoNormal" style="margin-bottom: 0cm; line-height: normal; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;"><span style="font-size: 12pt; font-family: &quot;Open Sans&quot;, sans-serif;">&nbsp;</span></p><p class="MsoNormal" style="margin-bottom: 0cm; line-height: normal; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;"><span style="font-size: 12pt; font-family: &quot;Open Sans&quot;, sans-serif;">Contrary to popularbelief, Lorem Ipsum is not simply random text. It has roots in a piece ofclassical Latin literature from 45 BC, making it over 2000 years old. RichardMcClintock, a Latin professor at Hampden-Sydney College in Virginia, looked upone of the more obscure Latin words, consectetur, from a Lorem Ipsum passage,and going through the cites of the word in classical literature, discovered theundoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of"de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) byCicero, written in 45 BC. This book is a treatise on the theory of ethics, verypopular during the Renaissance. The first line of Lorem Ipsum, "Loremipsum dolor sit amet..", comes from a line in section 1.10.32.<o:p></o:p></span></p><p class="MsoNormal" style="margin-bottom: 0cm; line-height: normal; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;"><span style="font-size: 12pt; font-family: &quot;Open Sans&quot;, sans-serif;">&nbsp;</span></p><p class="MsoNormal" style="line-height: normal; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;"><b><span style="font-size: 20pt; font-family: &quot;Open Sans&quot;, sans-serif;">Where does it come from?</span></b><span style="font-size: 20pt; font-family: &quot;Open Sans&quot;, sans-serif;"><o:p></o:p></span></p><p class="MsoNormal" style="margin-bottom: 0cm; line-height: normal; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;"><span style="font-size: 12pt; font-family: &quot;Open Sans&quot;, sans-serif;">Contrary to popularbelief, Lorem Ipsum is not simply random text. It has roots in a piece ofclassical Latin literature from 45 BC, making it over 2000 years old. RichardMcClintock, a Latin professor at Hampden-Sydney College in Virginia, looked upone of the more obscure Latin words, consectetur, from a Lorem Ipsum passage,and going through the cites of the word in classical literature, discovered theundoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of"de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) byCicero, written in 45 BC. This book is a treatise on the theory of ethics, verypopular during the Renaissance. The first line of Lorem Ipsum, "Loremipsum dolor sit amet..", comes from a line in section 1.10.32.<o:p></o:p></span></p><p class="MsoNormal"><span style="font-size:12.0pt;line-height:107%;font-family:&quot;Open Sans&quot;,sans-serif">&nbsp;</span></p>
        @SerializedName("_id")
        val id: String, // 628d1662fe90cd33f450ce24
        val image: String, // https://swagbag-files.s3.amazonaws.com/1654698288847taptu.jpeg
        val slug: String, // what-is-lorem-ipsum-1
        @SerializedName("slug_history")
        val slugHistory: List<String>,
        val title: String, // What is Lorem Ipsumm?
        val updatedAt: String, // 2022-06-09T06:02:53.766Z
        @SerializedName("__v")
        val v: Int // 0
    ) {
        data class BlogCategory(
            @SerializedName("_id")
            val id: String, // 6180e37d423d021474d8bb89
            val name: String // BLOG TYPE 1
        )
    }
}