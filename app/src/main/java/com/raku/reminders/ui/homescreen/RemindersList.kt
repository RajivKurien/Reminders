package com.raku.reminders.ui.homescreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raku.reminders.domain.ReminderItem
import kotlinx.datetime.LocalDate

@Composable
fun ReminderScreen(
    items: List<ReminderItem>,
) {
    Column {
        Spacer(Modifier.width(12.dp))

        Row(modifier = Modifier.padding(4.dp)) {
            Spacer(Modifier.width(12.dp))
            Text(
                text = "Reminders",
                fontSize = 25.sp,
                style = MaterialTheme.typography.h2,
            )
        }
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(all = 1.dp)
        ) {
            items(items = items) {
                ReminderRow(reminder = it)
            }
        }
    }
}

@Preview
@Composable
fun ReminderScreenPreview() {
    ReminderScreen(
        items = listOf(
            ReminderItem("item 1", date = LocalDate(2021, 7, 10)),
            ReminderItem("rememberall", date = LocalDate(2021, 7, 10)),
            ReminderItem("another person", date = LocalDate(2021, 7, 10)),
            ReminderItem("item 1", date = LocalDate(2021, 7, 10)),
            ReminderItem("item 1", date = LocalDate(2021, 7, 10)),
        )
    )
}