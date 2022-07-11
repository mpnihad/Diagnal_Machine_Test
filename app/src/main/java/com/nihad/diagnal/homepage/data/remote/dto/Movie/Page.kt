package com.nihad.diagnal.homepage.data.remote.dto.Movie



import com.google.gson.annotations.SerializedName

data class Page(
    @SerializedName("content-items")
    val contentItems: ContentItems,
    @SerializedName("page-num")
    val pageNum: String,
    @SerializedName("page-size")
    val pageSize: String,
    val title: String,
    val `total-content-items`: String
)