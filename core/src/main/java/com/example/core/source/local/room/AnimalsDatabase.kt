package com.example.core.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.core.source.local.entity.AnimalsEntity

@Database(entities = [AnimalsEntity::class], version = 1, exportSchema = false)
abstract class AnimalsDatabase: RoomDatabase() {

    abstract fun disneyDao(): AnimalsDao

    companion object {
        @Volatile
        private var INSTANCE: AnimalsDatabase? = null

        fun getInstance(context: Context) : AnimalsDatabase =
            INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AnimalsDatabase::class.java,
                    "animals.db"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
    }
}