package com.raku.reminders.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.raku.reminders.R

const val CHANNEL_ID = "remindersChannelId"
const val CHANNEL_NAME = "remindersChannel"
const val CHANNEL_DESCRIPTION = "remindersChannelDescription"

fun Context.notificationsBuilder(title: String, contents: String): NotificationCompat.Builder =
    NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(R.drawable.abc_vector_test)
        .setContentTitle(title)
        .setContentText(contents)
        .setPriority(NotificationCompat.PRIORITY_LOW)

fun Context.createNotificationChannel() {
    val importance = NotificationManager.IMPORTANCE_DEFAULT
    val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance).apply {
        description = CHANNEL_DESCRIPTION
    }
    val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(channel)
}

