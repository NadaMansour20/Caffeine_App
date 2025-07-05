package com.android.caffeine.screens


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.pager.*
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.android.caffeine.R
import com.android.caffeine.screens.component.SkipHeader
import com.android.caffeine.ui.theme.Black87
import com.android.caffeine.ui.theme.urbanist
import kotlin.math.absoluteValue


val cards = listOf(
    R.drawable.chocolate,
    R.drawable.cup_cake,
    R.drawable.cookies,
    R.drawable.cinnabon,
    R.drawable.croissant,
    R.drawable.biscuit
)


@Preview(showSystemUi = true)
@Composable
fun Snacks() {

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        SkipHeader()
        Text(
            text = stringResource(R.string.take_your_snack),
            fontFamily = urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = Black87,
            lineHeight = 22.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
        VerticalCardPager(cards = cards)


    }
}


@Composable
fun VerticalCardPager(
    cards: List<Int>,          // Drawable IDs
    cardSize: Dp = 260.dp
) {
    // حالة الـPager
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { cards.size }
    )

    // Snap للمنتصف بدقة
    val fling = PagerDefaults.flingBehavior(
        state = pagerState,
        pagerSnapDistance = PagerSnapDistance.atMost(1)
    )


    VerticalPager(
        state = pagerState,
        flingBehavior = fling,
        beyondViewportPageCount = 2,
        pageSize = PageSize.Fixed(cardSize),
        pageSpacing = (-100).dp,            // تداخل الصفحات
        modifier = Modifier
            .fillMaxHeight()
            .padding(end = 97.33.dp)      // Padding علوى وسُفلى عشان يظهر نص الكارت
    ) { page ->

        // Offset نسبى من 0 (مركز) لـ 1 (صفحة كاملة برّه)
        val pageOffset = (
                (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                ).absoluteValue

        // Scale و Rotation تتغيّر حسب البُعد
        val scale = lerp(1f, 0.85f, pageOffset)
        val rotation = lerp(0f, 10f, pageOffset)  // يمين/شمال زى اللى فى الصورة

            Image(
                painter = painterResource(id = cards[page]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    rotationZ = rotation
                }.fillMaxSize()
            )
//        }
    }
}


