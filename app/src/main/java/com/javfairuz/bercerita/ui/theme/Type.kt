package com.javfairuz.bercerita.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.javfairuz.bercerita.R

// Set of Material typography styles to start with
val Typography: Typography
    get() = Typography(
        h1 = TextStyle(
            fontFamily = PoppinsBold,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        ),
        body1 = TextStyle(
            fontFamily = PoppinsRegular,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        subtitle2 = TextStyle(
            fontFamily = PoppinsRegular,
            fontWeight = FontWeight.Light,
            fontSize = 10.sp
        ),
        button = TextStyle(
            fontFamily = PoppinsMedium,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp
        )
/* Other default text styles to override
caption = TextStyle(
  fontFamily = FontFamily.Default,
  fontWeight = FontWeight.Normal,
  fontSize = 12.sp
)

*/
    )

val PoppinsRegular = FontFamily(
    Font(R.font.poppins_regular),


    )
val PoppinsBold = FontFamily(

    Font(R.font.poppins_bold, FontWeight.Bold)

)
val PoppinsMedium = FontFamily(
    Font(R.font.poppins_medium),


    )