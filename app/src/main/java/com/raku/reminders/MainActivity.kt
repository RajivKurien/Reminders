package com.raku.reminders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.core.app.NotificationManagerCompat
import com.raku.reminders.notifications.createNotificationChannel
import com.raku.reminders.notifications.notificationsBuilder
import com.raku.reminders.ui.homescreen.ReminderScreen
import com.raku.reminders.ui.theme.RemindersTheme
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createNotificationChannel()
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

        NotificationManagerCompat.from(this).let {
            val id = Clock.System.now().nanosecondsOfSecond
            it.notify(
                id,
                notificationsBuilder("Title", "Contents").build()
            )
        }
    }
}

data class ReminderItem(
    val content: String,
    val id: UUID = UUID.randomUUID(),
    val date: LocalDate,
)
