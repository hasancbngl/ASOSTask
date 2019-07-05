package com.adrianczuczka.asostask.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adrianczuczka.asostask.models.Recipe
import com.adrianczuczka.asostask.network.RecipeRepository

class RecipeViewModel(private val repository: RecipeRepository) : ViewModel() {

    val recipes = MutableLiveData<List<Recipe>>()

    fun getRecipes() {

    }
}