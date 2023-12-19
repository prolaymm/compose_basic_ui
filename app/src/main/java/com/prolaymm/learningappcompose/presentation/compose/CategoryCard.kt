package com.prolaymm.learningappcompose.presentation.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.Coil
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.prolaymm.learningappcompose.R
import com.prolaymm.learningappcompose.presentation.domain.vos.CategoryVo
import com.prolaymm.learningappcompose.ui.theme.HintColor



@Composable
fun CategoryCard(modifier: Modifier =Modifier, categoryVo : CategoryVo, onClick: ()-> Unit = {} ) {

    Card(
        modifier = modifier
            .shadow(
                shape = RoundedCornerShape(8.dp),
                spotColor = HintColor,
                elevation = 4.dp
            )
            .width(160.dp)
            .height(160.dp),


        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
       shape = RoundedCornerShape(12.dp)
    ) {

       Column(
           horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier.padding(bottom=6.dp),){

           SubcomposeAsyncImage(
               ImageRequest.Builder(LocalContext.current)
                   .data(categoryVo.image)
                   .decoderFactory(GifDecoder.Factory())
                   .build(),

               contentDescription = "Translated description of what the image contains",
               contentScale = ContentScale.Crop,
               error = {
                     Icon(Icons.Rounded.Warning,"", tint = HintColor)
               },
               loading = {
                 Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                     CircularProgressIndicator(modifier = Modifier
                         .progressSemantics()
                         .size(32.dp),)

                 }
               },

               modifier= Modifier
                   .weight(1f)
                   .clip(shape = RoundedCornerShape(12.dp))
                   .fillMaxSize()
           )

           Spacer(modifier = Modifier.height(8.dp))
           Text(categoryVo.name?:"", fontSize = 16.sp, fontWeight = FontWeight.W500)
       }
    }
}


