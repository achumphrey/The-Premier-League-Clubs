package com.example.thepremierleagueclubs.network

import com.example.thepremierleagueclubs.common.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClubsRetrofitInstance {

    val retrofitInstance: Retrofit

        get() {

            val loggingInterceptor = HttpLoggingInterceptor()
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor((loggingInterceptor))
                .build()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return   Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }
}