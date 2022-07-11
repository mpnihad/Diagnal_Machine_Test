package com.nihad.diagnal.homepage.data.remote.dto.Movie

import com.nihad.diagnal.R
import com.nihad.diagnal.homepage.domain.model.Movie
import com.nihad.diagnal.homepage.domain.model.Movies

data class MovieDTO(
    val page: Page
)

fun MovieDTO.toMovie(): Movies {
    return Movies(
        moviesTitle = this.page.title,
        movie = this.page.contentItems.content.map { movieContent ->
            Movie(
                movieContent.name,
                getDrawableResourceID(movieContent.posterImage)
            )
        })
}

fun getDrawableResourceID(posterImage: String): Int {

    return when (posterImage) {
        "poster1.jpg" -> R.drawable.img_poster1
        "poster2.jpg" -> R.drawable.img_poster2
        "poster3.jpg" -> R.drawable.img_poster3
        "poster4.jpg" -> R.drawable.img_poster4
        "poster5.jpg" -> R.drawable.img_poster5
        "poster6.jpg" -> R.drawable.img_poster6
        "poster7.jpg" -> R.drawable.img_poster7
        "poster8.jpg" -> R.drawable.img_poster8
        "poster9.jpg" -> R.drawable.img_poster9
        else -> R.drawable.img_placeholder
    }

}
