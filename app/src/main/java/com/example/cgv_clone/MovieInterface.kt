package com.example.cgv_clone

import com.example.cgv_clone.data.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {

    @GET("movie/now_playing")
    fun getNowPlaying(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int,
        @Query("region") region: String
    ): Call<MovieResponse>

}