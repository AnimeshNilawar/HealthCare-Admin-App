package com.dialiax.healthcareadmin.Screens.shimmer

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerEffect() {
    val shimmerColos = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f)

    )
    val transition = rememberInfiniteTransition()
    val translateAnimation = transition.animateFloat(

        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutLinearInEasing
            )
        ), label = ""
    )

    val brush = Brush.linearGradient(
        colors = shimmerColos,
        start = Offset(10f, 10f),
        end = Offset(translateAnimation.value, translateAnimation.value)
    )
    ShimmerGridItem(brush = brush)

}


@Composable
fun ShimmerGridItem(brush: Brush) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .width(120.dp)

                        //.weight(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(brush)
                )
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .width(80.dp)
                        //.weight(.4f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(brush)
                )
            }

            Spacer(modifier = Modifier.size(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Spacer(
                    modifier = Modifier
                        .weight(.7f)
                        .size(40.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(brush)
                )
                Spacer(modifier = Modifier.width(60.dp))
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .size(40.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(brush)
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4_XL,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ShimmerGridItemPreview() {
    ShimmerGridItem(brush = Brush.linearGradient(listOf(Color.White, Color.LightGray, Color.White)))
}
