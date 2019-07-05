package com.adrianczuczka.asostask.models

data class Recipe(
        val name: String = "",
        val ingredients: List<Ingredient> = emptyList(),
        val steps: List<String> = emptyList(),
        val timers: List<Int> = emptyList(),
        val imageURL: String = "",
        val originalURL: String = ""
)