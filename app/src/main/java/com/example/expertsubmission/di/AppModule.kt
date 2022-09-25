package com.example.expertsubmission.di

import com.example.core.domain.usecase.AnimalsInteractor
import com.example.core.domain.usecase.AnimalsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideAnimalsUseCase(animalsInteractor: AnimalsInteractor): AnimalsUseCase
}