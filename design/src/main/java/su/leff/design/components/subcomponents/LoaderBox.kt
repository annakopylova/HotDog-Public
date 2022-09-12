package su.leff.design.components.subcomponents

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import su.leff.design.R
import su.leff.design.components.theming.Black

@Composable
fun LoaderBox(visible: Boolean) {
    AnimatedVisibility(visible = visible, enter = fadeIn(), exit = fadeOut()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Black().copy(alpha = 0.3f)), contentAlignment = Alignment.Center
        ) {
//            Loader(modifier = Modifier.fillMaxWidth(0.75f))
        }
    }
}

//@Composable
//fun Loader(modifier: Modifier = Modifier) {
//    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.spinner))
//    LottieAnimation(
//        modifier = modifier,
//        composition = composition,
//        iterations = LottieConstants.IterateForever
//    )
//}