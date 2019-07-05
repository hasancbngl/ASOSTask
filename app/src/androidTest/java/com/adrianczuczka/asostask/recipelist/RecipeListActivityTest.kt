package com.adrianczuczka.asostask.recipelist

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.adrianczuczka.asostask.R
import com.adrianczuczka.asostask.matchers.nthChildOf
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test

class RecipeListActivityTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(RecipeListActivity::class.java)

    @Test
    fun given_normal_internet_connection_WHEN_app_is_started_THEN_recipe_list_is_shown() {
        Espresso.onView(nthChildOf(withId(R.id.recipeRecyclerView), 0))
            .check(matches(
                    allOf(
                            hasDescendant(withText("Crock Pot Roast")),
                            hasDescendant(withText("5 ingredients")),
                            hasDescendant(withText("420 minutes"))
                    )))
    }
}