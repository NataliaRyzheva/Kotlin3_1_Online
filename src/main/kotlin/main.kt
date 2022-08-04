fun main(args: Array<String>) {
    val timeAgo = 65000
    val timeToMin = timeAgo / 60
    val timeToHour = timeToMin / 60
    println(agoToText(timeAgo, timeToMin, timeToHour))
}

fun agoToText(timeAgo: Int, timeToMin: Int, timeToHour: Int): String {
    return when {
        timeAgo < 60 -> "только что"
        (timeAgo > 60 && timeAgo < (60 * 60)) -> when {
            (timeToMin % 10) == 1 && (timeToMin % 100) != 11 -> "$timeToMin минутy назад"
            (timeToMin % 10) >= 5 || ((timeToMin % 100) >= 11 && (timeToMin % 100) <= 14) -> "$timeToMin минут назад"
            else -> "$timeToMin минуты назад"
        }
        timeAgo > (60 * 60) && timeAgo < (24 * 60 * 60) -> when {
            timeToHour == 1 || timeToHour == 21 -> "$timeToHour час назад"
            timeToHour >= 5 && timeToHour <= 20 -> "$timeToHour часов назад"
            else -> "$timeToHour часа назад"
        }
        timeAgo > (24 * (60 * 60)) && timeAgo < (48 * (60 * 60)) -> "сегодня"
        timeAgo > (48 * (60 * 60)) && timeAgo < (72 * (60 * 60)) -> "вчера"
        else -> "давно"
    }
}



