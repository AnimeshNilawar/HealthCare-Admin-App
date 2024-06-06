package com.dialiax.healthcareadmin.Screens.detailsScreen

import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dialiax.healthcareadmin.Navigation.Routes


@Composable
fun UserDetailsCard(
    data :Routes.UserDetailsData,
) {
    Column(modifier = Modifier.fillMaxSize().padding(), horizontalAlignment = Alignment.CenterHorizontally , verticalArrangement = Arrangement.Center) {

        Card(
            shape = RoundedCornerShape(8.dp),

            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(text = "Name: ${data.userName}", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(text = "Email: ${data.userEmail}", fontSize = 16.sp)
                Text(text = "Phone: ${data.userPhone}", fontSize = 16.sp)
                Text(text = "Address: ${data.userAddress}", fontSize = 16.sp)
                Text(text = "PinCode: ${data.userPinCode}", fontSize = 16.sp)
                Text(text = "Account Created On: ${data.userDate_of_account_creation}", fontSize = 16.sp)

                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Approve")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Reject")

                    }
                }
            }
        }

    }

}