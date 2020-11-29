package com.example.superheroes.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.superheroes.model.SuperHero

@Dao
abstract class SuperHeroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertAll(heroList: List<SuperHero>)

    @Query("SELECT * FROM SuperHero")
    abstract fun getAll(): LiveData<List<SuperHero>>

    @Query("DELETE FROM SuperHero")
    abstract suspend fun removeAll()

    @Transaction
    open suspend fun removeAndInsert(entities: List<SuperHero>){
        removeAll()
        insertAll(entities)
    }
}