package com.example.core_ui.tools

fun getPeopleCountText(lookingNumber: Int?): String {
    if (lookingNumber == null) return ""
    val peopleWord = when {
        lookingNumber % 10 == 1 && lookingNumber % 100 != 11 -> "человек"
        lookingNumber % 10 in 2..4 && lookingNumber % 100 !in 12..14 -> "человека"
        else -> "человек"
    }
    return "Сейчас просматривает $lookingNumber $peopleWord"
}

fun getPublishedDateText(publishedDate: String): String {
    val months = listOf(
        "января", "февраля", "марта", "апреля", "мая", "июня",
        "июля", "августа", "сентября", "октября", "ноября", "декабря"
    )
    val parts = publishedDate.split("-")
    val month = parts[1].toInt()
    val day = parts[2].toInt()
    val monthText = months.getOrNull(month - 1) ?: ""
    return "Опубликовано $day $monthText"
}