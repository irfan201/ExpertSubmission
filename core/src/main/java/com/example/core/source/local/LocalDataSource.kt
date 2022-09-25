package com.example.core.source.local

import com.example.core.source.local.entity.AnimalsEntity
import com.example.core.source.local.room.AnimalsDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val animalsDao: AnimalsDao) {

    fun getAllAnimals() : Flow<List<AnimalsEntity>> = animalsDao.getAllAnimals()

    fun getFavoriteAnimal(): Flow<List<AnimalsEntity>> = animalsDao.getFavoriteAnimal()

    suspend fun insertAnimal(animal: List<AnimalsEntity>) = animalsDao.insertAnimal(animal)

    fun setFavoriteAnimal(animal: AnimalsEntity, newState: Boolean) {
        animal.isFavorite = newState
        animalsDao.updateAnimal(animal)
    }
}
