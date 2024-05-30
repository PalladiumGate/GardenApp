package com.csm.gardenapp.domain.util

fun mapMonthRusEng(month: String) : String {
    val months = mapOf(
        "January" to "Январь",
        "February" to "Февраль",
        "March" to "Март",
        "April" to "Апрель",
        "May" to "Май",
        "June" to "Июнь",
        "July" to "Июль",
        "August" to "Август",
        "September" to "Сентябрь",
        "October" to "Октябрь",
        "November" to "Ноябрь",
        "December" to "Декабрь"
    )
    return months[month] ?: ""
}