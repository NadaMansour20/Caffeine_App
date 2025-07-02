package com.android.caffeine.screens.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.caffeine.R
import com.android.caffeine.ui.theme.Black14


@Preview(showBackground = true)
@Composable
fun AnimatedGhost(modifier: Modifier = Modifier) {
    val ghostState = rememberInfiniteTransition()
    val shadowState = rememberInfiniteTransition()

    val offsetY by ghostState.animateFloat(
        initialValue = 0f,
        targetValue = -30f,
        animationSpec = infiniteRepeatable(
            animation = tween(easing = LinearEasing, durationMillis = 1200),
            repeatMode = RepeatMode.Reverse
        ),
    )

    val scale by shadowState.animateFloat(
        initialValue = 0f,
        targetValue = 10f,
        animationSpec = infiniteRepeatable(
            animation = tween( easing = LinearEasing, durationMillis = 1200),
            repeatMode = RepeatMode.Reverse
        ),
    )

    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Image(
            painter = painterResource(R.drawable.coffee_ghost),
            contentDescription = "Coffee_ghost",
            contentScale = ContentScale.Crop,
            modifier = modifier.weight(1f)
                .offset(y = offsetY.dp)

        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 98.67.dp, end = 84.dp)
                . height(27.65.dp)
                .width(177.3.dp)
                .offset(y = scale.dp)
                .blur(
                    radius = 12.dp,
                    edgeTreatment = BlurredEdgeTreatment.Unbounded
                )
                .drawBehind {
                    drawOval(
                        color = Black14,
                        topLeft = Offset.Zero,
                        size = Size(size.width, size.height),
                    )
                }


        )
    }


}