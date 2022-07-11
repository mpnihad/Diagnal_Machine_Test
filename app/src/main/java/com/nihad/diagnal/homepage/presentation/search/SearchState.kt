package com.nihad.diagnal.homepage.presentation.home_screen

import com.nihad.diagnal.homepage.domain.model.Movie

sealed class SearchState {
    data class SearchWordState(

        val isLoading: Boolean = false,
        val movieList: List<Movie> = emptyList(),
        val error: String = ""
    ) : SearchState()

}
