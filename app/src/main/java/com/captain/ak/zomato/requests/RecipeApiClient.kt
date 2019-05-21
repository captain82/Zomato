package com.captain.ak.zomato.requests

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.captain.ak.zomato.AppExecutors
import com.captain.ak.zomato.models.Categories
import com.captain.ak.zomato.models.Category
import com.captain.ak.zomato.requests.response.CategoryResponse
import com.captain.ak.zomato.utils.Constants
import com.captain.ak.zomato.utils.Constants.Companion.NETWORK_TIMEOUT
import retrofit2.Call
import retrofit2.Response
import java.io.IOException
import java.util.concurrent.TimeUnit

class RecipeApiClient {

    companion object {
        private val TAG = "RecipeApiClient"

        private var instance: RecipeApiClient? = null

        fun getInstance(): RecipeApiClient {
            if (instance == null) {
                instance = RecipeApiClient()
            }
            return this.instance!!
        }

    }

    var mRecipes:MutableLiveData<List<Category>>? = null
    private var mRetrieveRecipesRunnable: RetreiveRecipesRunnable? = null

    constructor() {
        this.mRecipes = MutableLiveData()
    }

    fun getRecipe():LiveData<List<Category>>?
    {
        return mRecipes
    }

    fun searchRecipesApi()
    {

        if(mRetrieveRecipesRunnable!=null)
        {
            mRetrieveRecipesRunnable=null
        }
        mRetrieveRecipesRunnable = RetreiveRecipesRunnable()
        val handler = AppExecutors.
            getInstance().networkIO().submit(mRetrieveRecipesRunnable)

        AppExecutors.getInstance().networkIO().schedule(object : Runnable {
            override fun run() {
                handler.cancel(true)
            } // let the user know its timed out
        }, NETWORK_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)

    }

    inner class RetreiveRecipesRunnable:Runnable
    {
        internal var cancelRequest: Boolean = false

        constructor() {
            this.cancelRequest = false
        }

        override fun run() {
            try {


                var response = getRecipes().execute()
                if (cancelRequest)
                    return
                if (response.code() == 200)
                {
                    Log.i("Run",response.body()!!.getRecipes().toString())
                    val list = (response.body()!!.getRecipes())
                    //Log.i("list" , list!!.size.toString())
                    mRecipes!!.postValue(list)
                }
                else
                {
                    val error:String = response.errorBody()!!.string()
                    Log.e(TAG,"run: "+error)
                    mRecipes!!.postValue(null)
                }
            }catch (e:IOException)
            {
                e.printStackTrace()
                mRecipes!!.postValue(null)
            }
        }

        fun getRecipes():Call<CategoryResponse>
        {
            return ServiceGenerator.
                recipeApi.
                searchCategories()
        }

        private fun cancelRequest() {
            Log.d(TAG, "cancelRequest: canceling the search request.")
            cancelRequest = true
        }


    }


}