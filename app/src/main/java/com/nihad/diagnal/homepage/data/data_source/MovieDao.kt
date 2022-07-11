package com.nihad.diagnal.homepage.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nihad.diagnal.homepage.data.data_source.entity.MovieInfoEntity

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertMovies(
        movie:List<MovieInfoEntity>
    )
    @Query("SELECT * FROM movieinfoentity WHERE name LIKE '%'|| :movie || '%'")
    suspend fun getMovie(movie:String):List<MovieInfoEntity>
}