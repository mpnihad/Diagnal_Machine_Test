package com.nihad.diagnal.homepage.presentation.home_screen.components

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.nihad.diagnal.R
import com.nihad.diagnal.homepage.domain.utils.items
import com.nihad.diagnal.homepage.presentation.Screen
import com.nihad.diagnal.homepage.presentation.home_screen.HomeScreenViewModel

@Composable
fun HomeScreen(
    navController: NavController,

    ) {


    Box(
        modifier = Modifier.fillMaxSize().background(color=Color.Black)
    ) {
        ToolBar(navController)
        GridView()
    }


}

@Composable
fun ToolBar(navController: NavController) {

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
        verticalAlignment = Alignment.CenterVertically


    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "Back")
        }

        Text(text = "Romantic Comedy", style = MaterialTheme.typography.h1)
        IconButton(
            onClick = { navController.navigate(Screen.SearchScreen.route) },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search"
            )
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridView(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val configuration = LocalConfiguration.current
    val movies = viewModel.pager.collectAsLazyPagingItems()
    LazyVerticalGrid(
        modifier = Modifier
            .padding(start = 5.dp, top = 70.dp),
        cells =

        GridCells.Fixed(
            if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                5
            } else {
                3
            }
        ),
        content = {
            items(movies) { movie ->

                Column(
                    modifier = Modifier.padding(bottom = 32.dp, start = 5.dp, end = 5.dp)
                ) {


                    Image(
                        painter = painterResource(id = movie?.image ?: R.drawable.img_placeholder),
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth,

                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    )
                    Spacer(modifier = Modifier.padding(top = 8.dp))
                    Text(movie?.name ?: "", style = MaterialTheme.typography.h2)
                }
            }
        },
    )


}
