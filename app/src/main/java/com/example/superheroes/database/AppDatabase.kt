package com.example.superheroes.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.superheroes.model.SuperHero
import com.example.superheroes.model.SuperHeroDetail

@Database(
    entities = [SuperHero::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun superHeroDao(): SuperHeroDao
//    abstract fun superHeroDetailDao(): SuperHeroDetailDao
}