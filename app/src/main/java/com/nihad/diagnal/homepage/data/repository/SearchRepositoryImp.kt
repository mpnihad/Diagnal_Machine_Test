package com.nihad.diagnal.homepage.data.repository

import com.nihad.diagnal.homepage.data.data_source.MovieDao
import com.nihad.diagnal.homepage.domain.model.Movie
import com.nihad.diagnal.homepage.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImp @Inject constructor(
    private  val dao:MovieDao
) :SearchRepository{
    override suspend fun getMovies(searchWord: String): List<Movie> {


        return dao.getMovie(movie = searchWord).map {
            it.toMovieInfo()
        }


    }

}