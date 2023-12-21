package com.prolaymm.learningappcompose.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.prolaymm.learningappcompose.presentation.domain.CustomNavTyperParser
import com.prolaymm.learningappcompose.presentation.domain.Post
import com.prolaymm.learningappcompose.presentation.domain.vos.CourseVo
import com.prolaymm.learningappcompose.presentation.screens.DetailScreen
import com.prolaymm.learningappcompose.presentation.screens.HomeScreen
import com.prolaymm.learningappcompose.presentation.screens.LoginScreen
import com.prolaymm.learningappcompose.presentation.screens.TestRoute

@Composable

fun ComposeApp() {


    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavHelper.Home.route){

        composable(NavHelper.Login.route) {

            LoginScreen(navController)
        }
        composable(NavHelper.Home.route) {

            HomeScreen(navController)
        }
        
        composable("course/{courseVo}",arguments= listOf(

            navArgument("courseVo") {

                type = CustomNavTyperParser<Post>()
            }
        )){backStackEntry ->
           val data =  backStackEntry.arguments?.getString("courseVo")

            Log.d("arjun","courseVo $data ")

            DetailScreen(navController)
        }
      /*  composable("course/{courseVo}", arguments = listOf(

            navArgument("courseVo") {
                type = NavType.StringType
            }
        )) {
            val courseVo = it.arguments!!.getString("courseVo")
            DetailScreen(navController=navController)

        }*/
    }

}