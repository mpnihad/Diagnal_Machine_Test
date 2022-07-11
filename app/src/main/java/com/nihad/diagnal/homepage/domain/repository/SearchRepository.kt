package com.nihad.diagnal.homepage.domain.repository

import com.nihad.diagnal.homepage.domain.model.Movie

interface SearchRepository {

    suspend fun getMovies(searchWord: String): List<Movie>
}