package com.moviesApp.home.data.datasource.model

import com.google.gson.annotations.SerializedName

data class MoviesApiModel(
    val page: Int,
    @SerializedName("result")
    val movies: List<MoviesListApiModel>,
    @SerializedName("total_result")
    val totalResult: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)

data class MoviesListApiModel(
    @SerializedName("poster_path")
    val posterPath: String,
    val adult: Boolean,
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("original_title")
    val originalTitle: String
)