package com.adrianczuczka.asostask.network

import com.adrianczuczka.asostask.models.Recipe
import io.reactivex.Observable
import retrofit2.http.GET

interface RecipeAPI {

    @GET("recipes.json")
    fun getRecipes(): Observable<List<Recipe>>
}