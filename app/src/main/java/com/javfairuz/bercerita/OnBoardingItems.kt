package com.javfairuz.bercerita

class OnBoardingItems(var image : Int,var title: String, var desc :String)
{
    companion object {
        fun get():List<OnBoardingItems>{
            return listOf(
                OnBoardingItems(R.drawable.logo_on_boarding,"becerita", "bebas bercerita apa saja"),
                OnBoardingItems(R.drawable.logo_on_boarding,"becerta 2", "bebas bercerita apa saja 2"),
                OnBoardingItems(R.drawable.logo_on_boarding,"becerta 3", "bebas bercerita apa saja 3")
            )
        }
    }
}
