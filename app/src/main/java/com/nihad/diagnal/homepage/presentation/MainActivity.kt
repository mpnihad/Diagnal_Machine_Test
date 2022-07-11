package com.nihad.diagnal.homepage.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nihad.diagnal.homepage.presentation.search.components.SearchScreen
import com.nihad.diagnal.homepage.presentation.home_screen.components.HomeScreen
import com.plcoding.cleanarchitecturenoteapp.ui.theme.CleanArchitectureNoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{

            CleanArchitectureNoteAppTheme {
                androidx.compose.material.Surface(color= MaterialTheme.colors.background) {


                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ) {

                        composable(
                            route = Screen.HomeScreen.route
                        ) {
                            HomeScreen(navController = navController)
                        }
                        composable(
                            route = Screen.SearchScreen.route
                        ) {
                            SearchScreen(navController = navController)
                        }

                    }
                }
            }
        }
    }
}