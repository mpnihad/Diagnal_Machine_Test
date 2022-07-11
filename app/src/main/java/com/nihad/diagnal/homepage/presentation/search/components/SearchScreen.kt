package com.nihad.diagnal.homepage.presentation.search.components

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.nihad.diagnal.R
import com.nihad.diagnal.homepage.domain.utils.ColorsTransformation
import com.nihad.diagnal.homepage.presentation.home_screen.SearchState.SearchWordState
import com.nihad.diagnal.homepage.presentation.home_screen.SearchViewModel

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        ToolBarSearch(navController, viewModel)
        Spacer(modifier=Modifier.padding(top=8.dp))
        GridViewSearch()
    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridViewSearch(
    viewModel: SearchViewModel = hiltViewModel()
) {
    val configuration = LocalConfiguration.current
    val movieState = viewModel.state.value

    when (movieState) {
        is SearchWordState -> {

            if (movieState.isLoading) {
                CircularProgressIndicator()
            } else if (movieState.movieList.isNullOrEmpty()) {
                Text(
                    "Search result not found",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            } else if (movieState.movieList.isNotEmpty()) {
                LazyVerticalGrid(
                    modifier = Modifier
                        .padding(start = 5.dp, bottom = 70.dp),
                    cells =

                    GridCells.Fixed(
                        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                            5
                        } else {
                            3
                        }
                    ),
                    content = {
                        items(movieState.movieList) { movie ->

                            Column(
                                modifier = Modifier.padding(
                                    bottom = 32.dp,
                                    start = 5.dp,
                                    end = 5.dp
                                )
                            ) {


                                Image(
                                    painter = painterResource(
                                        id = movie?.image ?: R.drawable.img_placeholder
                                    ),
                                    contentDescription = "",
                                    contentScale = ContentScale.FillWidth,

                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                )
                                Spacer(modifier = Modifier.padding(top = 8.dp))

//                                val annotatedLinkString = buildAnnotatedString {
//                                    val words: List<String> = (movie.name).split(viewModel.searchWord)// splits by whitespace
//
//
//
//                                    val builder = AnnotatedString.Builder()
//                                    words.forEachIndexed {index,word->
//
//                                        builder.withStyle(style = SpanStyle(color = Color.White)) {
//                                            append("$word")
//                                        }
//                                        if(index!=(words.size-1)) {
//                                            builder.withStyle(style = SpanStyle(color = Color.Yellow)) {
//                                                append(viewModel.searchWord)
//                                            }
//                                        }
//                                    }
//                                }

                                Text(movie.name?:"", style = MaterialTheme.typography.h2)
                            }
                        }
                    },
                )
            } else if (movieState.error.isNotBlank()) {
                Text(
                    movieState.error,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )

            }
        }


    }


}

@Composable
fun ToolBarSearch(navController: NavController, viewModel: SearchViewModel) {

    Column {
        Row(
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black,
                            Color.Black.copy(alpha = .75f)
                        ), startY = 0.1f
                    )
                ),
            verticalAlignment = Alignment.Bottom


        ) {
//        IconButton(onClick = { navController.popBackStack() }) {
//            Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "Back")
//        }

            var inputvalue by remember { mutableStateOf(TextFieldValue("")) }


            TextField(
                value = inputvalue,

                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    inputvalue = it
                    viewModel.searchWord=it.text
                    if (it.text.length >= 3) {
                        viewModel.getMovie(it.text)
                    }
                },
                maxLines = 1,

                placeholder = {
                    Text(
                        "Search a movie",
                        style = MaterialTheme.typography.h2.copy(color = Color.White)

                    )
                },
                textStyle = MaterialTheme.typography.h2,

                trailingIcon = {

                    IconButton(onClick = { navController.popBackStack() }) {


                        Icon(

                            painter = painterResource(id = R.drawable.ic_search_cancel),
                            tint = Color.White,

                            contentDescription = "Close"
                        )
                    }

                },

                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.onPrimary,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),

                )

        }
        Divider(color=Color.White, modifier = Modifier.padding(horizontal = 5.dp))
    }

}


//getMovie