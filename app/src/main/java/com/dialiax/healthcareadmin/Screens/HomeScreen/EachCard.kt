package com.dialiax.healthcareadmin.Screens.HomeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dialiax.healthcareadmin.Navigation.Routes

//onClickUserInfo: () -> Unit
@Composable
fun EachCard(
    userName: String,
    userId: Int,
    userEmail: String,
//    onClickApprove: () -> Unit,
    //onClickUserInfo: () -> Unit,
    userPhone: String,
    userAddress: String,
    userPinCode: String,
    userDate_of_account_creation: String,
    userLevel: Int,
    navHostController: NavHostController
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),

                ) {
                Text(
                    text = userName,
                    style = MaterialTheme.typography.titleMedium,

                    )
                Text(
                    text = "ID: $userId",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
                Text(
                    text = "Email: $userEmail",
                    style = MaterialTheme.typography.bodyMedium,
                )


                Text(
                    text = "PinCode: $userPinCode",
                    style = MaterialTheme.typography.bodyMedium,
                )

                Text(
                    text = "Level: $userLevel",
                    style = MaterialTheme.typography.bodyMedium,
                )

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text(text = "Approve", fontSize = 14.sp)
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {
                        navHostController.navigate(
                            Routes.UserDetailsData(
                                userName = userName,
                                userEmail = userEmail,
                                userId = userId,
                                userLevel = userLevel,
                                userPhone = userPhone,
                                userAddress = userAddress,
                                userDate_of_account_creation = userDate_of_account_creation,
                                userPinCode = userPinCode
                            )
                        )
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor =
                        MaterialTheme.colorScheme.secondary
                    )
                )
                {
                    Text(text = "See All Details", fontSize = 14.sp)
                }

            }
        }
    }
}