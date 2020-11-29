package com.example.superheroes.repository

import androidx.lifecycle.LiveData
import com.example.superheroes.database.SuperHeroDao
import com.example.superheroes.model.SuperHero
import com.example.superheroes.network.ApiClient2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class SuperHeroListRepository @Inject constructor(
    private val apiClient2: ApiClient2,
    private val superHeroDao: SuperHeroDao) {

    val superHeroList: LiveData<List<SuperHero>> = superHeroDao.getAll()

    suspend fun refreshData() {
        withContext(Dispatchers.IO){
            try {
                val newData = apiClient2.fetchHeroes()
                superHeroDao.removeAndInsert(newData)
            } catch (e: Exception) {
            }
        }
    }

}
