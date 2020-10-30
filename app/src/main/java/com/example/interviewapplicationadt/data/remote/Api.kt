package com.example.interviewapplicationadt.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Api {
    private const val BASE_URL = "https://rickandmortyapi.com/"

    private fun loggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private fun setupClient() = OkHttpClient.Builder().addInterceptor(loggingInterceptor()).build()

    private fun initRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(setupClient())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun getRickMortyService() = initRetrofit().create(RickMortyService::class.java)
}