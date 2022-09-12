package su.leff.feature_promo.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import su.leff.design.components.subcomponents.VerticalSpacer
import su.leff.design.components.subcomponents.promo.PromoCard
import su.leff.design.components.theming.Green
import su.leff.design.components.theming.Pink
import su.leff.design.components.theming.nunitoExtraBold

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PromoScreen() {

    val listPromo = listOf(
        PromoItem(
            color = Pink(),
            description = "",
            promoName = "TAYKA500",
            shop = "Л'ЭТУАЛЬ"
        ),
        PromoItem(
            color = Green(),
            description = "при регистрации нового пользователя",
            promoName = "-700 ₽ на первую покупку",
            shop = "РИВ ГОШ"
        ),
        PromoItem(
            color = Green(),
            description = "на заказ от 1 000 ₽",
            promoName = "БЕСПЛАТНАЯ ДОСТАВКА",
            shop = "ЗОЛОТОЕ ЯБЛОКО"
        ),
        PromoItem(
            color = Pink(),
            description = "-300 ₽ при заказе от 1 500 ₽ в интернет-магазине",
            promoName = "ORDER-300",
            shop = "ПОДРУЖКА"
        ),
        PromoItem(
            color = Pink(),
            description = "-10% на покупку от блогера @anna_n",
            promoName = "ANNA_N",
            shop = "Л'ЭТУАЛЬ"
        ),
        PromoItem(
            color = Green(),
            description = "на все тканевые маски",
            promoName = "3+1",
            shop = "ПОДРУЖКА"
        )
    )

    Scaffold(topBar = {
        Text(
            text = "ПРОМОКОДЫ И АКЦИИ",
            style = nunitoExtraBold(size = 24),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }) {
        LazyColumn() {

            items(listPromo) { item ->
                PromoCard(
                    color = item.color,
                    description = item.description,
                    promoName = item.promoName,
                    shop = item.shop
                ) {

                }
                VerticalSpacer(height = 8)

            }

        }
    }



}

data class PromoItem(
    val color: Color,
    val description: String?,
    val promoName: String,
    val shop: String
)

@Preview
@Composable
fun PromoScreenPreview() {
    PromoScreen()
}