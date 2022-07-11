package com.nihad.diagnal.homepage.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nihad.diagnal.MovieApplication
import com.nihad.diagnal.core.Resource
import com.nihad.diagnal.homepage.data.data_source.MovieDao
import com.nihad.diagnal.homepage.data.remote.dto.Movie.MovieDTO
import com.nihad.diagnal.homepage.data.remote.dto.Movie.toMovie
import com.nihad.diagnal.homepage.domain.model.Movie
import com.nihad.diagnal.homepage.domain.model.Movies
import java.io.InputStream
import java.nio.charset.Charset
import javax.inject.Inject

class MoviePageSource @Inject constructor(
    private  val dao: MovieDao
) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): PagingSource.LoadResult<Int, Movie> {
        return try {

            val prev = params.key ?: 1
            val result = getListFromJson(page = prev)

            when (result) {
                is Resource.Success -> {
                    dao.insertMovies(result.data!!.movie.mapIndexed {index, movie ->
                        movie.toMovieEntity(prev*10+index)
                    })
                    PagingSource.LoadResult.Page(
                        data = result.data!!.movie,
                        prevKey = if (prev == 1) null else prev - 1,
                        nextKey = if (result.data.movie.size>params.loadSize) null else prev+1
                    )

                }
                is Resource.Error -> {
                    PagingSource.LoadResult.Error(Exception())
                }
                else -> {
                    PagingSource.LoadResult.Error(Exception())

                }
            }

        } catch (e: Exception) {
            PagingSource.LoadResult.Error(e)
        }
    }


    private fun getListFromJson(page: Int): Resource<Movies> {

        try {

            var inputStream: InputStream? = null

            inputStream =
                MovieApplication.sInstance?.applicationContext?.assets?.open("api/CONTENTLISTINGPAGE-PAGE$page.json")
           inputStream?.let {
               val size = inputStream.available()
               val buffer = ByteArray(size)
               inputStream.read(buffer)
               inputStream.close()
               val data = String(buffer, Charset.forName("UTF-8"))
               val jsonType = object : TypeToken<MovieDTO>() {}.type
               val movies = Gson().fromJson<MovieDTO>(data, jsonType)

               return Resource.Success(movies.toMovie())
           }?: kotlin.run {
               return Resource.Error(
                   message =  "Some issue occured while fetching data", data = null

               )
           }

        } catch (e: Exception) {
            return Resource.Error(
                message = e.message ?: "Some issue occured while fetching data", data = null

            )

        }

    }

}