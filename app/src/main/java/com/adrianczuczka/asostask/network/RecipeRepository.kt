package com.adrianczuczka.asostask.network

import com.adrianczuczka.asostask.models.Recipe
import io.reactivex.Observable

class RecipeRepository(private val api: RecipeAPI) {

    fun getRecipes(): Observable<List<Recipe>> = api.getRecipes()
}