package com.android.caffeine.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.caffeine.R
import com.android.caffeine.screens.component.CoffeeButton
import com.android.caffeine.screens.component.CoffeeSize
import com.android.caffeine.screens.component.CoffeeTypeHeader

@Preview(showSystemUi = true)
@Composable
fun CoffeeTypeAndSize(){

    Column {
        CoffeeTypeHeader()

        CoffeeSize(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            )

        CoffeeButton(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            buttonTextId = R.string.Continue,
            iconId = R.drawable.arrow_right,
            onClick = {}
        )
    }
}