package su.leff.design.components.theming

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import su.leff.design.components.subcomponents.ButtonWithoutPadding
import su.leff.design.components.subcomponents.cornerRadius8

@Composable
fun WideButton(title: String, onClick: (() -> Unit)) {
    Card(
        elevation = 0.dp,
        border = BorderStroke(2.dp, DarkGrey()),
        shape = cornerRadius8,
        modifier = Modifier.fillMaxWidth()
    ) {
        ButtonWithoutPadding(shape = cornerRadius8, onClick = onClick) {
            Text(
                text = title,
                style = nunitoBlack(color = Red(), size = 20),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}