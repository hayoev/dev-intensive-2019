package ru.skillbranch.devintensive.extensions

fun String.truncate(value: Int = 16): String {
    var s = ""

    var newthis = this.trim()

    var c = 0
    if (value - 1 < newthis.length - 1) c = value - 1 else c = newthis.length - 1

    for (i in 0..c) s += newthis[i]

    if (s.length - newthis.length < 0) {
        if (s[s.length - 1] == ' ') s = s.trim() + "..."
        else s += "..."
    } else s = s.trim()

    return s
}

fun String.stripHtml(): String {
    var s = this
    s = s.replace("&quot;", "").replace("&amp;", "").replace("&lt;", "").replace("&gt;", "")
        .replace("&OElig;", "").replace("&oelig;", "").replace("&Scaron;", "")
        .replace("&scaron;", "").replace("&Yuml;", "").replace("&circ;", "").replace("&tilde;", "")
        .replace("&ensp;", "").replace("&emsp;", "").replace("&thinsp;", "").replace("&zwnj;", "")
        .replace("&zwj;", "").replace("&lrm;", "").replace("&rlm;", "").replace("&ndash;", "")
        .replace("&mdash;", "").replace("&lsquo;", "").replace("&rsquo;", "").replace("&sbquo;", "")
        .replace("&ldquo;", "").replace("&rdquo;", "").replace("&bdquo;", "")
        .replace("&dagger;", "")
        .replace("&Dagger;", "").replace("&permil;", "").replace("&lsaquo;", "")
        .replace("&rsaquo;", "")
        .replace("&euro;", "").replace("&apos;", "")


    var regex = Regex(pattern = "&#[0123456789]{1,4};")
    s = s.replace(regex, "")

    regex =
        Regex(pattern = "<[a-zA-Z0-9' ''=''\''/''\"''\'''.'';'':']+[-]*[a-zA-Z0-9' ''=''''/''\"'''''.'';'':']*>")
    s = s.replace(regex, "")

    regex = Regex(pattern = "\\s+")
    s = s.replace(regex, " ")

    return s
}