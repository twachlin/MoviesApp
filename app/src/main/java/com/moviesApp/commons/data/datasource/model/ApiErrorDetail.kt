package com.moviesApp.commons.data.datasource.model

import com.google.gson.annotations.SerializedName

data class ApiErrorDetail(
    @SerializedName("status_message")
    val statusMessage: String,
    @SerializedName("status_code")
    val statusCode: Int
)