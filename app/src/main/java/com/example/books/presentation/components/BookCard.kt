package com.example.books.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun BookCard(book: BookViewModel, onDeleteClick: (BookViewModel) -> Unit, modifier: Modifier) {
    val title = book.title
    val author = book.author
    val read = book.read
    val bookType = book.bookType

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = book.bookType.backgroundColor, shape = RoundedCornerShape(10.dp))
            .padding(16.dp)
            .then(modifier)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        title,
                        style = TextStyle(fontSize = 32.sp, color = book.bookType.foregroundColor),
                        maxLines = 1,
                        overflow = TextOverflow.Clip
                    );

                }
                if (book.read) Icon(
                    imageVector = Icons.Filled.Check,
//                    modifier = Modifier.height(70.dp),
                    contentDescription = stringResource(id = R.string.delete)
                )
            }
            Text(author, style = TextStyle(color = book.bookType.foregroundColor))
        }
        IconButton(
            onClick = { onDeleteClick(book) },
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = null,
                tint = Color.White

            )
        }
    }
}