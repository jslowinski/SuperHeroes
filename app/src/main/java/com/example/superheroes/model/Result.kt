package com.example.superheroes.model

import com.squareup.moshi.Json

data class Result<T>(
    @Json(name = "result") val result: List<T>
)