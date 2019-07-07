package com.adrianczuczka.asostask.recipelist

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
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
        loadRecipes()
        recipeListActivitySearchButton.setOnClickListener {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mainMenuSearchIcon -> {
                showSearchMenu(recipeListActivitySearchGroup.visibility == VISIBLE)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSearchMenu(show: Boolean) {
        recipeListActivitySearchGroup.visibility = if (show) VISIBLE else GONE
    }

    private fun loadRecipes() {
        viewModel.recipes.observe(this, Observer { list ->
            recipeListActivityProgressBar.gone()
            recipeRecyclerView makeVisibleAndApply {
                layoutManager = LinearLayoutManager(this@RecipeListActivity)
                adapter = RecipeAdapter(list) {
                }
            }
        })
        viewModel.getRecipes()
    }
}