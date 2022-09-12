package su.leff.design.components.subcomponents.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import su.leff.design.R
import su.leff.design.components.subcomponents.VectorIcon
import su.leff.design.components.theming.Black
import su.leff.design.components.theming.nunitoExtraBold
import su.leff.design.components.theming.nunitoRegular
import su.leff.design.ext.clickableWithoutRipple

@Composable
fun SearchCategoryTexts(title: String, onButtonClick: () -> Unit) {
    Row(modifier = Modifier.clickableWithoutRipple(onButtonClick)
        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween){

        Text(
            text = title, modifier = Modifier
                .padding(start = 16.dp),
            style = nunitoExtraBold(size = 24, color = Black())

        )

    }


}

@Preview
@Composable
fun SearchCategoryTextsPreview() {
    SearchCategoryTexts(title = "test") {

    }
}