package com.prolaymm.learningappcompose.presentation.navigation

import com.prolaymm.learningappcompose.presentation.domain.vos.CourseVo

sealed class  NavHelper(val route : String) {

    data object  Login : NavHelper("login")
    data object  Home : NavHelper("home")
    data object  Detail : NavHelper("course")
}