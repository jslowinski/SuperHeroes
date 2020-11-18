package com.example.superheroes.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.superheroes.model.SuperHero
import com.example.superheroes.model.SuperHeroDetail

@Database(
    entities = [SuperHero::class, SuperHeroDetail::class],
    version = 1
)
@TypeConverters(value = [TypeResponseConverter::class])
abstract class AppDatabase: RoomDatabase() {

    abstract fun superHeroDao(): SuperHeroDao
    abstract fun superHeroDetailDao(): SuperHeroDetailDao
}