package dev.pegasus.paging3.retrofit

import dev.pegasus.paging3.models.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author: SOHAIB AHMED
 * @Date: 10,July,2023
 * @Accounts
 *      -> https://github.com/epegasus
 *      -> https://stackoverflow.com/users/20440272/sohaib-ahmed
 */

interface ClientApi {

    @GET("quotes")
    suspend fun getQuotes(@Query("page") page: Int): ApiResponse

}