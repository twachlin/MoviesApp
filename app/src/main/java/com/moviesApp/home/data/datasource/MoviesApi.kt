package com.moviesApp.home.data.datasource

import com.moviesApp.home.data.datasource.model.MoviesApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("/movie/popular")
    fun getPopularMovies(@Query("apiKey") apiKey: String): Response<MoviesApiModel>
}