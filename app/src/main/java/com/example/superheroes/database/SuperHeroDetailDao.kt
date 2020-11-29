package com.example.superheroes.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.superheroes.model.SuperHeroDetail

@Dao
abstract class SuperHeroDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertHeroDetail(heroDetail: SuperHeroDetail)

    @Query("SELECT * FROM SuperHeroDetail WHERE id = :id_")
    abstract fun getHeroDetail(id_ : String): LiveData<SuperHeroDetail>

    @Query("DELETE FROM SuperHeroDetail WHERE id = :id_")
    abstract suspend fun deleteItem(id_: String)

    @Transaction
    open suspend fun removeAndInsert(entities: SuperHeroDetail, id_: String) {
        deleteItem(id_)
        insertHeroDetail(entities)
    }
}