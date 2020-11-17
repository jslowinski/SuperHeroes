package com.example.superheroes.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Entity
data class SuperHero(
    @Json(name = "id") @PrimaryKey val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "image") val url: String,
)