package com.android.caffeine.screens.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.android.caffeine.R
import com.android.caffeine.ui.theme.Black87
import com.android.caffeine.ui.theme.sniglet

@Preview(showBackground = true)
@Composable
fun TextAndAnimatedStar(){

    val starState = rememberInfiniteTransition()

    val alpha by starState.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(easing = LinearEasing, durationMillis = 500),
            repeatMode = RepeatMode.Reverse
        ),
    )

    Box (
        modifier=Modifier.fillMaxWidth().padding(bottom = 33.dp),
        contentAlignment = Alignment.Center
    ) {
        Box {
            Text(
                text = stringResource(R.string.home_text),
                fontSize = 32.sp,
                lineHeight = 50.sp,
                letterSpacing = 0.25.sp,
                color = Black87,
                textAlign = TextAlign.Center,
                fontFamily = sniglet,
                fontWeight = FontWeight.Normal


            )
            Icon(
                modifier = Modifier.alpha(alpha).align(Alignment.TopEnd),
                painter = painterResource(R.drawable.animated_star),
                contentDescription = "Animated star",

                )
            Icon(
                modifier = Modifier.alpha(alpha).padding(top = 65.dp, start = 15.dp),
                painter = painterResource(R.drawable.animated_star),
                contentDescription = "Animated star",
            )
            Icon(
                modifier = Modifier.alpha(alpha).align(Alignment.BottomEnd),
                painter = painterResource(R.drawable.animated_star),
                contentDescription = "Animated star",
            )

        }


    }
}