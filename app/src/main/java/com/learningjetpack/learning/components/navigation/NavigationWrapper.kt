package com.learningjetpack.learning.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.learningjetpack.learning.components.navigation.examples.DetailScreen
import com.learningjetpack.learning.components.navigation.examples.HomeScreen
import com.learningjetpack.learning.components.navigation.examples.LoginScreen


// Desde aqui se controla toda la navegacion
@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login){
        composable<Login> {
            LoginScreen(navigateToDetail = {
                navController.navigate(Home)
            })
        }

        composable<Home> {
            HomeScreen(navigationBack = {
                navController.popBackStack()
            }, navigationToDetail = { id, test ->
                // Aqui navegas con el valor
                navController.navigate(Detail(id = id, test = test))
            })
        }


        composable<Detail> { navBackStackEntry ->
            // Aqui se va a recuperar ese valor
            val detail = navBackStackEntry.toRoute<Detail>()
            DetailScreen(detail.id, detail.test){
                navController.popBackStack()
            }
        }
    }
}