package com.example.superheroes.database

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import utils.MockUtil.mockHero
import utils.MockUtil.mockHeroList
import utils.getOrAwaitValue

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(AndroidJUnit4::class)
class SuperHeroDaoTest: LocalDatabase() {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var superHeroDao: SuperHeroDao

    @Before
    fun init() {
        superHeroDao = db.superHeroDao()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun insertHeroesAndReadInList() = runBlockingTest() {
        val mockDataList = mockHeroList()
        val heroes = mockHero()

        db.superHeroDao().insertAll(mockDataList)

        val heroesList = db.superHeroDao().getAll().getOrAwaitValue()

        assertThat(heroesList.toString(), `is`(mockDataList.toString()))
        assertThat(heroesList[0].toString(), `is`(heroes.toString()))
    }
}