package com.android.caffeine.screens.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.R
import com.android.caffeine.ui.theme.Black
import com.android.caffeine.ui.theme.urbanist


data class caffeeData(
    val caffeeImg:Int,
    val caffeeName:String,
)
val caffeeList= listOf(
    caffeeData(R.drawable.espresso,"Espresso"),
    caffeeData(R.drawable.latte,"Latte"),
    caffeeData(R.drawable.macchiato,"Macchiato"),
    caffeeData(R.drawable.black,"Black")

)


@Preview(showBackground = true)
@Composable
fun CaffeePager(modifier: Modifier=Modifier){

    val pagerState = rememberPagerState(pageCount = { 4 })

    HorizontalPager(
        state = pagerState,
    ) {page->
       Column(
           modifier = modifier.fillMaxWidth(),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center
       ) {
           Box(
               modifier = Modifier.padding(bottom = 16.dp, top = 56.dp)
           ) {
               Image(
                   painter = painterResource(caffeeList[page].caffeeImg),
                   contentDescription = "caffeeImg",
                   modifier = Modifier.size(width =199.dp , height = 244.dp)
               )
               Image(
                   painter = painterResource(R.drawable.cafee_logo),
                   contentDescription = "caffee logo",
                   modifier = Modifier.padding(top = 116.dp, start = 67.dp).size(66.dp).clip(
                       RoundedCornerShape(100.dp)
                   )
               )
           }
           Text(
               text = caffeeList[page].caffeeName,
               fontFamily = urbanist,
               fontWeight = FontWeight.Bold,
               fontSize = 32.sp,
               letterSpacing = 0.25.sp,
               lineHeight = 32.sp,
               textAlign = TextAlign.Center,
               color = Black

           )
       }
    }

}


