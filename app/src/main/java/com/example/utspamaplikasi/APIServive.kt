package com.example.utspamaplikasi

import retrofit2.Call
import retrofit2.http.GET

interface APIServive {

    @GET("users")
    fun getUser(): Call<ArrayList<ResponseModel>>
}