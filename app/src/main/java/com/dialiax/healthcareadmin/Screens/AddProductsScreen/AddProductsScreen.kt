package com.dialiax.healthcareadmin.Screens.AddProductsScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.LocalGroceryStore
import androidx.compose.material.icons.filled.MedicalInformation
import androidx.compose.material.icons.filled.Paid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.dialiax.healthcareadmin.Screens.utils.CustomTextField
import com.dialiax.healthcareadmin.ViewModel.viewModel


@Composable
fun AddProductScreen(viewModel: viewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        var ProductName by remember { mutableStateOf("") }
        var ProductPrice by remember { mutableStateOf("") }
        var ProductCategory by remember { mutableStateOf("") }
        var ProductStack by remember { mutableStateOf("") }



        CustomTextField(
            value = ProductName,
            onValueChange = { ProductName = it },
            label = "Product Name",
            leadingIcon = Icons.Default.MedicalInformation,
            modifier = Modifier.fillMaxWidth()
        )


        CustomTextField(
            value = ProductPrice,
            onValueChange = { ProductPrice = it },
            label = "Product Price",
            leadingIcon = Icons.Default.Paid,
            modifier = Modifier.fillMaxWidth()
        )


        CustomTextField(
            value = ProductCategory,
            onValueChange = { ProductCategory = it },
            label = "Product Category",
            leadingIcon = Icons.Default.Category,
            modifier = Modifier.fillMaxWidth()
        )


        CustomTextField(
            value = ProductStack,
            onValueChange = { ProductStack = it },
            label = "Product Stock",
            leadingIcon = Icons.Default.LocalGroceryStore,
            modifier = Modifier.fillMaxWidth()
        )
        val context = LocalContext.current

        Button(onClick = {
            if (ProductName.isNotEmpty() && ProductStack.isNotEmpty() && ProductCategory.isNotEmpty() && ProductPrice.isNotEmpty()) {
                viewModel.addProduct(
                    name = ProductName,
                    price = ProductPrice,
                    category = ProductCategory,
                    stack = ProductStack
                )
                if (viewModel.addItem.value?.code() == 200) {
                    Toast.makeText(
                        context, "task: ${viewModel.addItem.value?.body()?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                    ProductName = ""
                    ProductPrice = ""
                    ProductCategory = ""
                    ProductStack = ""

                } else {
                    Toast.makeText(
                        context, "task: ${viewModel.addItem.value?.body()?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()


            }

        }) {
            Text(text = "Add Product")

        }


    }
}