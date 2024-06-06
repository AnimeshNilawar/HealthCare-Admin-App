package com.dialiax.healthcareadmin.Network

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("getAllUsers")
    suspend fun getAllUsers(): List<userDataResponseModelItem?>

    @FormUrlEncoded
    @POST("addProduct")
    suspend fun addProduct(
        @Field("name") name: String,
        @Field("price") price: String,
        @Field("category") category: String,
        @Field("stack") stack: String,
    ): Response<AddProductResponse?>

}