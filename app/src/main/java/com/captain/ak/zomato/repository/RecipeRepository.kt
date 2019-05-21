package com.captain.ak.zomato.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.captain.ak.zomato.models.Categories
import com.captain.ak.zomato.models.Category
import com.captain.ak.zomato.requests.RecipeApiClient

class RecipeRepository {

    companion object {
        private var instance:RecipeRepository?  = null

        fun getInstance():RecipeRepository
        {
            if (instance==null)
            {
                instance = RecipeRepository()
            }
            return this.instance!!
        }
    }

    private var mRecipeApiClient = RecipeApiClient()

    private val mRecipes = MediatorLiveData<List<Category>>()

    constructor() {
        this.mRecipeApiClient = RecipeApiClient.getInstance()
        initMediators()
    }

    private fun initMediators() {

        val recipeApiSource = mRecipeApiClient.mRecipes

        recipeApiSource?.let {
            mRecipes.addSource(it, object : Observer<List<Category>> {
                override fun onChanged(t: List<Category>?) {

                    if (t!=null)
                    {
                        mRecipes.value = t
                    }
                    else
                    {

                    }
                }


            })
        }
    }

    public fun getRecipe(): LiveData<List<Category>>? {
        return mRecipeApiClient.getRecipe()
    }

    fun searchRecipesApi()
    {
        mRecipeApiClient.searchRecipesApi()
    }



}