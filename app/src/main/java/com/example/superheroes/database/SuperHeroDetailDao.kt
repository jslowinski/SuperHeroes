package com.example.superheroes.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.superheroes.model.SuperHeroDetail

@Dao
interface SuperHeroDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroDetail(heroDetail: SuperHeroDetail)

    @Query("SELECT * FROM SuperHeroDetail WHERE id = :id_")
    fun getHeroDetail(id_ : String): LiveData<SuperHeroDetail>

    @Query("DELETE FROM SuperHeroDetail WHERE id = :id_")
    suspend fun deleteItem(id_: String)

    @Transaction
    suspend fun removeAndInsert(entities: SuperHeroDetail, id_: String) {
        deleteItem(id_)
        insertHeroDetail(entities)
    }
}