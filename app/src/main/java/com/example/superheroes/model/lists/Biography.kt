package com.example.superheroes.model.lists

import com.squareup.moshi.Json

data class Biography(
    @Json(name = "full-name") val fullName: String,
    @Json(name = "alter-egos") val AlterEgos: String,
    @Json(name = "aliases") val aliases: List<String>,
    @Json(name = "place-of-birth") val placeOfBirth: String
)