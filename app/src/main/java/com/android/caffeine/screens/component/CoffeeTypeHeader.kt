package com.android.caffeine.screens.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.R
import com.android.caffeine.ui.theme.Black87
import com.android.caffeine.ui.theme.LightWhite
import com.android.caffeine.ui.theme.urbanist

@Preview(showBackground = true)
@Composable
fun CoffeeTypeHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(R.drawable.arrow_right2),
            contentDescription = null,
            tint = Black87,
            modifier = Modifier
                .size(48.dp)
                .background(LightWhite, RoundedCornerShape(100.dp))
                .padding(12.dp)

        )
        Text(
            text = "Coffee name",
            fontFamily = urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Black87,
            lineHeight = 24.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
        )

    }
}