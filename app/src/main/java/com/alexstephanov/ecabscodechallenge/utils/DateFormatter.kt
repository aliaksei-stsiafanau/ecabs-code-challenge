package com.alexstephanov.ecabscodechallenge.utils

import android.icu.util.Calendar
import android.text.format.DateUtils
import java.util.*
import javax.inject.Inject

interface DateFormatter {
    fun formatDate(date: Date) : String
}

class DateFormatterImpl @Inject constructor() : DateFormatter {
    override fun formatDate(date: Date): String = DateUtils.getRelativeTimeSpanString(
        date.time,
        Calendar.getInstance().timeInMillis,
        DateUtils.MINUTE_IN_MILLIS
    ).toString()
}