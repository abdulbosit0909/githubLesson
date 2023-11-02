package com.example.lezycolum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}
@Composable
fun HomePage(
    navController: NavController
) {
    val data = mutableListOf(
        Product(
            R.drawable.ic_launcher_foreground,
            "android fr",
            200.0
        ),
        Product(
            R.drawable.ic_launcher_background,
            "android bg",
            300.0git
        )
    )
    ProductList(data, navController)
}


@Composable
fun ItemProduct(
    product: Product,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
            .clickable {
                val gson = Gson()
                navController.navigate("detail/${gson.toJson(product)}")
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = product.img),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 200.dp, height = 150.dp)
                    .align(Alignment.CenterStart),
                contentScale = ContentScale.Crop
            )
            Text(
                text = product.name,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.TopEnd)
            )
            Text(
                text = product.price.toString(),
                fontSize = 18.sp,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
            )
        }
    }
}

@Composable
fun ProductList(
    list: MutableList<Product>,
    navController: NavController

) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(list) {
            ItemProduct(product = it, navController)
        }
    }
}

data class Product(
    val img: Int,
    val name: String,
    val price: Double
)
