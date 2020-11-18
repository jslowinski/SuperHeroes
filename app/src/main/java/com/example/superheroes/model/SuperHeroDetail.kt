package com.example.superheroes.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class SuperHeroDetail(
    @Json(name = "id") @PrimaryKey val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "powerstats") val powerStats: List<PowerStats>
//    @Json(name = "biography") val biography: List<Biography>
) {
    data class PowerStats(
        @Json(name = "intelligence") val intelligence: String,
        @Json(name = "strength") val strength: String,
        @Json(name = "speed") val speed: String,
        @Json(name = "durability") val durability: String,
        @Json(name = "power") val power: String,
        @Json(name = "combat") val combat: String
    )

    data class Biography(
        @Json(name = "full-name") val fullName: String,
        @Json(name = "alter-egos") val AlterEgos: String,
        @Json(name = "aliases") val aliases: List<String>,
        @Json(name = "place-of-birth") val placeOfBirth: String
    )
}