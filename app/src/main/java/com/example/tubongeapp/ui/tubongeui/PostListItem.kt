package com.example.tubongeapp.ui.tubongeui


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tubongeapp.data.Post

@Composable
fun PostListItem(
    post: Post,
    onComment: () -> Unit,
    onLike: () -> Unit
) {
    Card(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                text = post.title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = post.description,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(9.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                PostRowButton(
                    onClick = onComment,
                    icon = Icons.Default.MailOutline,
                    "Comment"
                )
                Spacer(modifier = Modifier.width(9.dp))
                PostRowButton(
                    onClick = onLike,
                    icon = Icons.Default.FavoriteBorder,
                    "Like"
                )
            }
        }
    }

}


@Composable
fun PostRowButton(
    onClick: () -> Unit,
    icon: ImageVector,
    buttonText: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(top = 7.dp, bottom = 7.dp, end = 7.dp)
    ) {
        Icon(imageVector = icon, contentDescription = buttonText)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = buttonText)

    }
}

@Preview(showBackground = true)
@Composable
private fun RowButtom() {
    PostRowButton(onClick = {}, icon = Icons.Default.MailOutline, "Something")
}
@Preview(showBackground = true)
@Composable
private fun PostItemPrev() {
    PostListItem(
        Post("Description", 1, "Title Sample"),
        onComment = {},
        onLike = {}
    )
}