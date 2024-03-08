package com.example.movieapp

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://www.omdbapi.com/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

internal val api: MovieAPI = retrofit.create(MovieAPI::class.java)