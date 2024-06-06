package com.dialiax.healthcareadmin.Screens.HomeScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.dialiax.healthcareadmin.ViewModel.viewModel


@Composable
fun AllCardLazyColumn(ViewModel: viewModel = viewModel(), navHostController: NavHostController) {
    val response = ViewModel.response.value

    LazyColumn(
        modifier = Modifier
            .padding()
            .fillMaxSize()
    ) {
        items(response!!) { userData ->
            if (userData != null) {
                EachCard(
                    userName = userData.name,
                    userId = userData.id,
                    userEmail = userData.email,
                    userPhone = userData.phone,
                    userAddress = userData.address,
                    userPinCode = userData.pincode,
                    userDate_of_account_creation = userData.date_of_creation,
                    userLevel = userData.level,
                    navHostController = navHostController
                )
            }

        }

    }
}