package com.alexapps.simklapp.server.model


import com.google.gson.annotations.SerializedName

data class Ratings(
    @SerializedName("imdb")
    val imdb: Imdb? = null,
    @SerializedName("simkl")
    val simkl: Simkl? = null
)