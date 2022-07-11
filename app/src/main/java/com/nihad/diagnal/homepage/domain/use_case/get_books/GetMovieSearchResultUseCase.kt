package com.nihad.diagnal.homepage.domain.use_case.get_books

import com.nihad.diagnal.core.Resource
import com.nihad.diagnal.homepage.domain.model.Movie
import com.nihad.diagnal.homepage.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieSearchResultUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    //only one functionality


    operator fun invoke(wordSearched:String): Flow<Resource<List<Movie>>> = flow<Resource<List<Movie>>>{

        try {

            emit(Resource.Loading())
            val movies = repository.getMovies(wordSearched)
            emit(Resource.Success(movies))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error Occured"))
        }


    }

}