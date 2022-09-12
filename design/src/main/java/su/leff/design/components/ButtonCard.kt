package su.leff.design.components

import android.graphics.drawable.Drawable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import su.leff.design.R
import su.leff.design.components.subcomponents.ButtonWithoutPadding
import su.leff.design.components.subcomponents.VectorIcon
import su.leff.design.components.subcomponents.cornerRadius8
import su.leff.design.components.subcomponents.zeroElevation
import su.leff.design.components.theming.LightGrey
import su.leff.design.components.theming.White
import su.leff.design.components.theming.nunitoBold

@Composable
fun ButtonCard(icon: Int, text: String, onClick: (() -> Unit)) {
    ButtonWithoutPadding(
        shape = cornerRadius8, onClick = onClick, backgroundColor = LightGrey(),
        elevation = zeroElevation()
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VectorIcon(icon = icon)
            Text(text = text, style = nunitoBold(size = 12))
        }
    }
}

@Preview
@Composable
fun ButtonCardPreview() {
    ButtonCard(icon = R.drawable.ic_face, text = "Лицо") {

    }
}