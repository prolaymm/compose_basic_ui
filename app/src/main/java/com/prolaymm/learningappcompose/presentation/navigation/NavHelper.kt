package com.prolaymm.learningappcompose.presentation.navigation

sealed class  NavHelper(val route : String) {

    data object  Login : NavHelper("home")
    data object  Home : NavHelper("home")
    data object  Detail : NavHelper("home/{courseVo}")
}