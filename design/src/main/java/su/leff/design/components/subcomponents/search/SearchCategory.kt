package su.leff.design.components.subcomponents.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import su.leff.design.components.subcomponents.ButtonWithoutPadding
import su.leff.design.components.subcomponents.cornerRadius8
import su.leff.design.components.theming.DarkGrey
import su.leff.design.components.theming.White
import su.leff.design.components.theming.nunitoBold

@Composable
fun SearchCategory(title: String, onButtonClick:() -> Unit){
    ButtonWithoutPadding(shape = cornerRadius8, onClick = { onButtonClick()},
        backgroundColor = White()
    ) {
        Text(text = title, modifier = Modifier.padding(vertical = 16.dp),
            style = nunitoBold(size = 14, color = DarkGrey()))

    }
}