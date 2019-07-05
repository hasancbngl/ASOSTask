package com.adrianczuczka.asostask.recipelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.adrianczuczka.asostask.R
import com.adrianczuczka.asostask.mvvm.RecipeViewModel
import com.adrianczuczka.asostask.mvvm.RecipeViewModelFactory
import com.adrianczuczka.asostask.network.RecipeClient
import com.adrianczuczka.asostask.util.gone
import com.adrianczuczka.asostask.util.makeVisibleAndApply
import kotlinx.android.synthetic.main.activity_recipe_list.*

class RecipeListActivity : AppCompatActivity() {

    private val viewModel: RecipeViewModel by lazy { ViewModelProviders.of(this, RecipeViewModelFactory(RecipeClient.repository))[RecipeViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)
    }

    fun loadRecipes() {
        viewModel.recipes.observe(this, Observer {
            recipeListActivityProgressBar.gone()
            recipeRecyclerView makeVisibleAndApply {

            }
        })
    }
}