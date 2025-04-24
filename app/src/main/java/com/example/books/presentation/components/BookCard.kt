package com.example.books.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.books.R
import com.example.books.presentation.viewmodels.BookViewModel

@Composable
fun BookCard(book: BookViewModel) {
    val (title, author, read, bookType) = book

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = bookType.backgroundColor, shape = RoundedCornerShape(10.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                title,
                style = TextStyle(fontSize = 32.sp, color = bookType.foregroundColor),
                maxLines = 1,
                overflow = TextOverflow.Clip
            )
            if (read) Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = stringResource(id = R.string.delete)
            )
        }
        Text(author, style = TextStyle(color = bookType.foregroundColor))
    }
}