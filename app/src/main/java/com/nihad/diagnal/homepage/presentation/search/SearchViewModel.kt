package com.nihad.diagnal.homepage.presentation.home_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nihad.diagnal.core.Resource
import com.nihad.diagnal.homepage.domain.use_case.get_books.GetMovieSearchResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getMovieSearchResultUseCase: GetMovieSearchResultUseCase
):ViewModel() {

    var searchWord: String=""
    private val _state = mutableStateOf(SearchState.SearchWordState())
    val state:State<SearchState> = _state


    fun getMovie(searchWord:String){
        getMovieSearchResultUseCase(searchWord).onEach { result ->
            when(result){
                is Resource.Success ->{
                    _state.value=
                         SearchState.SearchWordState(
                             movieList = result.data?: emptyList()
                         )
                }
                is Resource.Error -> {
                    _state.value=     SearchState.SearchWordState(
                    error=result.message?:"An UnExpected error Occured")
                }
                is Resource.Loading ->{
                    _state.value=     SearchState.SearchWordState(
                        isLoading = true
                    )
                }
             }
        }.launchIn(viewModelScope)
    }
}