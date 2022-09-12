package su.leff.design.components.theming

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import su.leff.design.R
import su.leff.design.components.subcomponents.ButtonWithoutPadding
import su.leff.design.components.subcomponents.VectorIcon
import su.leff.design.components.subcomponents.cornerRadius8

@Composable
fun ProfileButtonCard(content: @Composable () -> Unit, onClick: (() -> Unit)) {
    ButtonWithoutPadding(shape = cornerRadius8, onClick = onClick) {
        Row(modifier = Modifier
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically) {
            content()
            Spacer(modifier = Modifier.weight(1F))
            VectorIcon(icon = R.drawable.ic_chevron)
        }
    }
}