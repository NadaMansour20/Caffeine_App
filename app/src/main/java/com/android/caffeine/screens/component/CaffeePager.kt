package com.android.caffeine.screens.component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
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

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val pagerState = rememberPagerState(pageCount = { 4 })
    val imgWidth=199.dp
    val imgHieght=244.dp
    val iconSize=66.dp
    val contentPadding = (screenWidth - imgWidth)


    HorizontalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(imgWidth),
        contentPadding = PaddingValues(horizontal = contentPadding),
        modifier = modifier.fillMaxWidth()
        ) {page->

        val centerWidth = animateDpAsState(
            targetValue = if (page == pagerState.currentPage) imgWidth else imgWidth * 0.7f
        ).value

        val centerHieght=animateDpAsState(
            targetValue = if (page == pagerState.currentPage) imgHieght else imgHieght * 0.7f
        ).value
        val centerIconSize=animateDpAsState(
            targetValue = if (page == pagerState.currentPage) iconSize else iconSize * 0.7f
        ).value

       Column(
           modifier = Modifier.padding(top = 56.dp),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.spacedBy(16.dp),
           ) {
           Box(
           ) {
               Image(
                   painter = painterResource(caffeeList[page].caffeeImg),
                   contentDescription = "caffeeImg",
                   modifier = Modifier.size(centerWidth , centerHieght)
               )
               Image(
                   painter = painterResource(R.drawable.coffee_logo_larg),
                   contentDescription = "caffee logo",
                   modifier = Modifier.padding(top = 116.dp, start = 67.dp).size(centerIconSize).clip(
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


