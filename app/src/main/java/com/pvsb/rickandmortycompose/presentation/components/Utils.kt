package com.pvsb.rickandmortycompose.presentation.components

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object CustomTypography {
    val typography = Typography(
        body1 = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        ),
        body2 = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        ),
        subtitle1 = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Black,
            color = Color.White
        )
    )
}

val backGroundColor = Color(0xFF202329)
val greyBackGroundColor = Color(0xFF3C3E44)
val greenColor = Color(0xFF55CC44)
val redColor = Color(0xFFD63D2E)
val greyColor = Color(0xFF9E9E9E)
