package com.example.superheroes.ui.superherolist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.superheroes.model.SuperHero
import com.example.superheroes.repository.SuperHeroListRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber


class SuperHeroListViewModel @ViewModelInject constructor(
    private val superHeroListRepository: SuperHeroListRepository
) : ViewModel() {


    private val _list = MutableLiveData<List<SuperHero>>()

    val list: LiveData<List<SuperHero>>
        get() = _list

    init {
        getList()
    }

    fun getList(){
        viewModelScope.launch {
            superHeroListRepository.fetchSuperHeroList()
                .onEach { dataState ->
                    Timber.e(dataState.toString())
                    _list.value = dataState
                }
                .launchIn(viewModelScope)
        }
    }
}
