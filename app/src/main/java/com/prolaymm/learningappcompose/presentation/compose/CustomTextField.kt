package com.prolaymm.learningappcompose.presentation.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prolaymm.learningappcompose.R
import com.prolaymm.learningappcompose.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(modifier: Modifier = Modifier,isError : Boolean = false,textController : String,keyboardType: KeyboardType = KeyboardType.Text,hintText : String,visibility:Boolean = true,trailingIcon : ImageVector? =null,validate : (String) -> Unit = {}, onValueChange : (String) ->  Unit) {

    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        value = textController,
        singleLine = true,
        keyboardOptions= KeyboardOptions(keyboardType = keyboardType),
        interactionSource = interactionSource,
        cursorBrush = SolidColor(PrimaryColor),
        textStyle = TextStyle(fontSize = 14.sp),
        modifier = modifier.height(50.dp),
        visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardActions = KeyboardActions{
                validate(textController)
        },
        onValueChange = onValueChange
    ) { innerTextField ->
        OutlinedTextFieldDefaults.DecorationBox(
            value = textController,
            innerTextField = innerTextField,
            enabled = true,
            isError = isError,
            singleLine = true,
            interactionSource = interactionSource,
            visualTransformation = VisualTransformation.None,

            placeholder = {
                Text(
                    text = hintText, fontSize = 12.sp
                )
            },
            trailingIcon = {
                trailingIcon?.let {
                    Icon(
                        trailingIcon,
                        contentDescription = "",
                        modifier = Modifier
                            .size(25.dp)
                        /* .clickable {
                             visibility.value = !visibility.value
                         }*/,
                         tint = if (visibility) PrimaryColor else Color.Gray
                    )
                }

            },
            container = {
                OutlinedTextFieldDefaults.ContainerBox(
                    enabled = true,
                    isError = false,
                    interactionSource = interactionSource,
                    colors = OutlinedTextFieldDefaults.colors(),
                    shape = RoundedCornerShape(10.dp),
                    focusedBorderThickness = 0.8.dp,
                    unfocusedBorderThickness = 0.8.dp
                )
            }
        )
    }


}