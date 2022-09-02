package com.alexapps.simklapp.server

import com.alexapps.simklapp.server.model.Tv
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("tv/best/filter?type=series")
    suspend fun getBestTV(@Query("client_id") apiKey : String): Tv  //retornamos una lista
}