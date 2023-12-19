package com.prolaymm.learningappcompose.presentation.compose

import android.widget.RatingBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.prolaymm.learningappcompose.presentation.domain.vos.CourseVo
import com.prolaymm.learningappcompose.ui.theme.HintColor

@Composable
fun  CourseCard(modifier: Modifier = Modifier,courseVo: CourseVo) {

    Card(

        modifier = modifier.shadow(
            elevation = 8.dp,
            spotColor = HintColor,
            shape = RoundedCornerShape(8.dp)
        ),
                colors = CardDefaults.cardColors(
                containerColor = Color.White,
    ),

    ){

       Column(modifier =Modifier.fillMaxHeight()) {
           CustomNetworkImage(imageUrl = courseVo.image480x270?:"", modifier = Modifier.height(120.dp),)
               Spacer(modifier = Modifier.weight(1f))
        Column(modifier=Modifier.padding(6.dp)) {
            Text(text = courseVo.publishedTitle?:"", maxLines = 1, style = MaterialTheme.typography.labelSmall, overflow = TextOverflow.Ellipsis)
            Text(text = courseVo.headline?:"", maxLines = 2, style = MaterialTheme.typography.titleMedium, overflow = TextOverflow.Ellipsis,)

            Text("${courseVo.id} MMK", color = Color.Red, style = MaterialTheme.typography.titleMedium, textAlign = TextAlign.Center)
        }
       }
    }
}
