package com.example.superheroes.ui.superherodetail

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.superheroes.repository.SuperHeroDetailRepository
import kotlinx.coroutines.launch

class SuperHeroDetailViewModel @ViewModelInject constructor(
    private val superHeroDetailRepository: SuperHeroDetailRepository,
    @Assisted private val savedStateHandle: SavedStateHandle) : ViewModel() {

    val selectedProperty = superHeroDetailRepository.getData(savedStateHandle.get<String>("heroId")!!)
    val url = savedStateHandle.get<String>("heroUrl")!!

    private val _navigateBack = MutableLiveData<Boolean?>()
    val navigateBack : LiveData<Boolean?>
        get() = _navigateBack

    fun back(){
        _navigateBack.value = true
    }

    fun doneNavigating(){
        _navigateBack.value = null
    }

    init {
        viewModelScope.launch {
            superHeroDetailRepository.refreshData(savedStateHandle.get<String>("heroId")!!)
        }
    }
}