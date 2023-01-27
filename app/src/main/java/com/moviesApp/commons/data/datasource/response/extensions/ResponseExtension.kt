package com.moviesApp.commons.data.datasource.response.extensions

import com.moviesApp.commons.data.datasource.model.ApiErrorDetail
import com.moviesApp.commons.data.datasource.response.ApiResponse
import com.moviesApp.commons.data.datasource.response.BusinessErrorApiResponse
import com.moviesApp.commons.data.datasource.response.CodeErrorConstants.NOT_FOUND
import com.moviesApp.commons.data.datasource.response.CodeErrorConstants.UNAUTHORIZED
import com.moviesApp.commons.data.datasource.response.EmptyApiResponse
import com.moviesApp.commons.data.datasource.response.NetworkErrorApiResponse
import com.moviesApp.commons.data.datasource.response.SuccessApiResponse
import okhttp3.Request
import okhttp3.ResponseBody
import retrofit2.Response

/**
 * Convert a Retrofit response into an ApiResponse to allow states management
 */
fun <Data> Response<Data>.mapToApiResponse(): ApiResponse<Data> {
    return if (this.isSuccessful) {
        when (this.code()) {
            200 -> {
                this.body()?.let { data ->
                    SuccessApiResponse(data)
                } ?: run {
                    EmptyApiResponse
                }
            }
            else -> {
                EmptyApiResponse
            }
        }
    } else {
        onFailure(code(), raw().networkResponse()?.request(), errorBody())
    }
}

private fun <Data> onFailure(
    code: Int,
    request: Request?,
    errorBody: ResponseBody?
    ): ApiResponse<Data> {
    // [ResponseBody] os a closable, can be consumed only once
    val message = errorBody?.string() ?: "Unknown error"

    return if (code == UNAUTHORIZED || code == NOT_FOUND) {
        BusinessErrorApiResponse(apiErrorDetail = ApiErrorDetail(message, code))
    } else {
        NetworkErrorApiResponse()
    }
}