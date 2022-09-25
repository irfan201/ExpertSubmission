package com.example.core.domain.usecase

import com.example.core.domain.model.Animals
import com.example.core.source.Resource
import kotlinx.coroutines.flow.Flow

interface AnimalsUseCase {
    fun getAllAnimals(): Flow<Resource<List<Animals>>>
    fun getFavoriteAnimal(): Flow<List<Animals>>
    fun setFavoriteAnimal(disney: Animals, state: Boolean)
}