package com.example.apiprojectrafi.api

import com.example.apiprojectrafi.ResponseMorty
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getMorty () : Call<ResponseMorty>
}