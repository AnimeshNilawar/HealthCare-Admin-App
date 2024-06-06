package com.dialiax.healthcareadmin.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dialiax.healthcareadmin.Network.AddProductResponse
import com.dialiax.healthcareadmin.Network.userDataResponseModelItem
import com.dialiax.healthcareadmin.Repo.Repo
import kotlinx.coroutines.launch
import retrofit2.Response

class viewModel : ViewModel() {

    var response = mutableStateOf<List<userDataResponseModelItem?>>(emptyList())
    val addItem = mutableStateOf<Response<AddProductResponse?>?>(null)

    init {
        getAllUser()
    }

    fun getAllUser() {
        viewModelScope.launch {
            response.value = getDetails(Repo())
        }
    }

    private suspend fun getDetails(repo: Repo): List<userDataResponseModelItem?> {
        return repo.getAllUserRepo()
    }

    fun addProduct(
        name: String,
        price: String,
        category: String,
        stack: String
    ) {
        viewModelScope.launch {
            addItem.value = Repo().AddProductRepo(
                name = name,
                price = price,
                category = category,
                stack = stack
            )
        }
    }

}