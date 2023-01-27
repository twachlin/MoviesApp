package com.moviesApp.home.data.datasource

import com.moviesApp.commons.data.datasource.response.ApiResponse
import com.moviesApp.commons.data.datasource.response.extensions.mapToApiResponse
import com.moviesApp.home.data.datasource.model.MoviesApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesRemoteDataSource() : IMoviesDataSource {

    private val BASE_URL = ""
    private val api: MoviesApi = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(MoviesApi::class.java)

    override suspend fun getPopularMovies(apiKey: String): ApiResponse<MoviesApiModel> {
        return api.getPopularMovies(apiKey).mapToApiResponse()
    }


}