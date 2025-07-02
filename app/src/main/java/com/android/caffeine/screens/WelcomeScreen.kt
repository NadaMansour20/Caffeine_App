package com.android.caffeine.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.caffeine.R
import com.android.caffeine.screens.component.CaffeePager
import com.android.caffeine.screens.component.CoffeeButton
import com.android.caffeine.screens.component.Header
import com.android.caffeine.ui.theme.Black80
import com.android.caffeine.ui.theme.DarkGray
import com.android.caffeine.ui.theme.Gray
import com.android.caffeine.ui.theme.urbanist


//@Preview(showSystemUi = true)
@Composable
fun WelcomeScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {

        Header()
        Column(
            modifier = Modifier.weight(1f).padding(top = 16.dp, start = 16.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = stringResource(R.string.good_morning),
                fontSize = 36.sp,
                fontFamily = urbanist,
                fontWeight = FontWeight.Bold,
                color = Gray,
                letterSpacing = 0.25.sp,
                lineHeight = 16.sp

            )
            Text(
                text = stringResource(R.string.hamsa),
                fontSize = 36.sp,
                fontFamily = urbanist,
                fontWeight = FontWeight.Bold,
                color = DarkGray,
                letterSpacing = 0.25.sp,
                lineHeight = 16.sp


            )
            Text(
                text = stringResource(R.string.what_would_you_like_to_drink_today),
                fontSize = 16.sp,
                fontFamily = urbanist,
                fontWeight = FontWeight.Bold,
                color = Black80,
                letterSpacing = 0.25.sp,
                lineHeight = 16.sp


            )
        }
        CaffeePager(modifier = Modifier.weight(1f).align(Alignment.CenterHorizontally))
        CoffeeButton(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            buttonTextId = R.string.Continue,
            iconId = R.drawable.arrow_right,
        ){
            navController.navigate("")
        }
    }
}

