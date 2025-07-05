package com.android.caffeine.screens.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.caffeine.R
import com.android.caffeine.ui.theme.Black60
import com.android.caffeine.ui.theme.Brown50
import com.android.caffeine.ui.theme.LightBrown
import com.android.caffeine.ui.theme.White
import com.android.caffeine.ui.theme.urbanist


@Preview(showBackground = true)
@Composable
fun CoffeeBeansSize(
    modifier: Modifier = Modifier
) {

    var selectedSize by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier.padding(start = 97.dp, end = 111.dp),

    ) {
        Row(
            modifier = Modifier
                .background(White, RoundedCornerShape(100.dp))
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf("L", "M", "H").forEach { size ->
                CoffeeBeansSizeItem(
                    text = size,
                    selected = selectedSize == size,
                ) {
                    selectedSize = size
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listOf("Low","Medium","High").forEach { beansSize ->
                Text(
                    text =beansSize,
                    fontFamily = urbanist,
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp,
                    color = Black60,
                    lineHeight = 10.sp,
                    letterSpacing = 0.25.sp,
                )
            }
        }
    }
}

@Composable
fun CoffeeBeansSizeItem(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val transition = updateTransition(targetState = selected)

    val backgroundColor by transition.animateColor(
        transitionSpec = { tween(300, easing = FastOutSlowInEasing) },
    ) { isSelected ->
        if (isSelected) LightBrown else Color.Transparent
    }
    val shadowAlpha by transition.animateFloat(
        transitionSpec = { tween(300, easing = FastOutSlowInEasing) },
    ) { isSelected ->
        if (isSelected) 0.12f else 0f
    }


    Box {
        if (shadowAlpha > 0f) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .offset(y = 6.dp)
                    .blur(12.dp, BlurredEdgeTreatment.Unbounded)
                    .background(
                        color = Brown50,
                        shape = RoundedCornerShape(100)
                    )
            )
        }

        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(100.dp))
                .clickable { onClick() }
                .background(backgroundColor)
                .padding(horizontal = 10.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center,
        ) {

            AnimatedVisibility (
                visible = selected,
                enter = fadeIn() + scaleIn(initialScale = 0f),
                exit  = fadeOut() + scaleOut(targetScale = 0f)
            ) {
                Icon(
                    painter = painterResource(R.drawable.coffee_beans),
                    contentDescription = null,
                    modifier = Modifier.width(24.dp),
                    tint = White
                )
            }
        }
    }
}
