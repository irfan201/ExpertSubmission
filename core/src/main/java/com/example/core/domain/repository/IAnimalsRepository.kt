package com.example.core.domain.repository

import com.example.core.domain.model.Animals
import com.example.core.source.Resource
import kotlinx.coroutines.flow.Flow

interface IAnimalsRepository {

    fun getAllAnimals(): Flow<Resource<List<Animals>>>

    fun getFavoriteAnimal(): Flow<List<Animals>>

    fun setFavoriteAnimal(animals: Animals, state: Boolean)
}