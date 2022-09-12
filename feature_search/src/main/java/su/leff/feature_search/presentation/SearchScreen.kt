package su.leff.feature_search.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import su.leff.design.components.subcomponents.HorizontalSpacer
import su.leff.design.components.subcomponents.VerticalSpacer
import su.leff.design.components.subcomponents.search.SearchCategoryTexts
import su.leff.design.components.subcomponents.search.SearchCategoryTitles
import su.leff.design.components.subcomponents.search.SearchToolbar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchScreen(onBackAction: (() -> Unit)) {
    val listTexts = listOf(
        Texts("ДЛЯ ВАС"),
        Texts("НОВИНКИ"),
        Texts("АКЦИИ"),
        Texts("MUST_HAVE"))
    val listTitles = listOf(
        Titles("КАТАЛОГ"),
        Titles("БРЕНДЫ")
    )



    Scaffold(topBar = { SearchToolbar(onBackAction = onBackAction) }) {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        )
        {
            itemsIndexed(listTitles){index, item ->
                SearchCategoryTitles(title = item.name){}
            }

            itemsIndexed(listTexts){index, item ->
                SearchCategoryTexts(title = item.name){}
            }

        }
        VerticalSpacer(height = 8)
    }
}

@Preview
@Composable
fun SearchScreenPreview(){
    SearchScreen {

    }
}

data class Titles(
    val name: String
)

data class Texts(
    val name: String
)