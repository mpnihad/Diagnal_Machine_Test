package com.nihad.diagnal.homepage.domain.model

import android.graphics.drawable.Drawable
import com.nihad.diagnal.homepage.data.data_source.entity.MovieInfoEntity

data class Movies(
     val moviesTitle: String,
    val movie: List<Movie>,
)

data class Movie(
     val name: String,
     val image: Int,
){
    fun toMovieEntity(id: Int):MovieInfoEntity{
        return MovieInfoEntity(
            name = name,
            image = image,
            id=id
        )
    }
}
