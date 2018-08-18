package com.kangzayd.paxabayapi.model

import com.google.gson.annotations.SerializedName

data class ResponsePixabay(

        @field:SerializedName("hits")
        val hits: List<HitsItem?>? = null,

        @field:SerializedName("total")
        val total: Int? = null,

        @field:SerializedName("totalHits")
        val totalHits: Int? = null
)