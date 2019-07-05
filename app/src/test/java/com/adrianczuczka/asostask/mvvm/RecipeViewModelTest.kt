package com.adrianczuczka.asostask.mvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.adrianczuczka.asostask.RxImmediateSchedulerRule
import com.adrianczuczka.asostask.models.Recipe
import com.adrianczuczka.asostask.network.RecipeRepository
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Observable
import org.junit.Before
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test

class RecipeViewModelTest {
    @Rule
    @JvmField
    var rule = InstantTaskExecutorRule()

    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }

    private val mockRepository: RecipeRepository = mock()
    private val mockObserver: Observer<List<Recipe>> = mock()

    private lateinit var viewModel: RecipeViewModel

    @Before
    fun `set up`() {
        viewModel = RecipeViewModel(mockRepository)
    }

    @Test
    fun `given the network call returns a list of recipes, when getting the list of recipes, then live data is updated correctly`() {
        val list = listOf(
                Recipe("Apple"),
                Recipe("Banana"),
                Recipe("Pear")
        )
        whenever(mockRepository.getRecipes()).thenReturn(Observable.just(list))
        viewModel.recipes.observeForever(mockObserver)
        viewModel.getRecipes()
        verify(mockObserver).onChanged(list)
    }

    @Test
    fun `given the network call returns an error, when getting `() {
        whenever(mockRepository.getRecipes()).thenReturn(Observable.error(Throwable()))
        viewModel.recipes.observeForever(mockObserver)
        viewModel.getRecipes()
        verify(mockObserver, never()).onChanged(any())
    }
}