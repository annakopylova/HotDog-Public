package su.leff.design.ext

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.LocalOverScrollConfiguration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun noOverscroll(content: @Composable () -> Unit){
    CompositionLocalProvider(
        LocalOverScrollConfiguration provides null
    ) {
        content()
    }
}