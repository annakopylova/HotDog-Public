package su.leff.design.components.profile

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import su.leff.design.components.subcomponents.HorizontalSpacer
import su.leff.design.components.subcomponents.VectorIcon
import su.leff.design.components.theming.ProfileButtonCard
import su.leff.design.components.theming.nunitoMedium

@Composable
fun SubScreenButton(icon: Int, title: String, onClick: (() -> Unit)) {
    ProfileButtonCard(content = {
        Row {
            VectorIcon(icon, modifier = Modifier.size(24.dp))
            HorizontalSpacer(width = 16)
            Text(text = title, style = nunitoMedium())
        }
    }, onClick = onClick)
}