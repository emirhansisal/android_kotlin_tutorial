package com.example.android_kotlin_tutorial.models

import android.graphics.Color

data class ProductDetail(
    var ProductId: Int,
    var Desc: String,
    var Color: Int
)

object ProductDetailList {
    val items :MutableList<ProductDetail> = mutableListOf(
        ProductDetail(0, "I feel like I should write very long description ", Color.parseColor("#888888")),
        ProductDetail(1, "May be I do not have to make it so long ", Color.parseColor("#888888")),
        ProductDetail(2, "I dont know what I am gonna do with these descriptions ", Color.parseColor("#888888")),
        ProductDetail(3, "But I know that those descriptions are my job to do ", Color.parseColor("#888888")),
        ProductDetail(4, "Should have finished them earlier ", Color.parseColor("#888888")),
    )
}