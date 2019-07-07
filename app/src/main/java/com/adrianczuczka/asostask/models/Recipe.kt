package com.adrianczuczka.asostask.models

import com.adrianczuczka.asostask.models.Difficulty.*

data class Recipe(
        val name: String = "",
        val ingredients: List<Ingredient> = emptyList(),
        val steps: List<String> = emptyList(),
        val timers: List<Int> = emptyList(),
        val imageURL: String = "",
        val originalURL: String = ""
) {
    val difficulty: Difficulty by lazy {
        when (steps.size) {
            in 0..2 -> EASY
            in 3..5 -> MEDIUM
            else -> HARD
        }
    }

    val time: Int by lazy { timers.sum() }
}