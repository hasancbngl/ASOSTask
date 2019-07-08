package com.adrianczuczka.asostask.recipedetails

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adrianczuczka.asostask.R
import com.adrianczuczka.asostask.models.Ingredient
import com.adrianczuczka.asostask.util.inflate
import kotlinx.android.synthetic.main.recipe_ingredients_item.view.*

class IngredientAdapter(var items: List<Ingredient>) : RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder = IngredientViewHolder(parent.inflate(R.layout.recipe_ingredients_item))

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    inner class IngredientViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(ingredient: Ingredient) {
            with(view) {
                recipeIngredientName.text = ingredient.name
                recipeIngredientQuantity.text = ingredient.quantity
            }
        }
    }
}