package com.dialiax.healthcareadmin.Navigation

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

class Routes {
    @Serializable
    object Home

    @Serializable
    data class UserDetailsData(
        val userId: Int,
        val userName: String,
        val userEmail: String,
        val userPhone: String,
        val userAddress: String,
        val userPinCode: String,
        val userDate_of_account_creation: String,
        val userLevel: Int
    )

    @Serializable
    object AddProduct
}