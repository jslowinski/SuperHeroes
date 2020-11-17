package com.example.superheroes.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.superheroes.model.SuperHero

@Dao
interface SuperHeroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(heroList: List<SuperHero>)

    @Query("SELECT * FROM SuperHero")
    suspend fun getAll(): List<SuperHero>
}