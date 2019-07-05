package com.adrianczuczka.asostask.mvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.adrianczuczka.asostask.models.Recipe
import com.adrianczuczka.asostask.network.RecipeRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RecipeViewModelTest {
    @Rule
    @JvmField
    var rule = InstantTaskExecutorRule()

    private val mockRepository: RecipeRepository = mock()
    private val mockObserver: Observer<List<Recipe>> = mock()

    private lateinit var mockViewModel: RecipeViewModel

    @Before
    fun `set up`() {
        mockViewModel = RecipeViewModel(mockRepository)
    }

    @Test
    fun `given the network call returns a list of recipes, when getting the list of recipes, then live data is updated correctly`() {
        val list = listOf(
                Recipe("Apple"),
                Recipe("Banana"),
                Recipe("Pear")
        )
        whenever(mockRepository.getRecipes()).thenReturn(Observable.just(list))
        mockViewModel.recipes.observeForever(mockObserver)
        mockViewModel.getRecipes()
        assert(mockViewModel.recipes.value == list)
    }
}