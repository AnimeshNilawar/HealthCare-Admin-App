package com.dialiax.healthcareadmin.Screens.HomeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.dialiax.healthcareadmin.Navigation.Routes
import com.dialiax.healthcareadmin.Screens.shimmer.ShimmerEffect
import com.dialiax.healthcareadmin.ViewModel.viewModel

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScreen(navHostController: NavHostController, viewModel: viewModel) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "Admin",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }

                },
                actions = {
                    IconButton(onClick = { navHostController.navigate(Routes.AddProduct) }) {
                        Icon(Icons.Filled.Add, contentDescription = "Add")
                    }
                }
            )
        }

    ) { innerpadding ->
        Column(
            modifier = Modifier
                .padding(innerpadding)
                .fillMaxSize()
        ) {
            if (viewModel.response.value.isEmpty()){
                Column {
                    repeat(6){
                        ShimmerEffect()
                    }
                }
            } else{
                Column {
                    AllCardLazyColumn(ViewModel = viewModel, navHostController = navHostController)
                }
            }
        }

    }

}