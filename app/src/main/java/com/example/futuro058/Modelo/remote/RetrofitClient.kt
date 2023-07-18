package com.example.futuro058.Modelo.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {


 companion object {
     private const val BASE_URL = "https://caso-invest-center-mariocanedo.vercel.app/"
     // parantestear
  lateinit var retrofitInstance : Retrofit
     fun retrofitInstance():CentroFuturoApi{

         val retrofit = Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()

         return retrofit.create(CentroFuturoApi::class.java)

     }

 }
}