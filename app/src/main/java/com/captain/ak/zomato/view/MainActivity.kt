package com.captain.ak.zomato.view

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.view.View
import android.widget.Toast
import com.captain.ak.zomato.R
import com.captain.ak.zomato.models.Restaurants
import com.captain.ak.zomato.utils.Constants
import com.captain.ak.zomato.view.adapter.RecyclerAdapter1
import com.captain.ak.zomato.viewModels.RecipeViewModel
import com.captain.ak.zomato.viewModels.RestaurantsViewModel
import com.google.android.gms.location.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "RecipeActivity"

    private var mRecipeViewModel:RecipeViewModel? = null

    private var mRestaurantsViewModel:RestaurantsViewModel?= null









    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        window.statusBarColor = resources.getColor(R.color.white)

       // mRecipeViewModel = ViewModelProviders.of(this).get(RecipeViewModel::class.java)
        mRestaurantsViewModel = ViewModelProviders.of(this).get(RestaurantsViewModel::class.java)

        var imageList = arrayOf<Int>(R.drawable.newimage1,
                                                R.drawable.newimage2,
            R.drawable.newimage3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9)

        subscribeObservers(imageList)
        mRestaurantsViewModel!!.searchRestApi()

        // mRecipeViewModel!!.searchRecipesApi()

        lunchboxLayout.setOnClickListener{
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)

        }


    }






    private fun subscribeObservers(imageList: Array<Int>) {

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



                val adapter = RecyclerAdapter1(t,imageList,this)
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
