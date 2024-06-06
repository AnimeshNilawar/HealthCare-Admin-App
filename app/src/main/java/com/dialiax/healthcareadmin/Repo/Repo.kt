package com.dialiax.healthcareadmin.Repo

import com.dialiax.healthcareadmin.Network.ApiProvider
import com.dialiax.healthcareadmin.Network.userDataResponseModelItem
import com.dialiax.healthcareadmin.Network.AddProductResponse
import retrofit2.Response

class Repo {

    suspend fun getAllUserRepo(): List<userDataResponseModelItem?> {
        return ApiProvider.apiProvider().getAllUsers()

    }

    suspend fun AddProductRepo(
        name: String,
        price: String,
        category: String,
        stack: String
    ): Response<AddProductResponse?> {
        return ApiProvider.apiProvider().addProduct(name, price, category, stack)
    }
}