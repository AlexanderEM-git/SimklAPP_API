package com.alexapps.simklapp.server.moviesrespository

import com.alexapps.simklapp.server.TvDB

class TvRepository {

    private val apiKey = "3bbd6c2c5bf0fa78aa1726c2f18476ee990832961e222ce552eb86ce3c981f49"

    suspend fun getBestTV() = TvDB.retrofit.getBestTV(apiKey) // optenemos la respuesta de lista en corrutina

}