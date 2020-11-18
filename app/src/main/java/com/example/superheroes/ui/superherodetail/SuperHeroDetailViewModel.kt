package com.example.superheroes.ui.superherodetail

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.superheroes.repository.SuperHeroDetailRepository

class SuperHeroDetailViewModel @ViewModelInject constructor(
    private val superHeroDetailRepository: SuperHeroDetailRepository,
    @Assisted private val savedStateHandle: SavedStateHandle) : ViewModel() {


    fun show(){
        Log.e("ViewModel", savedStateHandle.get<String>("heroId")!!)
    }
}