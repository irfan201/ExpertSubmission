package com.example.core.utils

import com.example.core.domain.model.Animals
import com.example.core.source.local.entity.AnimalsEntity
import com.example.core.source.remote.response.AnimalsResponseItem

object DataMaper {

    fun mapResponseToEntities(input: List<AnimalsResponseItem>): List<AnimalsEntity>{
        val animalList = ArrayList<AnimalsEntity>()
        input.map {
            val animals = AnimalsEntity(
                id = it.id,
                name = it.name,
                imageLink = it.imageLink,
                habitat = it.habitat,
                weightMin = it.weightMin,
                latinName = it.latinName,
                animalType = it.animalType,
                activeTime = it.activeTime,
                lifespan = it.lifespan,
                geoRange = it.geoRange,
                lengthMin = it.lenghtMin,
                weighMax = it.weightMax,
                isFavorite = false
            )
            animalList.add(animals)
        }
        return animalList
    }

    fun mapEntitiesToDomain(input: List<AnimalsEntity>): List<Animals> =
        input.map {
            Animals(
                id = it.id,
                name = it.name,
                imageLink = it.imageLink,
                habitat = it.habitat,
                weightMin = it.weightMin,
                latinName = it.latinName,
                animalType = it.animalType,
                activeTime = it.activeTime,
                lifespan = it.lifespan,
                geoRange = it.geoRange,
                lenghtMin = it.lengthMin,
                weightMax = it.weighMax,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Animals) = AnimalsEntity(
        id = input.id,
        name = input.name,
        imageLink = input.imageLink,
        habitat = input.habitat,
        weightMin = input.weightMin,
        latinName = input.latinName,
        animalType = input.animalType,
        activeTime = input.activeTime,
        lifespan = input.lifespan,
        geoRange = input.geoRange,
        lengthMin = input.lenghtMin,
        weighMax = input.weightMax,
        isFavorite = input.isFavorite
    )
}