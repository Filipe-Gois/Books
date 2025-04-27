package com.example.books.presentation

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.books.presentation.components.BookCard
import com.example.books.presentation.viewmodels.BookViewModel
import com.example.books.presentation.viewmodels.ListBooksViewModel
import com.example.books.utils.Screen

@Composable
fun ListBooksScreen(navController: NavController, booksViewModel: ListBooksViewModel) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("/addEditBookScreen")

                },
            ) {

                Icon(imageVector = Icons.Default.Add, contentDescription = "Add a book")
            }
        }) { contentPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(contentPadding)
                .padding(horizontal = 8.dp)
                .fillMaxSize()
        ) {
            items(booksViewModel.books.value) { book ->
                BookCard(
                    book,
                    modifier = Modifier.clickable { navController.navigate(Screen.AddEditBookScreen.route + "?bookId=${book.id}") },
                    onDeleteClick = { booksViewModel.onDelete(book) }

                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }

}
