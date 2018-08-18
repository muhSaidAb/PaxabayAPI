package com.kangzayd.paxabayapi.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCall {
    fun retrofit():Retrofit{
        return Retrofit.Builder()
                .baseUrl("https://pixabay.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun create() = retrofit().create(ApiInterfaces::class.java)
}