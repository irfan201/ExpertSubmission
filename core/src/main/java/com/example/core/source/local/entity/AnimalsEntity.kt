package com.example.core.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "animals")
data class AnimalsEntity(

        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: Int? = null,

        @ColumnInfo(name = "name")
        val name: String? = null,

        @ColumnInfo(name = "image")
        val imageLink: String? = null,

        @ColumnInfo(name = "habitat")
        val habitat: String? = null,

        @ColumnInfo(name = "weight_min")
        val weightMin: String? = null,

        @ColumnInfo(name = "latin_name")
        val latinName: String? = null,

        @ColumnInfo(name = "animal_type")
        val animalType: String? = null,

        @ColumnInfo(name = "active_time")
        val activeTime: String?= null,

        @ColumnInfo(name = "lifespan")
        val lifespan: String? = null,

        @ColumnInfo(name = "geo_range")
        val geoRange: String? = null,

        @ColumnInfo(name = "length_min")
        val lengthMin: String? = null,

        @ColumnInfo(name = "weight_max")
        val weighMax: String? = null,

        @ColumnInfo(name = "isFavorite")
        var isFavorite: Boolean = false

        ):Parcelable