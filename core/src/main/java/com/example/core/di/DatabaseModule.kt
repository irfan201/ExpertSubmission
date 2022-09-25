package com.example.core.di

import android.content.Context
import androidx.room.Room
import com.example.core.source.local.room.AnimalsDao
import com.example.core.source.local.room.AnimalsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : AnimalsDatabase = Room.databaseBuilder(
        context,
        AnimalsDatabase::class.java, "Animal.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideAnimalsDao(database: AnimalsDatabase): AnimalsDao = database.disneyDao()

}