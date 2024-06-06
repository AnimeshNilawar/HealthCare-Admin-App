package com.dialiax.healthcareadmin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.dialiax.healthcareadmin.ViewModel.viewModel
import com.dialiax.healthcareadmin.Navigation.NavGraph
import com.dialiax.healthcareadmin.ui.theme.HealthCareAdminTheme
import com.geniusapk.pharmastockadmin.ui.theme.PharmaStockAdminTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val ViewModel : viewModel by viewModels()
        setContent {
            PharmaStockAdminTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navHostController = rememberNavController()

                    NavGraph( navHostController = navHostController, ViewModel = ViewModel)





                }
            }
        }
    }
}
