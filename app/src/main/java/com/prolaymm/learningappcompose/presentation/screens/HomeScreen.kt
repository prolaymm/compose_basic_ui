package com.prolaymm.learningappcompose.presentation.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.navArgument
import com.google.gson.reflect.TypeToken
import com.prolaymm.learningappcompose.R
import com.prolaymm.learningappcompose.presentation.compose.CategoryCard
import com.prolaymm.learningappcompose.presentation.compose.CourseCard
import com.prolaymm.learningappcompose.presentation.compose.CustomTextField
import com.prolaymm.learningappcompose.presentation.domain.CustomNavTyperParser
import com.prolaymm.learningappcompose.presentation.domain.Post
import com.prolaymm.learningappcompose.presentation.domain.data.CustomJsonReader
import com.prolaymm.learningappcompose.presentation.domain.data.NavDataSource
import com.prolaymm.learningappcompose.presentation.domain.extension.fromJson
import com.prolaymm.learningappcompose.presentation.domain.extension.toJson
import com.prolaymm.learningappcompose.presentation.domain.vos.CategoryVo
import com.prolaymm.learningappcompose.presentation.domain.vos.CourseVo
import com.prolaymm.learningappcompose.presentation.navigation.NavHelper
import com.prolaymm.learningappcompose.ui.theme.HintColor
import com.prolaymm.learningappcompose.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    var searchTextController by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    var categoryList by remember {
        mutableStateOf(emptyList<CategoryVo>())
    }
    var courseVo by remember {
        mutableStateOf(emptyList<CourseVo>())
    }

    fun onReadCourse() {
        val dataMap = CustomJsonReader<Map<String, Any?>>().onReadJsonDataFromAsset(
            context = context,
            "course.json",
            typeToken = object : TypeToken<Map<String, Any?>>() {}.type
        )
        courseVo = CustomJsonReader<List<CourseVo>>().jsonToDataObject(
            (dataMap["results"] ?: "[]").toJson(),
            typeToken = object : TypeToken<List<CourseVo>>() {}.type
        )

    }
    LaunchedEffect(key1 = Unit) {

        categoryList = CustomJsonReader<List<CategoryVo>>().onReadJsonDataFromAsset(
            context = context,
            "category.json",
            typeToken = object : TypeToken<List<CategoryVo>>() {}.type
        )
        onReadCourse()

    }

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = stringResource(id = R.string.app_name),
                            style = MaterialTheme.typography.titleLarge
                        )
                    }


                })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                //  .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            CustomTextField(
                textController = searchTextController,
                hintText = stringResource(id = R.string.search),
                visibility = true,
                trailingIcon = Icons.Outlined.Search,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            ) {
                searchTextController = it
            }
            LazyColumn(
                modifier = Modifier
                    //  .verticalScroll(rememberScrollState())
                    //  .padding(paddingValues)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize()
            ) {


                item {
                    Text(
                        text = "Category",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
                item { Spacer(modifier = Modifier.height(12.dp)) }
                item {
                    LazyRow {
                        itemsIndexed(categoryList) { index, vo ->
                            CategoryCard(
                                modifier = Modifier
                                    .padding(6.dp)
                                    .height(130.dp), categoryVo = vo
                            ) {

                            }
                        }
                    } ///lazyrow
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "Category",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                        )
                        Text(
                            text = "Category",
                            style = MaterialTheme.typography.titleSmall,
                            color = PrimaryColor,
                            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                        )
                    } ///row body
                }

                OnlineCourses(courseVo){



                    NavDataSource.addCourseVo(it)
                    navController.navigate("course/${CustomNavTyperParser<Post>().serializeAsValue(Post(it.publishedTitle?:"jdajdjajdajdj"))}")
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "Category",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                        )
                        Text(
                            text = "Category",
                            style = MaterialTheme.typography.titleSmall,
                            color = PrimaryColor,
                            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                        )
                    } ///row body
                }
                OnlineCourses(courseVo, modifier = Modifier.padding()){

                    navController.navigate("course/dadadadada")
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        Text(
                            text = "Category",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                        )
                        Text(
                            text = "Category",
                            style = MaterialTheme.typography.titleSmall,
                            color = PrimaryColor,
                            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                        )
                    } ///row body
                }

                OnlineCourses(courseVo){


                    navController.navigate("course/dadjajdjajdajd")
                }


            }
        }

    }

}


@Composable
fun TestRoute(data : String,navBackStackEntry: NavBackStackEntry?=null) {


    Text("data ${NavDataSource.courseVo}")
}

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.OnlineCourses(courseVo: List<CourseVo>,modifier: Modifier = Modifier,onClick : (CourseVo)-> Unit) {

    item {
       LazyRow(modifier){
           itemsIndexed(courseVo){ index, vo ->
               CourseCard(
                   courseVo = courseVo[index],
                   modifier = Modifier
                       .padding(vertical = 6.dp, horizontal = 6.dp)
                       .width(180.dp)
                       .height(220.dp)
                       .clickable {
                           onClick(vo)
                       }
               )

           }
       }
    }


}
