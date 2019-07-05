package com.adrianczuczka.asostask.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adrianczuczka.asostask.network.RecipeRepository

class RecipeViewModelFactory(private val repository: RecipeRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RecipeViewModel(repository) as T
    }
}