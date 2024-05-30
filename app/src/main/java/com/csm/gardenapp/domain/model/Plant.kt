package com.csm.gardenapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Plant(
    val name: String,
    val month: String, // в какой месяц нужно сажать
    val dayPeriod: String, // в какие дни нужно сажать
    val imageUrl: String,
    val description: String
) : Parcelable