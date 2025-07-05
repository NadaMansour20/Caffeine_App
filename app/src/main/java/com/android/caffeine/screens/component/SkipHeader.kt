package com.android.caffeine.screens.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.caffeine.R
import com.android.caffeine.ui.theme.Black87
import com.android.caffeine.ui.theme.LightWhite

@Composable
fun SkipHeader(){

    Row(
        modifier = Modifier.padding(start = 16.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.skip_page),
            contentDescription = "Add",
            tint = Black87,
            modifier = Modifier
                .size(48.dp)
                .clickable {  }
                .background(LightWhite, RoundedCornerShape(100.dp))
                .padding(12.dp)

        )
    }
}