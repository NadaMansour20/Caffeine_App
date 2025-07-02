package com.android.caffeine.screens.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.R
import com.android.caffeine.ui.theme.Black
import com.android.caffeine.ui.theme.Black24
import com.android.caffeine.ui.theme.White87
import com.android.caffeine.ui.theme.urbanist


@Composable
fun CoffeeButton(
    modifier: Modifier = Modifier,
    buttonTextId: Int,
    iconId: Int,
    onClick: () -> Unit = {},
) {
    Box(
        modifier.padding(top = 59.dp, bottom = 50.dp, start = 72.5.dp, end = 72.5.dp)

    ) {

        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(y = 6.dp)
                .blur(12.dp, BlurredEdgeTreatment.Unbounded)
                .background(
                    color = Black24,
                    shape = RoundedCornerShape(100.dp)
                )
        )

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .clickable { onClick() }
                .background(Black)
                .padding(vertical = 16.dp, horizontal = 32.dp),

            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = stringResource(buttonTextId),
                fontFamily = urbanist,
                fontWeight = FontWeight.Bold,
                color = White87,
                fontSize = 16.sp,
                letterSpacing = 0.25.sp
            )

            Icon(
                painter = painterResource(iconId),
                contentDescription = "button coffee",
                tint = White87
            )

        }
    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    CoffeeButton(
        modifier = Modifier,
        R.string.bring_my_coffee,
        R.drawable.button_coffee,
        onClick = {}
    )
}