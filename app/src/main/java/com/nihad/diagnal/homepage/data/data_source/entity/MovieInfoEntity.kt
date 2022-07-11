package com.nihad.diagnal.homepage.data.data_source.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nihad.diagnal.homepage.domain.model.Movie
import com.nihad.diagnal.homepage.domain.model.Movies

@Entity
data class MovieInfoEntity (
    val name: String,
    val image: Int,
    @PrimaryKey val id:Int

){
    fun toMovieInfo(): Movie {
        return Movie(
            name = name, image = image

        )
    }
}



