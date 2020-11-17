package com.example.superheroes.di

import android.app.Application
import androidx.room.Room
import com.example.superheroes.database.AppDatabase
import com.example.superheroes.database.SuperHeroDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application
    ): AppDatabase {
        return Room
            .databaseBuilder(
                application,
                AppDatabase::class.java,
                "SuperHero.db"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideSuperHeroDao(appDatabase: AppDatabase): SuperHeroDao {
        return appDatabase.superHeroDao()
    }
}