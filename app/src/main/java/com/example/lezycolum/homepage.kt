package com.example.lezycolum

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomePage(navController)
        }
        composable("detail/{data}",
            arguments = listOf(navArgument("data"){
                typegit = NavType.StringType
            })
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.let {
                val gson = Gson()
                val data = it.getString("data")
                AddPage(gson.fromJson(data, Product::class.java))
            }
        }
    }
}
