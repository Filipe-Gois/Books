package com.example.books.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.books.utils.getBooks

class ListBooksViewModel : ViewModel() {

    private val _books: MutableState<List<BookViewModel>> = mutableStateOf(emptyList())
    var books: State<List<BookViewModel>> = _books


    init {
        _books.value = loadBooks()
    }

    private fun loadBooks(): List<BookViewModel> {
        return getBooks();
    }

    fun onDelete(book: BookViewModel) {
        _books.value = _books.value.filter { it != book }
    }

}