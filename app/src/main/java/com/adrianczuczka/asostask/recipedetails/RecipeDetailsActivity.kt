package com.adrianczuczka.asostask.recipedetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrianczuczka.asostask.R
import com.adrianczuczka.asostask.models.Recipe
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_recipe_details.*

class RecipeDetailsActivity : AppCompatActivity() {

    private val recipe by lazy { intent.getParcelableExtra<Recipe>(RECIPE_EXTRA_ID) }

    companion object {
        private const val RECIPE_EXTRA_ID = "recipeExtraId"

        fun getStartIntent(context: Context, recipe: Recipe): Intent = Intent(context, RecipeDetailsActivity::class.java).apply {
            putExtra(RECIPE_EXTRA_ID, recipe)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)
        setView(recipe)
    }

    private fun setView(recipe: Recipe) {
        //Glide caches images so doing this instead of getting the bitmap directly from the previous screen does not affect performance
        Glide.with(this)
            .load(recipe.imageURL)
            .into(recipeDetailsActivityImage)
        recipeDetailsActivityTitleTextView.text = recipe.name
        recipeDetailsActivityIngredientsAmountTextView.text = String.format("Ingredients: %d", recipe.ingredients.size)
        recipeDetailsActivityIngredientsRecyclerView.layoutManager = LinearLayoutManager(this)
        recipeDetailsActivityIngredientsRecyclerView.adapter = IngredientAdapter(recipe.ingredients)
        recipeDetailsActivityStepsRecyclerView.layoutManager = LinearLayoutManager(this)
        recipeDetailsActivityStepsRecyclerView.adapter = StepsAdapter(recipe.steps)
    }
}