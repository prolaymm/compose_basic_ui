package com.prolaymm.learningappcompose.presentation.compose

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(modifier : Modifier = Modifier,name : String,onClick :() -> Unit) {

    Button(
        modifier=modifier.height(46.dp),
        shape = RoundedCornerShape(8.dp),
        onClick = onClick) {
        Text(name)
    }
}