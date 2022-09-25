package com.example.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.AnimalsUseCase
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(animalsUseCase: AnimalsUseCase) : ViewModel() {

        val favoriteAnimal = animalsUseCase.getFavoriteAnimal().asLiveData()

}
