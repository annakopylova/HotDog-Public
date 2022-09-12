package su.leff.design.components.theming

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import su.leff.design.R

val Nunito = FontFamily(
    Font(R.font.nunito_regular, style = FontStyle.Normal),
    Font(R.font.nunito_bold, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(R.font.nunito_light, weight = FontWeight.Light, style = FontStyle.Normal),
    Font(R.font.nunito_extra_bold, weight = FontWeight.ExtraBold, style = FontStyle.Normal),
    Font(R.font.nunito_extra_light, weight = FontWeight.ExtraLight, style = FontStyle.Normal),
    Font(R.font.nunito_medium, weight = FontWeight.Medium, style = FontStyle.Normal),
    Font(R.font.nunito_semi_bold, weight = FontWeight.SemiBold, style = FontStyle.Normal),
    Font(R.font.nunito_regular, weight = FontWeight.Normal, style = FontStyle.Normal),

//    Font(R.font.nunito_italic, style = FontStyle.Italic),
    Font(R.font.nunito_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(R.font.nunito_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(R.font.nunito_extra_bold_italic, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
    Font(R.font.nunito_extra_light_italic, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
    Font(R.font.nunito_medium_italic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(R.font.nunito_semi_bold_italic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
)

@Composable
fun nunitoBlack(color: Color = Black(), size: Int = 16) =
    TextStyle(fontSize = size.sp, color = color, fontWeight = FontWeight.Black, fontFamily = Nunito)

@Composable
fun nunitoBold(color: Color = Black(), size: Int = 16) =
    TextStyle(fontSize = size.sp, color = color, fontWeight = FontWeight.Bold, fontFamily = Nunito)

@Composable
fun nunitoBoldSpan(color: Color = Black(), size: Int = 16) =
    SpanStyle(fontSize = size.sp, color = color, fontWeight = FontWeight.Bold, fontFamily = Nunito)

@Composable
fun nunitoLight(color: Color = Black(), size: Int = 16) =
    TextStyle(fontSize = size.sp, color = color, fontWeight = FontWeight.Light, fontFamily = Nunito)

@Composable
fun nunitoLightSpan(color: Color = Black(), size: Int = 16) =
    SpanStyle(fontSize = size.sp, color = color, fontWeight = FontWeight.Light, fontFamily = Nunito)

@Composable
fun nunitoExtraBold(color: Color = Black(), size: Int = 16) =
    TextStyle(fontSize = size.sp, color = color, fontWeight = FontWeight.ExtraBold, fontFamily = Nunito)

@Composable
fun nunitoExtraLight(color: Color = Black(), size: Int = 16) =
    TextStyle(fontSize = size.sp, color = color, fontWeight = FontWeight.ExtraLight, fontFamily = Nunito)

@Composable
fun nunitoMedium(color: Color = Black(), size: Int = 16) =
    TextStyle(fontSize = size.sp, color = color, fontWeight = FontWeight.Medium, fontFamily = Nunito)

@Composable
fun nunitoMediumSpan(color: Color = Black(), size: Int = 16) =
    SpanStyle(fontSize = size.sp, color = color, fontWeight = FontWeight.Medium, fontFamily = Nunito)

@Composable
fun nunitoSemiBold(color: Color = Black(), size: Int = 16) =
    TextStyle(fontSize = size.sp, color = color, fontWeight = FontWeight.SemiBold, fontFamily = Nunito)

@Composable
fun nunitoRegular(color: Color = Black(), size: Int = 16) =
    TextStyle(fontSize = size.sp, color = color, fontWeight = FontWeight.Normal, fontFamily = Nunito)
