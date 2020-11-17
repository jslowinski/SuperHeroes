package com.example.superheroes.model

import com.example.superheroes.model.lists.Biography
import com.example.superheroes.model.lists.PowerStats
import com.squareup.moshi.Json


data class SuperHeroDetail(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "powerstats") val powerstats: PowerStats,
    @Json(name = "biography") val biography: Biography
)