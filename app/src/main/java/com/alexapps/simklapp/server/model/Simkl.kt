package com.alexapps.simklapp.server.model


import com.google.gson.annotations.SerializedName

data class Simkl(
    @SerializedName("rating")
    val rating: Double? = null,
    @SerializedName("votes")
    val votes: Int? = null
)