package com.adrianczuczka.asostask.recipedetails

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adrianczuczka.asostask.R
import com.adrianczuczka.asostask.util.inflate
import kotlinx.android.synthetic.main.recipe_steps_item.view.*

class StepsAdapter(var items: List<String>) : RecyclerView.Adapter<StepsAdapter.StepsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepsViewHolder = StepsViewHolder(parent.inflate(R.layout.recipe_steps_item))

    override fun onBindViewHolder(holder: StepsViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    inner class StepsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(step: String) {
            with(view) {
                recipeStepDescription.text = step
            }
        }
    }
}