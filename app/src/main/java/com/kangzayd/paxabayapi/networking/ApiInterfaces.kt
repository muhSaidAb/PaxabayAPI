package com.kangzayd.paxabayapi.networking

import com.kangzayd.paxabayapi.model.ResponsePixabay
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterfaces {

    @GET("api/")
    fun getData(@Query("key") key: String,
                @Query("q") q: String,
                @Query("image_type") image_type: String): Call<ResponsePixabay>
}