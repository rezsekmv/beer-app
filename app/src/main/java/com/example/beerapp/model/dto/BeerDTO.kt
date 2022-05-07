package com.example.beerapp.model.dto

import com.example.beerapp.model.entity.BeerEntity
import com.squareup.moshi.Json

data class BeerDTO(
    var id: Int,
    var name: String,
    @Json(name = "first_brewed")
    var year: String,
    var description: String,
    @Json(name = "image_url")
    var image: String
)

fun BeerDTO.toBeerEntity() = BeerEntity(
    id = id,
    name = name,
    year = year,
    description = description
)