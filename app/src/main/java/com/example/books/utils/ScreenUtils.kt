package com.example.books.utils
import kotlinx.serialization.Serializable
@Serializable
object BooksListScreen

@Serializable
data class AddEditBooksScreen(val bookId: Int)