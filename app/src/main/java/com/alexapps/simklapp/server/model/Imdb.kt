package com.alexapps.simklapp.server.model


import com.google.gson.annotations.SerializedName

data class Imdb(
    @SerializedName("rating")
    val rating: Double? = null,
    @SerializedName("votes")
    val votes: Int? = null
)