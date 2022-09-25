package com.example.core.domain.usecase

import com.example.core.domain.model.Animals
import com.example.core.domain.repository.IAnimalsRepository
import com.example.core.source.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimalsInteractor @Inject constructor(private val iAnimalsRepository: IAnimalsRepository): AnimalsUseCase {

    override fun getAllAnimals(): Flow<Resource<List<Animals>>>  = iAnimalsRepository.getAllAnimals()

    override fun getFavoriteAnimal(): Flow<List<Animals>> = iAnimalsRepository.getFavoriteAnimal()

    override fun setFavoriteAnimal(animals: Animals, state: Boolean) = iAnimalsRepository.setFavoriteAnimal(animals,state)
}