package com.example.core.source.remote

import android.util.Log
import com.example.core.source.remote.network.ApiResponse
import com.example.core.source.remote.network.ApiService
import com.example.core.source.remote.response.AnimalsResponse
import com.example.core.source.remote.response.AnimalsResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllAnimals(): Flow<ApiResponse<List<AnimalsResponseItem>>> {
        return flow {
            try {
                val response = apiService.getAnimals()
                val dataArray = response.animalsResponse
                Log.e("RemoteDataSource", "getAllAnimals: $dataArray")
                if (dataArray!=null){
                    emit(ApiResponse.Success(response.animalsResponse))
                }else{
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}