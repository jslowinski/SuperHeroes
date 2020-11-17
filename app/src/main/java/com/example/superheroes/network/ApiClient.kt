package com.example.superheroes.network

import com.example.superheroes.di.NetworkModule
import javax.inject.Inject

class ApiClient @Inject constructor(
    @NetworkModule.FirstRetrofitUrl private val apiService: ApiService
) { suspend fun fetchHeroDetail(
        id: String
    ) = apiService.fetchHeroDetailAsync(
        id = id
    ).await()
}

class ApiClient2 @Inject constructor(
    @NetworkModule.SecondRetrofitUrl private val apiService: ApiService
) {
    suspend fun fetchHeroes() = apiService.fetchHeroListAsync().await()
}