package com.example.votointeligente

import com.google.gson.*

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {

    var BASE_URL:String="https://www.christianonline.cl/voto_rest/"

    val getClient: ApiInterface //pendiente
        get() {
            val gson = GsonBuilder().setLenient().create()
            //val gson podrá ser usada para guardar un formato json
            val interceptor= HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)//mostrará toda la información de las llaves
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create(gson)).build()

            return retrofit.create(ApiInterface::class.java)


        }



}