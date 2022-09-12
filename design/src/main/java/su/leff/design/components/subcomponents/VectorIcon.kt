package su.leff.design.components.subcomponents

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource

@Composable
fun VectorIcon(
    icon: Int,
    contentDescription: String = "",
    modifier: Modifier = Modifier
) {
    val vector = ImageVector.vectorResource(id = icon)
    val painter = rememberVectorPainter(image = vector)
    Image(
        painter = painter,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}
