package com.example.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Animals (
    val id : Int? = null,
    val name: String? = null,
    val imageLink: String? = null,
    val habitat: String? = null,
    val weightMin: String? = null,
    val latinName: String? = null,
    val animalType: String? = null,
    val activeTime: String? = null,
    val lifespan: String? = null,
    val geoRange: String? = null,
    val lenghtMin: String? = null,
    val weightMax: String? = null,
    val isFavorite : Boolean
        ): Parcelable