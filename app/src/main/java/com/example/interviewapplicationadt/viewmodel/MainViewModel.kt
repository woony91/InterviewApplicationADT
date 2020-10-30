package com.example.interviewapplicationadt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewapplicationadt.data.Repository
import com.example.interviewapplicationadt.data.remote.Api
import com.example.interviewapplicationadt.model.CharacterResponse
import com.example.interviewapplicationadt.util.ApiState
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _characters = MutableLiveData<ApiState<CharacterResponse>>()
    val charactersObservable: LiveData<ApiState<CharacterResponse>>
        get() = _characters


    init {
        getCharacters()
    }

    private fun getCharacters() = viewModelScope.launch {
        _characters.value = ApiState.Loading
        val state = try {
            val response = Repository.getCharacters()
            ApiState.Success(response)
        } catch (ex: Exception) {
            ApiState.Error(ex)
        }
        _characters.value = state
    }
}