package com.example.interviewapplicationadt.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterResponse(
    val info: Info,
    val results: List<Character> = listOf()
)