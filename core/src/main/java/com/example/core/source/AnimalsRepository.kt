package com.example.core.source


import com.example.core.domain.model.Animals
import com.example.core.domain.repository.IAnimalsRepository
import com.example.core.source.local.LocalDataSource
import com.example.core.source.remote.RemoteDataSource
import com.example.core.source.remote.network.ApiResponse
import com.example.core.source.remote.response.AnimalsResponse
import com.example.core.source.remote.response.AnimalsResponseItem
import com.example.core.utils.AppExecutors
import com.example.core.utils.DataMaper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnimalsRepository @Inject constructor(private val remoteDataSource: RemoteDataSource,
                                            private val localDataSource: LocalDataSource,
                                            private val appExecutors: AppExecutors
) : IAnimalsRepository {

    override fun getAllAnimals(): Flow<Resource<List<Animals>>> =
        object : com.example.core.source.NetworkBoundResource<List<Animals>, List<AnimalsResponseItem>>(){
            override fun loadFromDB(): Flow<List<Animals>> {
                return localDataSource.getAllAnimals().map {
                    DataMaper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Animals>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<List<AnimalsResponseItem>>> = remoteDataSource.getAllAnimals()

            override suspend fun saveCallResult(data: List<AnimalsResponseItem>) {
                val animals = DataMaper.mapResponseToEntities(data)
                localDataSource.insertAnimal(animals)
            }
        }.asFlow()


    override fun getFavoriteAnimal(): Flow<List<Animals>> {
        return localDataSource.getFavoriteAnimal().map {
            DataMaper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteAnimal(animals: Animals, state: Boolean) {
        val animalEntity = DataMaper.mapDomainToEntity(animals)
        appExecutors.diskIO.execute{localDataSource.setFavoriteAnimal(animalEntity,state)}
    }


}
