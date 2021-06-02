package com.raku.reminders

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raku.reminders.ui.homescreen.ReminderRow
import com.raku.reminders.ui.homescreen.ReminderScreen
import com.raku.reminders.ui.theme.RemindersTheme
import kotlinx.datetime.LocalDate
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RemindersTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
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
            }
        }
    }
}




data class ReminderItem(
    val content: String,
    val id: UUID = UUID.randomUUID(),
    val date: LocalDate,
)
