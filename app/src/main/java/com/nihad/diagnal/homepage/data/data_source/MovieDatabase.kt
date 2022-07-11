package com.nihad.diagnal.homepage.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nihad.diagnal.homepage.data.data_source.entity.MovieInfoEntity

@Database(
    entities = [MovieInfoEntity::class],
    version = 2
)
abstract class MovieDatabase:RoomDatabase() {

    abstract  val dao:MovieDao
}