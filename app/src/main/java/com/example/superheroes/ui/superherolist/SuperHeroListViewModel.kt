package com.example.superheroes.ui.superherolist

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.superheroes.model.SuperHeroDetail
import com.example.superheroes.network.ApiClient
import com.example.superheroes.network.ApiClient2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception


class SuperHeroListViewModel @ViewModelInject constructor(
    private val apiClient2: ApiClient
) : ViewModel() {


    private val _list = MutableLiveData<SuperHeroDetail>()

    val list: LiveData<SuperHeroDetail>
        get() = _list

    fun getList(){
        viewModelScope.launch {
            val getListDeferred = apiClient2.fetchHeroDetail("644")
            try {
                Log.e("ModelView", getListDeferred.biography.toString())
            } catch (e: Exception) {
                Log.e("ViewModel", e.toString())
            }
        }
    }
}
