package com.example.books.presentation.viewmodels

import androidx.compose.ui.graphics.Color
import com.example.books.ui.theme.Purple40
import com.example.books.ui.theme.Purple80
import com.example.books.ui.theme.PurpleGrey40
import com.example.books.ui.theme.PurpleGrey80

data class BookViewModel(
    val id: String = "",
    val title: String = "",
    val author: String = "",
    val read: Boolean = false,
    val bookType: BookType = Fiction
)

sealed class BookType(val backgroundColor: Color, val foregroundColor: Color)
data object Fiction : BookType(Purple80, PurpleGrey40)
data object NonFiction : BookType(Purple40, PurpleGrey80)

val books = mutableListOf(
    BookViewModel(id = "0", title = "1984", author = "George Orwell", read = true),
    BookViewModel(
        id = "1",
        title = "Dom Casmurro",
        author = "Machado de Assis",
        bookType = NonFiction
    ),
    BookViewModel(
        id = "2",
        title = "O Senhor dos Anéis",
        author = "J.R.R. Tolkien",
        read = true,
        bookType = NonFiction
    ),
    BookViewModel(id = "3", title = "A Revolução dos Bichos", author = "George Orwell"),
    BookViewModel(
        id = "4",
        title = "O Pequeno Príncipe",
        author = "Antoine de Saint-Exupéry",
        read = true
    ),
)