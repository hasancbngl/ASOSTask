package com.adrianczuczka.asostask.models

import android.os.Parcelable
import com.adrianczuczka.asostask.models.Difficulty.*
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe(
        val name: String = "",
        val ingredients: List<Ingredient> = emptyList(),
        val steps: List<String> = emptyList(),
        val timers: List<Int> = emptyList(),
        val imageURL: String = "",
        val originalURL: String = "",
        val difficulty: Difficulty =
            when (steps.size) {
                in 0..2 -> EASY
                in 3..5 -> MEDIUM
                else -> HARD

            },
        val time: Int = timers.sum()
) : Parcelable