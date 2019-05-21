package com.captain.ak.zomato.viewModels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.captain.ak.zomato.models.Categories
import com.captain.ak.zomato.models.Category
import com.captain.ak.zomato.repository.RecipeRepository

class RecipeViewModel: ViewModel() {

     var mRecipeRepository = RecipeRepository()
     var mDidRetreiveRecipe:Boolean = false

    fun RecipeViewModel()
    {
        mRecipeRepository = RecipeRepository.getInstance()
        mDidRetreiveRecipe=false
    }

    public fun getRecipe(): LiveData<List<Category>>?
    {
        return mRecipeRepository.getRecipe()
    }

    fun setRetrievedRecipe(retrievedRecipe: Boolean) {
        mDidRetreiveRecipe = retrievedRecipe
    }

    fun didRetrieveRecipe(): Boolean {
        return mDidRetreiveRecipe
    }
    fun searchRecipesApi()
    {
        mRecipeRepository.searchRecipesApi()
    }
}