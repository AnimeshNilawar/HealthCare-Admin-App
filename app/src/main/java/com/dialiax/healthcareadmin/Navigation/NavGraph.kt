package com.dialiax.healthcareadmin.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.dialiax.healthcareadmin.Screens.HomeScreen.HomeScreen
import com.dialiax.healthcareadmin.Screens.detailsScreen.UserDetailsCard
import com.dialiax.healthcareadmin.ViewModel.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.dialiax.healthcareadmin.Screens.AddProductsScreen.AddProductScreen

@Composable
fun NavGraph(ViewModel: viewModel, navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Routes.Home) {
        composable<Routes.Home> {
            HomeScreen(
                viewModel = ViewModel,
                navHostController = navHostController
            )
        }
        composable<Routes.UserDetailsData> {backStackEntry ->
            val Deta : Routes.UserDetailsData = backStackEntry.toRoute()
            UserDetailsCard(data = Deta )

        }
        composable<Routes.AddProduct> { AddProductScreen(viewModel = ViewModel) }

    }

}
