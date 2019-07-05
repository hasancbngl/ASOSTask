package com.adrianczuczka.asostask.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adrianczuczka.asostask.models.Recipe
import com.adrianczuczka.asostask.network.RecipeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RecipeViewModel(private val repository: RecipeRepository) : ViewModel() {

    private val disposable = CompositeDisposable()

    val recipes = MutableLiveData<List<Recipe>>()

    fun getRecipes() {
        disposable.add(
                repository.getRecipes()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::onRecipesLoaded)
        )
    }

    private fun onRecipesLoaded(result: List<Recipe>) {
        recipes.value = result
    }
}