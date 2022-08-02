package com.example.davaleba_13

import com.example.davaleba_13.Model.Product
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object RetrofitProduct {

    private const val BASE_URL = "https://run.mocky.io/"
    val retrofitBuilder by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create()).build()
    }

    fun getProducts()= retrofitBuilder.create(InfoGetter::class.java)

}

interface InfoGetter{

    @GET("v3/3588163c-a9c8-488c-af9a-534b392e7128")
    suspend fun infoGet():Response<Product>
}