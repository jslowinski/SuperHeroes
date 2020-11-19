package com.example.superheroes.repository

import android.util.Log
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

//    lateinit var superHeroes: List<SuperHero>
//    suspend fun fetchSuperHeroList() = flow {
//        try {
//            superHeroes = superHeroDao.getAll()
//            emit(superHeroes)
//            delay(100)
//            val response = apiClient2.fetchHeroes()
//            superHeroDao.insertAll(response)
//            superHeroes = superHeroDao.getAll()
//            emit(superHeroes)
//        } catch (e: Exception) {
//
//        }
//    }

    val superHeroList: LiveData<List<SuperHero>> = superHeroDao.getAll()

    suspend fun refreshData() {
        withContext(Dispatchers.IO){
            try {
                val newData = apiClient2.fetchHeroes()
                Log.e("FetchData", newData.toString())
                superHeroDao.removeAndInsert(newData)
            } catch (e: Exception) {
            }
        }
    }

}
