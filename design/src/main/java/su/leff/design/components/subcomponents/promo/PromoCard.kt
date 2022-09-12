package su.leff.design.components.subcomponents.promo

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import su.leff.design.R
import su.leff.design.components.subcomponents.ButtonWithoutPadding
import su.leff.design.components.subcomponents.VectorIcon
import su.leff.design.components.subcomponents.cornerRadius8
import su.leff.design.components.subcomponents.zeroElevation
import su.leff.design.components.theming.*


@Composable
fun PromoCard(
    modifier: Modifier = Modifier,
    color: Color,
    description: String?,
    promoName: String,
    shop: String,
    onClick: (() -> Unit)
) {
    ButtonWithoutPadding(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        shape = cornerRadius8, onClick = onClick, backgroundColor = color,
        elevation = zeroElevation()
    ) {
        Column {

            Text(
                text = promoName,
                style = nunitoExtraBold(size = 24),
                modifier = Modifier.padding(horizontal = 16.dp, 8.dp)
            )
            if (description != null) {
                Text(
                    text = description,
                    style = nunitoRegular(Black(), 14),
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 0.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = shop,
                    style = nunitoBold(size = 20),
                    modifier = Modifier.padding(horizontal = 16.dp, 8.dp)
                )
                VectorIcon(
                    icon = R.drawable.ic_arrow_right,
                    modifier = Modifier
                        .padding(8.dp, 8.dp, 16.dp, 8.dp)
                        .size(20.dp)
                )
            }

        }
    }
}

@Preview
@Composable
fun PromoCardPreview() {
    PromoCard(
        color = Green(),
        description = "с 10 по 20 августа",
        promoName = "MIXIT -25%",
        shop = "ЗОЛОТОЕ ЯБЛОКО"
    ) {

    }
}