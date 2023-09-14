package com.bignerdranch.android.criminalintent

import java.io.Serializable
import java.util.Date
import java.util.UUID

data class Crime(
    val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean,
    val requestPolice: Boolean

) : Serializable
