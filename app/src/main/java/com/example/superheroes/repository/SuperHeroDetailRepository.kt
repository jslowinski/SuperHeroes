package com.example.superheroes.repository

import com.example.superheroes.database.SuperHeroDao
import com.example.superheroes.database.SuperHeroDetailDao
import com.example.superheroes.network.ApiClient
import javax.inject.Inject

class SuperHeroDetailRepository  @Inject constructor(
    private val apiClient: ApiClient,
    private val superHeroDao: SuperHeroDetailDao) {
}