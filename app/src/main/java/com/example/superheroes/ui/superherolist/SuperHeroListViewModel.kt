package com.example.superheroes.ui.superherolist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.superheroes.repository.SuperHeroListRepository
import kotlinx.coroutines.launch


class SuperHeroListViewModel @ViewModelInject constructor(
    private val superHeroListRepository: SuperHeroListRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            superHeroListRepository.refreshData()
        }
    }

    val list = superHeroListRepository.superHeroList
}
