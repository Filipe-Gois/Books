package com.example.books.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.books.presentation.viewmodels.AddEditBookViewModel

@Composable
fun AddEditBooksScreen(navController: NavHostController, viewModel: AddEditBookViewModel) {

    Scaffold { p ->
        Column(
            modifier = Modifier
                .padding(p)
                .fillMaxSize()
        ) {
            Text("oioioioi")

        }
    }
}