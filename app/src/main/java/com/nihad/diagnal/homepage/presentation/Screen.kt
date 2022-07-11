package com.nihad.diagnal.homepage.presentation

sealed class Screen(val route:String){
    object SearchScreen:Screen("search_screen")
    object HomeScreen:Screen("home_screen")

}
