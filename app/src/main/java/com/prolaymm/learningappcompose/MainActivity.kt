package com.prolaymm.learningappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prolaymm.learningappcompose.presentation.screens.DetailScreen
import com.prolaymm.learningappcompose.presentation.screens.HomeScreen
import com.prolaymm.learningappcompose.presentation.screens.LoginScreen
import com.prolaymm.learningappcompose.ui.theme.LearningAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  //  LoginScreen()
                 //   HomeScreen()
                    DetailScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "body large",
            modifier = modifier,
         //   style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "body large",
            modifier = modifier,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "body medium",
            modifier = modifier,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "body small",
            modifier = modifier,
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = "body large",
            modifier = modifier,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "body large",
            modifier = modifier,
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "body large",
            modifier = modifier,
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = "body large",
            modifier = modifier,
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = "body large",
            modifier = modifier,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearningAppComposeTheme {
        Greeting("Android", modifier = Modifier.padding(10.dp))
    }
}