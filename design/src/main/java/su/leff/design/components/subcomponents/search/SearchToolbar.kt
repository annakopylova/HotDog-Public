package su.leff.design.components.subcomponents.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import su.leff.design.components.subcomponents.VectorIcon
import su.leff.design.R
import su.leff.design.components.subcomponents.cornerRadius8
import su.leff.design.components.theming.*
import su.leff.design.ext.unboundClickable

@Composable
fun SearchToolbar(onBackAction: (() -> Unit)) {
    var searchQuery by remember { mutableStateOf("") }
    ConstraintLayout(modifier = Modifier
        .fillMaxWidth()
        .background(LightGrey())) {
        val (button, field, searchIcon) = createRefs()
        VectorIcon(
            icon = R.drawable.ic_back,
            modifier = Modifier
                .constrainAs(button) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
                .padding(vertical = 8.dp, horizontal = 8.dp)
                .unboundClickable(onBackAction)
        )
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .constrainAs(field) {
                    start.linkTo(button.end)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .padding(end = 16.dp, top = 8.dp, bottom = 8.dp, start = 8.dp),

            shape = cornerRadius8,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = White(),
                cursorColor = Black(),
                textColor = Black(),
                trailingIconColor = Black(),
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )
        if (searchQuery.isEmpty()){
            VectorIcon(icon = R.drawable.ic_search_light,
                modifier = Modifier
                    .offset(x = (-32).dp)
                    .constrainAs(searchIcon) {
                        end.linkTo(field.end)
                        top.linkTo(field.top)
                        bottom.linkTo(field.bottom)
                    }

            )
        }

    }

}

@Preview
@Composable
fun SearchToolbarPreview() {
    SearchToolbar() {

    }
}