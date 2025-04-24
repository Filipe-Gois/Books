package com.example.books.presentation

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.books.presentation.components.BookCard
import com.example.books.presentation.viewmodels.books

@Composable
fun ListBooksScreen(innerPadding: PaddingValues) {

    LazyColumn(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        books.forEach { book ->
            item {
                BookCard(book)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

}