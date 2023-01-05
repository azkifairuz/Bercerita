package com.javfairuz.bercerita

import androidx.compose.ui.res.stringResource

class OnBoardingItems(var image : Int,var title: Int)
{
    companion object {
        fun get():List<OnBoardingItems>{
            return listOf(
                OnBoardingItems(R.drawable.logo_on_boarding,R.string.text1),
                OnBoardingItems(R.drawable.tiga,R.string.text2 ),
                OnBoardingItems(R.drawable.dua, R.string.text3)
            )
        }
    }
}
