package com.android.caffeine.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.R
import com.android.caffeine.screens.component.CoffeeButton
import com.android.caffeine.screens.component.SkipHeader
import com.android.caffeine.ui.theme.Black80
import com.android.caffeine.ui.theme.LightBrown
import com.android.caffeine.ui.theme.urbanist

@Preview(showSystemUi = true)
@Composable
fun SnackDetails() {

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {

        SkipHeader()

        Row(
            modifier = Modifier.padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)

        ) {
            Icon(
                painter = painterResource(R.drawable.coffee_beans),
                contentDescription = null,
                tint = LightBrown,
            )
            Text(
                text = stringResource(R.string.more_espresso_less_depresso),
                fontFamily = urbanist,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                color = LightBrown,
                lineHeight = 20.sp,
                letterSpacing = 0.25.sp,
                modifier = Modifier.weight(1f),
            )
            Icon(
                painter = painterResource(R.drawable.coffee_beans),
                contentDescription = null,
                tint = LightBrown,

                )
        }

        Column(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
//        Image(
//
//        )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.bon_app_tit),
                    fontFamily = urbanist,
                    fontWeight = FontWeight.Normal,
                    fontSize = 22.sp,
                    color = Black80,
                    lineHeight = 22.sp,
                    letterSpacing = 0.25.sp,
                )
                Icon(
                    painter = painterResource(R.drawable.magic),
                    contentDescription = null,
                    tint = Black80,
                )
            }
        }

        CoffeeButton(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            buttonTextId = R.string.thank_youuu,
            iconId = R.drawable.arrow_right,
            onClick = {}
        )


    }
}