package com.alexapps.simklapp.server.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TvItem(
    @SerializedName("ids")
    val ids: Ids? = null,
    @SerializedName("poster")
    val poster: String? = null,
    @SerializedName("ratings")
    val ratings: Ratings? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("year")
    val year: Int? = null
): Serializable // Serializable me permite enviar esta info a otro fragmento