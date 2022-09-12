package su.leff.design.components.subcomponents

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Scale
import su.leff.design.components.theming.Black

@Composable
fun SquareAsyncImage(url: String, contentDescription: String, key: String?) {
    var showLoader by remember { mutableStateOf(true) }
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(false)
            .memoryCacheKey(key)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .diskCacheKey(key)
            .scale(Scale.FILL)
            .build(),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(140.dp),
//        onLoading = { showLoader = true },
        onSuccess = { showLoader = false }
    )
    AnimatedVisibility(visible = showLoader, enter = fadeIn(), exit = fadeOut()) {
        CircularProgressIndicator(color = Black())
    }
}