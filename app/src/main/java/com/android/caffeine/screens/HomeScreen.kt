package com.android.caffeine.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.caffeine.R
import com.android.caffeine.screens.component.AnimatedGhost
import com.android.caffeine.screens.component.CoffeeButton
import com.android.caffeine.screens.component.Header
import com.android.caffeine.screens.component.TextAndAnimatedStar


@Preview(showSystemUi = true)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Header()
        TextAndAnimatedStar()
        AnimatedGhost()
        CoffeeButton(
            buttonTextId = R.string.bring_my_coffee,
            iconId = R.drawable.button_coffee
        )

    }
}