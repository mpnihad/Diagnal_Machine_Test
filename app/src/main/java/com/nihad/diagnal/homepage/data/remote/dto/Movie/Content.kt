package com.nihad.diagnal.homepage.data.remote.dto.Movie

import com.google.gson.annotations.SerializedName

data class Content(
    val name: String,
    @SerializedName("poster-image")
    val posterImage: String
)