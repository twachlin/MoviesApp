package com.moviesApp.commons.data.datasource.response

import com.moviesApp.commons.data.datasource.model.ApiErrorDetail

/**
 * This is a common class used by API responses
 */
sealed class ApiResponse<out Data>

data class SuccessApiResponse<out Data>(val body: Data) : ApiResponse<Data>()

object EmptyApiResponse : ApiResponse<Nothing>()

data class BusinessErrorApiResponse(val apiErrorDetail: ApiErrorDetail) : ApiResponse<Nothing>()

data class NetworkErrorApiResponse(val errorCode: Int = -1, val errorMessage: String? = "") :
    ApiResponse<Nothing>()