package dev.pegasus.paging3.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Author: SOHAIB AHMED
 * @Date: 10,July,2023
 * @Accounts
 *      -> https://github.com/epegasus
 *      -> https://stackoverflow.com/users/20440272/sohaib-ahmed
 */
object RetrofitInstance {

    private var retrofit: Retrofit? = null

    private fun getInstance(): Retrofit {
        retrofit?.let {
            return it
        } ?: run {
            retrofit = Retrofit.Builder()
                .baseUrl("https://quotable.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit!!
        }
    }

    fun getClientApi(): ClientApi {
        return getInstance().create(ClientApi::class.java)
    }

}