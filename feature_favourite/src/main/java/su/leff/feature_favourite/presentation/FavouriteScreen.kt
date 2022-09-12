package su.leff.feature_favourite.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import su.leff.design.components.ProductCard
import su.leff.design.components.subcomponents.HorizontalSpacer
import su.leff.design.components.subcomponents.VerticalSpacer
import su.leff.design.components.theming.LightGrey
import su.leff.design.components.theming.White
import su.leff.design.components.theming.nunitoExtraBold

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FavouriteScreen() {
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
        ),
        ProductItem(
            image = "https://my7days.ru/upload/resize_cache/iblock/54c/54ced20b4f67213a48480612fa851d18_extensions_512_682_512_683_255_255_255_12723ff99b117ffb6479236a07c60aa12b0.jpg",
            name = "7DAYS",
            description = "Гель для душа СВЕЖЕСТЬ И ВДОХНОВЕНИЕ",
            volume = "400 мл",
            price = "299 ₽"
        )
    )

    Scaffold(modifier = Modifier.background(White()),
    topBar = {
        Text(
            text = "ИЗБРАННОЕ",
            style = nunitoExtraBold(size = 24),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        )
    }) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
        ) {

            LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.heightIn(max = 600.dp)) {
                itemsIndexed(list) { index, item ->
                    ProductCard(
                        modifier = Modifier.padding(
                            start = if (index % 2 == 0) {
                                0.dp
                            } else 4.dp,
                            end = if (index % 2 == 0) {
                                4.dp
                            } else 0.dp,
                            top = 8.dp,
                            bottom = 8.dp
                        ),

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
        }
        }

}

@Preview
@Composable
fun FavouriteScreenPreview() {
    FavouriteScreen()
}

data class ProductItem(
    val image: String,
    val name: String,
    val description: String,
    val volume: String?,
    val price: String
)