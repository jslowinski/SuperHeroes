package com.example.superheroes.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.superheroes.database.SuperHeroDetailDao
import com.example.superheroes.model.SuperHeroDetail
import com.example.superheroes.network.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class SuperHeroDetailRepository  @Inject constructor(
    private val apiClient: ApiClient,
    private val superHeroDao: SuperHeroDetailDao) {

    fun getData(id: String): LiveData<SuperHeroDetail> {
        return superHeroDao.getHeroDetail(id)
    }

    suspend fun refreshData(id: String) {
        withContext(Dispatchers.IO) {
            try {
                val newData = apiClient.fetchHeroDetail(id)
                superHeroDao.removeAndInsert(newData, id)
            } catch (e: Exception) {
                Log.e("Error", e.toString())
            }
        }
    }
}