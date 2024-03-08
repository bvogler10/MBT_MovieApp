package com.example.movieapp

import android.text.Editable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface MovieAPI {
    @GET("/?apikey=b57f373c&")
    fun getMovie(
        @Query("t")
        title: Editable
    ): Call<MovieResponse>
}