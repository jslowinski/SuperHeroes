package com.example.superheroes.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.superheroes.model.SuperHeroDetail

//@Dao
//interface SuperHeroDetailDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertHeroDetail(heroDetail: SuperHeroDetail)
//
//    @Query("SELECT * FROM SuperHeroDetail WHERE id = :id_")
//    suspend fun getHeroDetail(id_ : String): SuperHeroDetail?
//}