package com.example.core.source.local.room

import androidx.room.*
import com.example.core.source.local.entity.AnimalsEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface AnimalsDao {

    @Query("SELECT * FROM animals")
    fun getAllAnimals(): Flow<List<AnimalsEntity>>

    @Query("SELECT * FROM animals where isFavorite = 1")
    fun getFavoriteAnimal(): Flow<List<AnimalsEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAnimal(animal: List<AnimalsEntity>)

    @Update
    fun updateAnimal(animal: AnimalsEntity)
}