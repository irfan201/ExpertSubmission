package com.example.expertsubmission.detail

import androidx.lifecycle.ViewModel
import com.example.core.domain.model.Animals
import com.example.core.domain.usecase.AnimalsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val animalsUseCase: AnimalsUseCase) : ViewModel() {

    fun setFavoriteAnimal(animals: Animals, newFavoriteStatus: Boolean) =
        animalsUseCase.setFavoriteAnimal(animals, newFavoriteStatus)

}