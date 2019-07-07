package com.adrianczuczka.asostask.recipelist

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adrianczuczka.asostask.R
import com.adrianczuczka.asostask.models.Recipe
import com.adrianczuczka.asostask.util.inflate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recipe_list_item.view.*

class RecipeAdapter(private val items: List<Recipe>, private val listener: (Recipe) -> Unit) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder = RecipeViewHolder(parent.inflate(R.layout.recipe_list_item))

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    inner class RecipeViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(recipe: Recipe) {
            with(view) {
                setOnClickListener { listener(recipe) }
                recipeTitle.text = recipe.name
                recipeIngredientAmount.text = String.format("%d Ingredients", recipe.ingredients.size)
                recipeTime.text = String.format("%d Minutes", recipe.timers.sum())
                Glide.with(this)
                    .load(recipe.imageURL)
                    .into(recipeImage)
            }
        }
    }
}