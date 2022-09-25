package com.example.favorite

import android.content.Context
import com.example.expertsubmission.di.FavoriteModuleDepedencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteModuleDepedencies::class])
interface FavoriteComponent {

    fun inject(activity: FavoriteActivity)

    @Component.Builder
    interface Builder{
        fun context(@BindsInstance context: Context): Builder
        fun appDepedencies(favoriteModuleDepedencies: FavoriteModuleDepedencies): Builder
        fun build(): FavoriteComponent
    }
}