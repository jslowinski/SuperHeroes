package com.example.superheroes.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.superheroes.model.SuperHero

@Dao
interface SuperHeroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(heroList: List<SuperHero>)

    @Query("SELECT * FROM SuperHero")
    fun getAll(): LiveData<List<SuperHero>>

    @Query("DELETE FROM SuperHero")
    suspend fun removeAll()

    suspend fun removeAndInsert(entities: List<SuperHero>){
        removeAll()
        insertAll(entities)
    }
}