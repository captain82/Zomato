package com.captain.ak.zomato

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.captain.ak.zomato.models.Categories
import com.captain.ak.zomato.models.Category
import com.captain.ak.zomato.viewModels.RecipeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "RecipeActivity"

    private var mRecipeViewModel: RecipeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecipeViewModel = ViewModelProviders.of(this).get(RecipeViewModel::class.java)
        subscribeObservers()
        mRecipeViewModel!!.searchRecipesApi()

    }

    private fun subscribeObservers() {

        Log.i("check" , "working1")
        mRecipeViewModel!!.getRecipe()
        mRecipeViewModel!!.getRecipe()!!.observe(this, Observer<List<Category>> { recipe ->
            if (recipe != null) {
                Log.i("check" , recipe.get(0).categories.category_name)

                if (recipe.equals(mRecipeViewModel!!.getRecipe())) {
                    mRecipeViewModel!!.setRetrievedRecipe(true)
                }
            }
        })
    }
}
