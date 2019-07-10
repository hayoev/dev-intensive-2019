package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time
    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }

    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {
    var time = date.time - this.time
    if (time >= 0) {
        return when (time) {
            in 0 * SECOND..1 * SECOND -> "только что"
            in 1 * SECOND..45 * SECOND -> "несколько секунд назад"
            in 45 * SECOND..75 * SECOND -> "минуту назад"
            in 75 * SECOND..45 * MINUTE -> {
                var min = (time / MINUTE).toInt()
                if (time.rem(MINUTE) > 45 * SECOND) min += 1

                TimeUnits.MINUTE.plural(min) + " назад"
                /*when{
                min == 11 || min == 12 || min == 13 || min == 14 -> "$min минут назад"
                (min % 10) == 1 -> "$min минуту назад"
                (min % 10) in 2..4 -> "$min минуты назад"
                (min % 10) in 5..9 -> "$min минут назад"
                (min % 10) == 0 -> "$min минут назад"
                else -> ""
            }*/
            }
            in 45 * MINUTE..75 * MINUTE -> "час назад"
            in 75 * MINUTE..22 * HOUR -> {
                var hour = (time / HOUR).toInt()

                if (time.rem(HOUR) > 45 * MINUTE) hour += 1

                TimeUnits.HOUR.plural(hour) + " назад"
                /*when{
                hour == 11 || hour == 12 || hour == 13 || hour == 14 -> "$hour часов назад"
                (hour % 10) == 1 -> "$hour час назад"
                (hour % 10) in 2..4 -> "$hour часа назад"
                (hour % 10) in 5..9 -> "$hour часов назад"
                (hour % 10) == 0 -> "$hour часов назад"
                else -> ""
            }*/
            }
            in 22 * HOUR..26 * HOUR -> "день назад"
            in 26 * HOUR..360 * DAY -> {
                var day = (time / DAY).toInt()
                if (time.rem(DAY) > 22 * HOUR) day += 1

                TimeUnits.DAY.plural(day) + " назад"
                /*when {
                day == 11 || day == 12 || day == 13 || day == 14 -> "$day дней назад"
                (day % 10) == 1 -> "$day день назад"
                (day % 10) in 2..4 -> "$day дня назад"
                (day % 10) in 5..9 -> "$day дней назад"
                (day % 10) == 0 -> "$day дней назад"
                else -> ""
            }*/
            }
            else -> "более года назад"
        }
    } else {
        time *= (-1)
        return when (time) {
            in 0 * SECOND..1 * SECOND -> "только что"
            in 1 * SECOND..45 * SECOND -> "через несколько секунд"
            in 45 * SECOND..75 * SECOND -> "через минуту"
            in 75 * SECOND..45 * MINUTE -> {
                var min = (time / MINUTE).toInt()
                if (time.rem(MINUTE) > 45 * SECOND) min += 1

                "через " + TimeUnits.MINUTE.plural(min)
            }
            in 45 * MINUTE..75 * MINUTE -> "через час"
            in 75 * MINUTE..22 * HOUR -> {
                var hour = (time / HOUR).toInt()

                if (time.rem(HOUR) > 45 * MINUTE) hour += 1

                "через " + TimeUnits.HOUR.plural(hour)
            }
            in 22 * HOUR..26 * HOUR -> "через день"
            in 26 * HOUR..360 * DAY -> {
                var day = (time / DAY).toInt()
                if (time.rem(DAY) > 22 * HOUR) day += 1

                "через " + TimeUnits.DAY.plural(day)
            }
            else -> "более чем через год"
        }
    }
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun plural(value: Int): String {
        when (this) {
            SECOND -> {
                return when {
                    value == 11 || value == 12 || value == 13 || value == 14 -> "$value секунд"
                    (value % 10) == 1 -> "$value секунду"
                    (value % 10) in 2..4 -> "$value секунды"
                    (value % 10) in 5..9 -> "$value секунд"
                    (value % 10) == 0 -> "$value секунд"
                    else -> ""
                }
            }
            MINUTE -> {
                return when {
                    value == 11 || value == 12 || value == 13 || value == 14 -> "$value минут"
                    (value % 10) == 1 -> "$value минуту"
                    (value % 10) in 2..4 -> "$value минуты"
                    (value % 10) in 5..9 -> "$value минут"
                    (value % 10) == 0 -> "$value минут"
                    else -> ""
                }
            }
            HOUR -> {
                return when {
                    value == 11 || value == 12 || value == 13 || value == 14 -> "$value часов"
                    (value % 10) == 1 -> "$value час"
                    (value % 10) in 2..4 -> "$value часа"
                    (value % 10) in 5..9 -> "$value часов"
                    (value % 10) == 0 -> "$value часов"
                    else -> ""
                }
            }
            DAY -> {
                return when {
                    value == 11 || value == 12 || value == 13 || value == 14 -> "$value дней"
                    (value % 10) == 1 -> "$value день"
                    (value % 10) in 2..4 -> "$value дня"
                    (value % 10) in 5..9 -> "$value дней"
                    (value % 10) == 0 -> "$value дней"
                    else -> ""
                }
            }
        }
    }
}
