package com.example.thepremierleagueclubs.network.detailsnetwork

import com.example.thepremierleagueclubs.common.clubcommon.ClubConstants
import com.example.thepremierleagueclubs.common.clubdetailcommon.ClubDetailsConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClubDetailsRetrofitInstance {

    val retrofitInstance: Retrofit

        get() {

            val loggingInterceptor = HttpLoggingInterceptor()
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor((loggingInterceptor))
                .build()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            return   Retrofit.Builder()
                .baseUrl(ClubDetailsConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }
}