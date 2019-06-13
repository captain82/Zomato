package com.captain.ak.zomato.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.captain.ak.zomato.R
import com.captain.ak.zomato.models.Restaurants
import com.captain.ak.zomato.view.adapter.RecyclerAdapter
import com.captain.ak.zomato.view.adapter.RecyclerAdapter1
import com.captain.ak.zomato.viewModels.RecipeViewModel
import com.captain.ak.zomato.viewModels.RestaurantsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "RecipeActivity"

    private var mRecipeViewModel:RecipeViewModel? = null

    private var mRestaurantsViewModel:RestaurantsViewModel?= null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // mRecipeViewModel = ViewModelProviders.of(this).get(RecipeViewModel::class.java)
        mRestaurantsViewModel = ViewModelProviders.of(this).get(RestaurantsViewModel::class.java)

        subscribeObservers()
        mRestaurantsViewModel!!.searchRestApi()

        // mRecipeViewModel!!.searchRecipesApi()


    }

    private fun subscribeObservers() {

        Log.i("check" , "working1")
       /* mRecipeViewModel!!.getRecipe()
        mRecipeViewModel!!.getRecipe()!!.observe(this, Observer<List<Category>> { recipe ->
            if (recipe != null) {
                Log.i("check" , recipe.get(0).categories.category_name)

                if (recipe.equals(mRecipeViewModel!!.getRecipe())) {
                    mRecipeViewModel!!.setRetrievedRecipe(true)
                }
            }
        })*/

        mRestaurantsViewModel!!.getRest()
        mRestaurantsViewModel!!.getRest()!!.observe(this, Observer<List<Restaurants>> { t: List<Restaurants>? ->
            if (t!=null)
            {
                Log.i("Check" , t.get(0).restaurant!!.name)

                val adapter = RecyclerAdapter1(t)
                recyclerView.adapter = adapter



                if (t.equals(mRestaurantsViewModel!!.getRest())){
                    mRestaurantsViewModel!!.setRetrievedRest(true)
                }
            }else
            {
                Log.i("Status" , "Failed")
            }
        })
    }
}
