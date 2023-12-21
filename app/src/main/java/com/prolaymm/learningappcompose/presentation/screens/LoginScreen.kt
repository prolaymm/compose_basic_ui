package com.prolaymm.learningappcompose.presentation.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prolaymm.learningappcompose.R
import com.prolaymm.learningappcompose.presentation.compose.CustomButton
import com.prolaymm.learningappcompose.presentation.compose.CustomTextField
import com.prolaymm.learningappcompose.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    var emailController by remember {
        mutableStateOf("")
    }
    var passwordController by remember {
        mutableStateOf("")
    }
    var isErrorEmail by remember { mutableStateOf(false) }
    var isErrorPassword by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                ),
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        color = PrimaryColor,
                        style = MaterialTheme.typography.titleLarge
                    )
                } ///title
        ) ///CenterAlignedTopAppBar
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {

            Image(painter = painterResource(id = R.drawable.auth), contentScale = ContentScale.Crop,contentDescription = "", modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
                .height(200.dp).clip( shape = RoundedCornerShape(8.dp)))
            Text(text = stringResource(id = R.string.sign_in), style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(10.dp))
            CustomTextField(textController=emailController,
                keyboardType = KeyboardType.Email,
                validate = {
                    isErrorEmail = it.isEmpty()
                },
                isError = isErrorEmail,
                hintText = stringResource(id = R.string.email), modifier = Modifier.fillMaxWidth()){
                emailController = it
            }

            CustomTextField(textController=passwordController,
                hintText = stringResource(id = R.string.password),
                keyboardType = KeyboardType.Password,
                visibility = false,
                validate = {
                    isErrorPassword = it.isEmpty() || it.length <6
                },
                isError = isErrorPassword,
                trailingIcon = Icons.Outlined.Lock,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 30.dp)){
                passwordController = it
            }
            CustomButton(name = "Login", modifier = Modifier.fillMaxWidth()){

                if(emailController.isEmpty() || passwordController.length<6) {
                    Toast.makeText(context,"Erorr on text field",Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context,"Success ",Toast.LENGTH_SHORT).show()
                }
            }



        } ///column content
    } //scaffold content
}