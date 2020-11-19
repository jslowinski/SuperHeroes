package com.example.superheroes.ui.superherolist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.superheroes.repository.SuperHeroListRepository
import kotlinx.coroutines.launch


class SuperHeroListViewModel @ViewModelInject constructor(
    private val superHeroListRepository: SuperHeroListRepository
) : ViewModel() {


//    private val _list = MutableLiveData<List<SuperHero>>()
//
//    val list: LiveData<List<SuperHero>>
//        get() = _list
//
//    init {
//        getList()
//    }
//
//    fun getList(){
//        viewModelScope.launch {
//            superHeroListRepository.fetchSuperHeroList()
//                .onEach { dataState ->
//                    _list.value = dataState
//                }
//                .launchIn(viewModelScope)
//        }
//    }

    init {
        viewModelScope.launch {
            superHeroListRepository.refreshData()
        }
    }

    val list = superHeroListRepository.superHeroList
}
