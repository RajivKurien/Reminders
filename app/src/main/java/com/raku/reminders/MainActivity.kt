package com.raku.reminders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.core.app.NotificationManagerCompat
import com.raku.reminders.domain.RemindersViewModel
import com.raku.reminders.domain.RemindersViewModelFactory
import com.raku.reminders.notifications.createNotificationChannel
import com.raku.reminders.notifications.notificationsBuilder
import com.raku.reminders.ui.homescreen.ReminderScreen
import com.raku.reminders.ui.theme.RemindersTheme
import kotlinx.datetime.Clock

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<RemindersViewModel> { RemindersViewModelFactory.create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createNotificationChannel()
        setContent {
            RemindersTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ReminderScreen(
                        items = viewModel.items
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
