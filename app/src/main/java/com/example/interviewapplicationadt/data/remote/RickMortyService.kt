package com.example.interviewapplicationadt.data.remote

import com.example.interviewapplicationadt.model.CharacterResponse
import retrofit2.http.GET

interface RickMortyService {

    @GET("/api/character/")
    suspend fun getCharacters() : CharacterResponse
}
