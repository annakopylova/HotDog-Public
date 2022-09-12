package su.leff.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Scale
import su.leff.design.R
import su.leff.design.components.subcomponents.ButtonWithoutPadding
import su.leff.design.components.subcomponents.VectorIcon
import su.leff.design.components.subcomponents.cornerRadius8
import su.leff.design.components.subcomponents.zeroElevation
import su.leff.design.components.theming.*

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    image: String,
    name: String,
    description: String,
    volume: String?,
    price: String,
    onClick: (() -> Unit)
) {
    ButtonWithoutPadding(
        modifier = modifier.width(200.dp),
        shape = cornerRadius8, onClick = onClick, backgroundColor = White(),
        elevation = zeroElevation()
    ) {
        Column {
            Box(
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .background(White()),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .crossfade(true)
                        .memoryCacheKey(image)
                        .memoryCachePolicy(CachePolicy.ENABLED)
                        .diskCachePolicy(CachePolicy.ENABLED)
                        .diskCacheKey(image)
//                    .scale(Scale.FILL)
                        .build(),
                    contentDescription = name,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.height(120.dp)
                )
            }

            Text(
                text = name,
                style = nunitoBold(),
                modifier = Modifier.padding(8.dp, 8.dp)
            )
            Text(
                text = description,
                style = nunitoRegular(Black(), 14),
                modifier = Modifier.padding(8.dp, top = 0.dp, end = 16.dp, bottom = 8.dp)
            )
            if (volume!=null){
                Text(
                    text = volume,
                    style = nunitoLight(DarkCharcoal(), 14),
                    modifier = Modifier.padding(start = 8.dp, top = 0.dp, end = 16.dp, bottom = 4.dp)
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = price, style = nunitoExtraBold(),
                    modifier = Modifier.padding(8.dp, 0.dp, 16.dp, 8.dp)
                )
                VectorIcon(
                    icon = R.drawable.ic_arrow_right,
                    modifier = Modifier
                        .padding(8.dp, 0.dp, 16.dp, 8.dp)
                        .size(20.dp)
                )
            }

        }
    }
}

@Preview
@Composable
fun ProductCardPreview() {
    ProductCard(image = "", name = "", description = "", volume = null, price = "") {

    }
}