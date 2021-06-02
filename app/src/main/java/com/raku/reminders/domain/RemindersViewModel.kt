package com.raku.reminders.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.datetime.LocalDate
import java.util.*

class RemindersViewModel(val items: List<ReminderItem>) : ViewModel() {


    // TODO: generate events based on the date-time of reminder items

}

@Suppress("UNCHECKED_CAST")
class RemindersViewModelFactory(val items: List<ReminderItem>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        require(modelClass == RemindersViewModel::class.java) {
            "ViewModel $modelClass cannot be found"
        }
        return RemindersViewModel(items) as T
    }

    companion object {
        fun create(): RemindersViewModelFactory {
            return RemindersViewModelFactory(
                items =
                listOf(
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


data class ReminderItem(
    val content: String,
    val id: UUID = UUID.randomUUID(),
    val date: LocalDate,
)
