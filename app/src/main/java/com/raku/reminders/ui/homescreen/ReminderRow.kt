package com.raku.reminders.ui.homescreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raku.reminders.ReminderItem
import com.raku.reminders.ui.theme.RemindersTheme
import kotlinx.datetime.LocalDate

@Composable
fun ReminderRow(
    reminder: ReminderItem,
) {
    Row(
        modifier = Modifier
            .height(68.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.width(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(0.6f),
        ) {
            Text(text = reminder.content)
        }
        Spacer(Modifier.weight(1f))
        Row(
        ) {
            Text(text = reminder.date.toString())
        }
        Spacer(Modifier.width(12.dp))

        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 12.dp)
                    .size(24.dp)
            )
        }
    }
    ReminderDivider()
}

@Preview
@Composable
fun ReminderRowPreview() {
    RemindersTheme {
        ReminderRow(
            reminder = ReminderItem(
                content = "Remember to do this. jljlkj ljlkjlkjljlkjljllkjljljljljljljl",
                date = LocalDate(2021, 10, 10)
            )
        )
    }
}

@Composable
fun ReminderDivider(modifier: Modifier = Modifier) {
    Divider(color = MaterialTheme.colors.background, thickness = 1.dp, modifier = modifier)
}
