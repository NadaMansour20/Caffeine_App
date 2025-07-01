package com.android.caffeine.screens.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.caffeine.R


@Preview(showBackground = true)
@Composable
fun AnimatedGhost(modifier: Modifier = Modifier) {
    val ghostState = rememberInfiniteTransition()

    val offsetY by ghostState.animateFloat(
        initialValue = 0f,
        targetValue = -30f,
        animationSpec = infiniteRepeatable(
            animation = tween(easing = LinearEasing, durationMillis = 1200),
            repeatMode = RepeatMode.Reverse
        ),
    )

    Image(
        painter = painterResource(R.drawable.coffee_ghost),
        contentDescription = "Coffee_ghost",
        contentScale = ContentScale.Crop,
        modifier = modifier
//            .size(244.dp)
            .offset(y = offsetY.dp)

    )

}