package com.example.expertsubmission.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.AnimalsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(animalsUseCase: AnimalsUseCase) : ViewModel() {
    val animal = animalsUseCase.getAllAnimals().asLiveData()
}

