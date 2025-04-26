package com.example.books.utils

sealed class Screen (val route : String) {

    data object  BooksListScreen : Screen("/booksListScreen")
    data object  AddEditBookScreen : Screen("/addEditBookScreen")
}