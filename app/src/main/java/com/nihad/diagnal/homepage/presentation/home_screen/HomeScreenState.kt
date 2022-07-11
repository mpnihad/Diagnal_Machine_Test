package com.nihad.diagnal.homepage.presentation.home_screen

import com.nihad.diagnal.homepage.domain.model.Movies

data class HomeScreenState(
    val isLoading: Boolean = false,
    val companyList: List<Movies> = emptyList(),
    val error: String = ""
)
