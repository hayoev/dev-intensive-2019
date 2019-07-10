package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {

        var parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        if (firstName == null || firstName == "" || firstName == " ") {
            return null to null
        } else {
            if (lastName == null || lastName == "" || lastName == " ") return firstName to null
            else return firstName to lastName
        }
    }

    fun transliteration(payload: String, divider: String = " "): String {
        var s = ""
        var parts: List<String>? = payload?.split(" ")

        for (name in parts!!.iterator()) {
            if (s != "") s += divider
            for (i in name) {
                s += when (i) {
                    'а' -> 'a'
                    'б' -> 'b'
                    'в' -> 'v'
                    'г' -> 'g'
                    'д' -> 'd'
                    'е' -> 'e'
                    'ё' -> 'e'
                    'ж' -> "zh"
                    'з' -> 'z'
                    'и' -> 'i'
                    'й' -> 'i'
                    'к' -> 'k'
                    'л' -> 'l'
                    'м' -> 'm'
                    'н' -> 'n'
                    'о' -> 'o'
                    'п' -> 'p'
                    'р' -> 'r'
                    'с' -> 's'
                    'т' -> 't'
                    'у' -> 'u'
                    'ф' -> 'f'
                    'х' -> 'h'
                    'ц' -> 'c'
                    'ч' -> "ch"
                    'ш' -> "sh"
                    'щ' -> "sh'"
                    'ы' -> 'i'
                    'э' -> 'e'
                    'ю' -> "yu"
                    'я' -> "ya"
                    'А' -> 'A'
                    'Б' -> 'B'
                    'В' -> 'V'
                    'Г' -> 'G'
                    'Д' -> 'D'
                    'Е' -> 'E'
                    'Ё' -> 'E'
                    'Ж' -> "Zh"
                    'З' -> 'Z'
                    'И' -> 'I'
                    'Й' -> 'I'
                    'К' -> 'K'
                    'Л' -> 'L'
                    'М' -> 'M'
                    'Н' -> 'N'
                    'О' -> 'O'
                    'П' -> 'P'
                    'Р' -> 'R'
                    'С' -> 'S'
                    'Т' -> 'T'
                    'У' -> 'U'
                    'Ф' -> 'F'
                    'Х' -> 'H'
                    'Ц' -> 'C'
                    'Ч' -> "Ch"
                    'Ш' -> "Sh"
                    'Щ' -> "Sh'"
                    'Ы' -> 'I'
                    'Э' -> 'E'
                    'Ю' -> "Yu"
                    'Я' -> "Ya"
                    else -> "$i"
                }
            }
        }
        return s
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var s = ""
        if (firstName != null && firstName != "" && firstName != " ") {
            var init = firstName.get(0).toString().toUpperCase()
            s += when (init) {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                "Y", "Z",
                "А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц",
                "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я" -> init
                else -> ""
            }

        }
        if (lastName != null && lastName != "" && lastName != " ") {
            var init = lastName.get(0).toString().toUpperCase()
            s += when (init) {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
                "Y", "Z",
                "А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц",
                "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я" -> init
                else -> ""
            }
        }
        return when (s) {
            "" -> null
            else -> s
        }
    }
}