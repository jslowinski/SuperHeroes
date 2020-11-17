package com.example.superheroes.network

import com.example.superheroes.model.SuperHero
import com.example.superheroes.model.SuperHeroDetail
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("3155585961212068/{id}")
    fun fetchHeroDetailAsync(@Path("id") id: String) : Deferred<SuperHeroDetail>

    @GET("HeroList.json")
    fun fetchHeroListAsync() : Deferred<List<SuperHero>>
}