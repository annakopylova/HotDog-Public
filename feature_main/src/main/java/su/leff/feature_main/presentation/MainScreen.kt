package su.leff.feature_main.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import su.leff.design.components.ButtonCard
import su.leff.design.components.ProductCard
import su.leff.design.components.subcomponents.HorizontalSpacer
import su.leff.design.components.subcomponents.VerticalSpacer
import su.leff.design.components.theming.LightGrey
import su.leff.design.components.theming.nunitoExtraBold
import su.leff.design.ext.noOverscroll
import su.leff.feature_main.R

@Composable
fun MainScreen() {
    val list = listOf(
        ProductItem(
            image = "https://m.media-amazon.com/images/I/61KyI17pFJL._SL1500_.jpg",
            name = "The ordinary",
            description = "Набор для проблемной и жирной кожи лица",
            volume = null,
            price = "2 590 ₽"
        ),
        ProductItem(
            image = "https://www.laroche-posay.us/dw/image/v2/AANG_PRD/on/demandware.static/-/Sites-lrp-us-Library/default/dwd1ef213e/images/plp/la-roche-posay-effaclar-mobile.jpg?sw=480&sh=280&sm=cut&q=70",
            name = "LA ROCHE-POSAY",
            description = "Гель для умывания effaclar с кислотами для жирной и комбинированной кожи лица",
            volume = "200 мл",
            price = "1 099 ₽"
        ),
        ProductItem(
            image = "https://api.rivegauche.ru/medias6/3700971363704.jpg?context=bWFzdGVyfGltYWdlc3w0NDE4NTJ8aW1hZ2UvanBlZ3xoOTUvaGY5LzExMDA1NDYyMDUyODk0LzM3MDA5NzEzNjM3MDQuanBnfDE4NjA0ZDM0MTkxNTNiNTMzN2MxNzQ0MGZlMGYyMjMzZjJkOTJkMzVmMTE1YjlmYWI3YTU5NDgxNWQyOGJkZmI",
            name = "Vivienne Sabo",
            description = "Гидрогелевые патчи для кожи вокруг глаз",
            volume = "150 гр",
            price = "599 ₽"
        )
    )

    val buttonList = listOf(
        ButtonItem(
            icon = su.leff.design.R.drawable.ic_face,
            text = "Лицо"
        ),
        ButtonItem(
            icon = su.leff.design.R.drawable.ic_hair,
            text = "Волосы"
        ),
        ButtonItem(
            icon = su.leff.design.R.drawable.ic_brush,
            text = "Макияж"
        ),
        ButtonItem(
            icon = su.leff.design.R.drawable.ic_body,
            text = "Тело"
        ),
        ButtonItem(
            icon = su.leff.design.R.drawable.ic_man,
            text = "Для мужчин"
        ),
        ButtonItem(
            icon = su.leff.design.R.drawable.ic_parfume,
            text = "Парфюмерия"
        ),
        ButtonItem(
            icon = su.leff.design.R.drawable.ic_kids,
            text = "Для детей"
        ),
        ButtonItem(
            icon = su.leff.design.R.drawable.ic_pets,
            text = "Для животных"
        ),
        ButtonItem(
            icon = su.leff.design.R.drawable.ic_eco,
            text = "Эко"
        )

    )
    Scaffold(modifier = Modifier.background(LightGrey())) {

        Column() {
            LazyRow(contentPadding = PaddingValues(16.dp)) {
                items(list) { item ->
                    ProductCard(
                        image = item.image,
                        name = item.name,
                        description = item.description,
                        volume = item.volume,
                        price = item.price
                    ) {

                    }
                    HorizontalSpacer(width = 8)
                    VerticalSpacer(height = 8)
                }

            }

            Text(text = "КАТАЛОГ", style = nunitoExtraBold(size = 24), modifier = Modifier.padding(horizontal = 16.dp) )

            noOverscroll{
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(buttonList) { item ->
                        ButtonCard(icon = item.icon, text = item.text) {

                        }
                    }
                }
            }

        }


    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}


data class ProductItem(
    val image: String,
    val name: String,
    val description: String,
    val volume: String?,
    val price: String
)

data class ButtonItem(
    val icon: Int,
    val text: String
)