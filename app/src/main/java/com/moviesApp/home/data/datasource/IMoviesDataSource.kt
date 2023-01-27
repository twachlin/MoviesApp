package com.moviesApp.home.data.datasource

import com.moviesApp.commons.data.datasource.response.ApiResponse
import com.moviesApp.home.data.datasource.model.MoviesApiModel

interface IMoviesDataSource {

    suspend fun getPopularMovies(apiKey: String): ApiResponse<MoviesApiModel>
}