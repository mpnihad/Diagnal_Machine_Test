package com.nihad.diagnal.homepage.presentation.home_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.cachedIn
import com.nihad.diagnal.homepage.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getMoviePagerSource: PagingSource<Int, Movie>,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val pager = Pager(
        config = PagingConfig(
            pageSize = 20, //the default content size available on each page
            prefetchDistance = 10, //trigger the new Page when the it reaches the last 10th value of current list
        ),
        pagingSourceFactory = {
            getMoviePagerSource
        },

        ).flow.cachedIn(viewModelScope)
}



