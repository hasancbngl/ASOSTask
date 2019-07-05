package com.adrianczuczka.asostask.mvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.adrianczuczka.asostask.models.Recipe
import com.adrianczuczka.asostask.network.RecipeAPI
import com.adrianczuczka.asostask.network.RecipeRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.junit.Before
import org.junit.Rule

class RecipeViewModelTest {
    @Rule
    @JvmField
    var rule = InstantTaskExecutorRule()

    private val mockAPI: RecipeAPI = mock()
    private val mockRepository: RecipeRepository = mock {
        on { api } doReturn mockAPI
    }
    private val mockObserver: Observer<List<Recipe>> = mock()

    private lateinit var mockViewModel: RecipeViewModel

    @Before
    fun `set up`() {
        mockViewModel = RecipeViewModel(mockRepository)
    }
    
}