package com.captain.ak.zomato

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.captain.ak.zomato.models.Categories
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
    }

    private fun subscribeObservers() {

        Log.i("check" , "working1")
        mRecipeViewModel!!.searchRecipesApi()
        mRecipeViewModel!!.getRecipe()
        mRecipeViewModel!!.getRecipe()!!.observe(this, Observer<List<Categories>> { recipe ->
            if (recipe != null) {
                Log.i("check" , recipe.toString())

                if (recipe.equals(mRecipeViewModel!!.getRecipe())) {
                    mRecipeViewModel!!.setRetrievedRecipe(true)
                }
            }
        })
    }
}
