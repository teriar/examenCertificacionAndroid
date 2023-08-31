package com.example.cl.examen_certifiacion.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Hero_Api {

    @GET("superheroes")
    suspend fun getDataList(): Response<List<Hero>>

    @GET("superheroes/{id}")
    suspend fun getDetailHero(@Path("id") id:Int): Response<List<Detail_Hero>>
}