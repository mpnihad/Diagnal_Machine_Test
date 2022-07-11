package com.nihad.diagnal.di

import android.app.Application
import androidx.paging.PagingSource
import androidx.room.Room
import com.nihad.diagnal.homepage.data.data_source.MovieDatabase
import com.nihad.diagnal.homepage.data.repository.SearchRepositoryImp
import com.nihad.diagnal.homepage.domain.model.Movie
import com.nihad.diagnal.homepage.domain.repository.SearchRepository
import com.nihad.diagnal.homepage.paging.MoviePageSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {




    @Provides
    @Singleton
    fun provideSearchRepository(
        db:MovieDatabase
    ):SearchRepository{
        return SearchRepositoryImp(db.dao)
    }

    @Provides
    @Singleton
    fun provideMovieDatabase(app:Application):MovieDatabase{
       return Room.databaseBuilder(app,MovieDatabase::class.java,"movie_db").fallbackToDestructiveMigration().build()
    }


    @Provides
    @Singleton
    fun providePagingRepository(
        db:MovieDatabase
    ): PagingSource<Int, Movie> {
        return MoviePageSource(db.dao)
    }

}