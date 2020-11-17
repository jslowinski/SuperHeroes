package com.example.superheroes.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.superheroes.model.lists.Biography
import com.example.superheroes.model.lists.PowerStats
import com.squareup.moshi.Json

@Entity
data class SuperHeroDetail(
    @Json(name = "id") @PrimaryKey val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "powerstats") val powerStats: PowerStats,
    @Json(name = "biography") val biography: Biography
)