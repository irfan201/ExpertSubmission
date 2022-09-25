package com.example.core.source.remote.network

import com.example.core.source.remote.response.AnimalsResponse
import retrofit2.http.GET

interface ApiService {

    @GET("d03f2da2-1203-4411-ac4a-2ec0f408958b")
    suspend fun getAnimals(): AnimalsResponse
}