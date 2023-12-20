package com.prolaymm.learningappcompose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prolaymm.learningappcompose.presentation.screens.DetailScreen
import com.prolaymm.learningappcompose.presentation.screens.HomeScreen
import com.prolaymm.learningappcompose.presentation.screens.LoginScreen

@Composable

fun ComposeApp() {


    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavHelper.Login.route){

        composable(NavHelper.Login.route) {

            LoginScreen()
        }
        composable(NavHelper.Login.route) {

            HomeScreen()
        }
        composable(NavHelper.Login.route) {

            DetailScreen()
        }
    }

}