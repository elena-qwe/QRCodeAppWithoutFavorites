package com.example.qrcodeapp.model

import java.sql.Date
import java.sql.Time

data class Favorite(
    val id: Int,
    val name: String,
    var isFavorite: Boolean,
    val description: String,
    val time: Time,
    val date: Date
)
