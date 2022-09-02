package com.alexapps.simklapp.server.model


import com.google.gson.annotations.SerializedName

data class Ids(
    @SerializedName("simkl_id")
    val simklId: Int? = null,
    @SerializedName("slug")
    val slug: String? = null
)