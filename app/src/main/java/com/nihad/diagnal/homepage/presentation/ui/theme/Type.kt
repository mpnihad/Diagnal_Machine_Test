package com.plcoding.cleanarchitecturenoteapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.nihad.diagnal.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */

//    45pt, SemiBold, #FFFFFF, Center


)


private val appFontFamily = FontFamily(
    fonts = listOf(

        Font(
            resId = R.font.titilliumweb_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.titilliumweb_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.titilliumweb_regular,
            weight = FontWeight.ExtraLight,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.titilliumweb_regular,
            weight = FontWeight.ExtraLight,
            style = FontStyle.Italic
        ),

        Font(
            resId = R.font.titilliumweb_regular,
            weight = FontWeight.Light,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.titilliumweb_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Italic
        ),

        Font(
            resId = R.font.titilliumweb_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.titilliumweb_semi_bold,
            weight = FontWeight.SemiBold,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.titilliumweb_semi_bold_italic,
            weight = FontWeight.SemiBold,
            style = FontStyle.Italic
        ),

        Font(
            resId = R.font.titilliumweb_regular,
            weight = FontWeight.Light,
            style = FontStyle.Italic
        )

    )
)


private val defaultTypography = Typography()
val appTypography = Typography(
    h1 = defaultTypography.h1.copy(fontFamily = appFontFamily, fontSize = 22.sp, fontWeight = FontWeight.SemiBold, fontStyle = FontStyle.Normal),
    h2 = defaultTypography.h2.copy(fontFamily = appFontFamily, fontSize = 16.sp, fontWeight = FontWeight.Normal, fontStyle = FontStyle.Normal),
    h3 = defaultTypography.h3.copy(fontFamily = appFontFamily, fontSize = 14.sp, letterSpacing = 0.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal),
    h4 = defaultTypography.h4.copy(fontFamily = appFontFamily),
    h5 = defaultTypography.h5.copy(fontFamily = appFontFamily),
    h6 = defaultTypography.h6.copy(fontFamily = appFontFamily),
    subtitle1 = defaultTypography.subtitle1.copy(fontFamily = appFontFamily, fontSize = 16.sp),
    subtitle2 = defaultTypography.subtitle2.copy(fontFamily = appFontFamily),
    body1 = defaultTypography.body1.copy(fontFamily = appFontFamily, fontSize = 18.sp, letterSpacing = 0.sp, fontWeight = FontWeight.Normal, fontStyle = FontStyle.Normal),
    body2 = defaultTypography.body2.copy(fontFamily = appFontFamily, fontSize = 12.sp),
    button = defaultTypography.button.copy(fontFamily = appFontFamily, fontSize = 14.sp, letterSpacing = 1.15.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal),
    caption = defaultTypography.caption.copy(fontFamily = appFontFamily, fontSize = 12.sp, letterSpacing = 1.15.sp, fontWeight = FontWeight.Normal, fontStyle = FontStyle.Normal),
    overline = defaultTypography.overline.copy(fontFamily = appFontFamily)
)
