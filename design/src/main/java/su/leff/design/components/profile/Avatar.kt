package su.leff.design.components.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import su.leff.core.R
import androidx.compose.ui.unit.dp
import su.leff.design.components.subcomponents.SquareAsyncImage
import su.leff.design.components.theming.Black
import su.leff.design.components.theming.MediumGrey
import su.leff.design.components.theming.nunitoBlack

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Avatar(modifier: Modifier = Modifier, url: String? = null, name: String, key: String?) {
    val startingStyle = nunitoBlack(color = Black(), size = 64)
    var textStyle by remember { mutableStateOf(startingStyle) }
    var readyToDraw by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .size(140.dp)
            .clip(CircleShape)
            .background(MediumGrey(), CircleShape),
        contentAlignment = Alignment.Center
    ) {
        if (url != null) {
            SquareAsyncImage(url, stringResource(R.string.your_avatar), key)
        } else {
            CompositionLocalProvider(
                LocalMinimumTouchTargetEnforcement provides false,
            ) {
                Text(
                    text = name.firstOrNull()?.uppercase() ?: "",
                    style = textStyle,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .drawWithContent {
                            if (readyToDraw) drawContent()
                        },
                    onTextLayout = { result ->
                        if (result.hasVisualOverflow) {
                            textStyle = textStyle.copy(fontSize = textStyle.fontSize * 0.9)
                        } else {
                            readyToDraw = true
                        }
                    }
                )
            }
        }
    }
}