package com.example.superheroes.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class SuperHeroDetail(
    @Json(name = "id") @PrimaryKey val id: String,
    @Json(name = "name") val name: String,
    @Embedded(prefix = "powerstats_") @Json(name = "powerstats") val powerStats: PowerStats,
    @Embedded(prefix = "biography_") @Json(name = "biography") val biography: Biography,
    @Embedded(prefix = "appearance_") @Json(name = "appearance") val appearance: Appearance
) {
    @JsonClass(generateAdapter = true)
    data class PowerStats(
        @Json(name = "intelligence") val intelligence: String,
        @Json(name = "strength") val strength: String,
        @Json(name = "speed") val speed: String,
        @Json(name = "durability") val durability: String,
        @Json(name = "power") val power: String,
        @Json(name = "combat") val combat: String
    )

    @JsonClass(generateAdapter = true)
    data class Biography(
        @Json(name = "full-name") val fullName: String,
        @Json(name = "alter-egos") val alterEgos: String,
        @Json(name = "aliases") val aliases: List<String>,
        @Json(name = "place-of-birth") val placeOfBirth: String,
        @Json(name = "alignment") val alignment: String
    )

    @JsonClass(generateAdapter = true)
    data class Appearance(
        @Json(name = "gender") val gender: String,
        @Json(name = "race") val race: String,
        @Json(name = "height") val height: List<String>,
        @Json(name = "weight") val weight: List<String>,
        @Json(name = "eye-color") val eyeColor: String,
        @Json(name = "hair-color") val hairColor: String
    )
}