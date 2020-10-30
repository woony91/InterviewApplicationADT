package com.example.interviewapplicationadt.data

import com.example.interviewapplicationadt.data.remote.Api

object Repository {

    suspend fun getCharacters() = Api.getRickMortyService().getCharacters()
}