package com.prolaymm.learningappcompose.presentation.screens


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prolaymm.learningappcompose.R
import com.prolaymm.learningappcompose.presentation.compose.CustomButton
import com.prolaymm.learningappcompose.presentation.compose.CustomNetworkImage
import com.prolaymm.learningappcompose.presentation.domain.data.NavDataSource
import com.prolaymm.learningappcompose.presentation.domain.vos.CourseVo
import com.prolaymm.learningappcompose.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun DetailScreen(navController: NavController,) {

    val courseVo = NavDataSource.courseVo

    Scaffold(
        topBar = {

            CenterAlignedTopAppBar(title = {
                Text(stringResource(id = R.string.detail,), color = PrimaryColor)
            })
        },
        bottomBar = {
            
            CustomButton(name = "Enroll Now", modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {

            }
        }
    ) {
          paddingValues ->

        Column(modifier = Modifier.padding(paddingValues).verticalScroll(rememberScrollState())) {
            CustomNetworkImage(imageUrl = courseVo?.image480x270?:"", modifier = Modifier
                .height(220.dp)
                .padding(16.dp)
                .clip(shape = RoundedCornerShape(12.dp))
                .fillMaxWidth(),)
          Column(modifier = Modifier.padding(horizontal = 16.dp)) {

              Text(courseVo?.publishedTitle?:"", style = MaterialTheme.typography.titleMedium)
              Text(courseVo?.headline?:"", style = MaterialTheme.typography.bodySmall)
              Text("${courseVo?.id} MMK", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(vertical = 16.dp))

              Text("Course Hightlight", style = MaterialTheme.typography.titleMedium)

              RowWithPrefixIcon(icon = painterResource(id = R.drawable.clock), title ="Recent update" )
            //  RowWithPrefixIcon(icon = painterResource(id = R.drawable.webcam), title ="Bdauduajdjajdja jjjdj jdjdj djjddjjdj" )

          }

        }

    }
}

@Composable
fun RowWithPrefixIcon(modifier: Modifier= Modifier,icon: Painter,title : String) {

    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically

    ){
        Icon( icon,contentDescription = "",
            Modifier
                .size(26.dp)
                .padding(end = 6.dp))
        Text(title, style = MaterialTheme.typography.bodySmall)
    }
}