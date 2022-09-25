package com.example.expertsubmission.di

import com.example.core.domain.usecase.AnimalsUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDepedencies {
    fun animalsUseCase(): AnimalsUseCase
}