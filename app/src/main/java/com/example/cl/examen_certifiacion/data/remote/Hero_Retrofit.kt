package com.example.cl.examen_certifiacion.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Hero_Retrofit {


    companion object{
        private const val URL_BASE = "https://y-mariocanedo.vercel.app/"

        fun getRetrofitPhone(): Hero_Api {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)

                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(Hero_Api::class.java)
        }
    }
}