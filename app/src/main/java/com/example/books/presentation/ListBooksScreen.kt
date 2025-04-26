package com.example.books.presentation

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.books.presentation.components.BookCard
import com.example.books.presentation.viewmodels.BookViewModel
import com.example.books.presentation.viewmodels.ListBooksViewModel

@Composable
fun ListBooksScreen(navController: NavController, booksViewModel: ListBooksViewModel) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(booksViewModel.books.value) { book ->
            BookCard(
                book,
                onDeleteClick = { booksViewModel.onDelete(book) }
            )
        }
    }
}
