package com.example.books

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.books.presentation.AddEditBooksScreen
import com.example.books.presentation.ListBooksScreen
import com.example.books.presentation.viewmodels.AddEditBookViewModel
import com.example.books.presentation.viewmodels.ListBooksViewModel
import com.example.books.presentation.viewmodels.books
import com.example.books.ui.theme.BooksTheme
import com.example.books.utils.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BooksTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.BooksListScreen.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(route = Screen.BooksListScreen.route) {
                            val books = viewModel<ListBooksViewModel>()
                            ListBooksScreen(navController, books)
                        }
                        composable(
                            route = Screen.AddEditBookScreen.route + "?bookId={bookId}",
                            arguments = listOf(
                                navArgument(name = "bookId") {
                                    type = NavType.StringType
                                    defaultValue = "-1"
                                })
                        ) { navBackStackEntry ->
                            val bookId = navBackStackEntry.arguments?.getString("bookId") ?: "-1"
                            val viewModel = viewModel<AddEditBookViewModel>() {
                                AddEditBookViewModel(bookId)
                            }
                            AddEditBooksScreen(navController, viewModel)
                        }
                    }

                }
            }
        }
    }
}