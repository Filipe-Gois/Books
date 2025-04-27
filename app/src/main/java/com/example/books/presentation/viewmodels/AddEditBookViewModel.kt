package com.example.books.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.books.utils.getBooks

class AddEditBookViewModel(bookId: String = "-1") : ViewModel() {

    private val _book = mutableStateOf(BookViewModel())
    val book = _book

    private fun findBook(id: String) {
        _book.value = getBooks().find { it.id == id } ?: BookViewModel()

    }

    init {
        findBook(bookId);
    }


}