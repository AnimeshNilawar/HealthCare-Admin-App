package com.dialiax.healthcareadmin.Network

data class userDataResponseModelItem(
    val address: String,
    val approved: Int,
    val blocked: Int,
    val date_of_creation: String,
    val email: String,
    val id: Int,
    val level: Int,
    val name: String,
    val password: String,
    val phone: String,
    val pincode: String,
    val user_id: String
)