package com.example.hallapp

data class NoticeData(
    var title: String? = null,
    var image: String? = null,
    var date: String? = null,
    var time: String? = null,
    var key: String? = null
) {
    // Empty constructor for Firebase or other purposes
    constructor() : this(null, null, null, null, null)

    // Additional constructor
    constructor(title: String?, date: String?, time: String?, key: String?) : this(title, null, date, time, key)

    // Custom getter for title if needed
    val getTitle: String?
        get() = title

    // Remove explicit getImage(), getDate(), getTime(), and getKey() methods
}
