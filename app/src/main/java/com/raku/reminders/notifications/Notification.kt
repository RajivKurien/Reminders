package com.raku.reminders.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.raku.reminders.R


val CHANNEL_ID = "remindersChannelId"
val CHANNEL_NAME = "remindersChannel"
val CHANNEL_DESCRIPTION = "remindersChannelDescription"

fun Context.notificationsBuilder(title: String, contents: String): NotificationCompat.Builder =
    NotificationCompat.Builder(this, CHANNEL_ID)
        .setSmallIcon(R.drawable.abc_vector_test)
        .setContentTitle(title)
        .setContentText(contents)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)


fun Context.createNotificationChannel() {
    // Create the NotificationChannel, but only on API 26+ because
    // the NotificationChannel class is new and not in the support library
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance).apply {
            description = CHANNEL_DESCRIPTION
        }
        // Register the channel with the system
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}

