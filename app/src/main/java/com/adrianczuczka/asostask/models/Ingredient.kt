package com.adrianczuczka.asostask.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ingredient(
        val quantity: String = "",
        val name: String = "",
        val type: String = ""
) : Parcelable