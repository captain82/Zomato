package com.captain.ak.zomato.requests

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.captain.ak.zomato.AppExecutors
import com.captain.ak.zomato.models.Category
import com.captain.ak.zomato.models.Restaurants
import com.captain.ak.zomato.requests.response.CategoryResponse
import com.captain.ak.zomato.requests.response.SearchResponse
import com.captain.ak.zomato.utils.Constants
import com.captain.ak.zomato.utils.Constants.Companion.NETWORK_TIMEOUT
import retrofit2.Call
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

    // *************************for getting all categories and categories data******************************************
    var mRecipes: MutableLiveData<List<Category>>? = null
    private var mRetrieveRecipesRunnable: RetreiveRecipesRunnable? = null


    //**************************for getting the restaurants and restaurants detail*************************************
    var mSearch: MutableLiveData<List<Restaurants>>? = null
    private var mRetreiveSearchRunnable: RetreiveSearchRunnable? = null

    constructor() {
        this.mRecipes = MutableLiveData()
        this.mSearch = MutableLiveData()
    }

    fun getRecipe(): LiveData<List<Category>>? {
        return mRecipes
    }

    fun getSearch(): LiveData<List<Restaurants>>? {
        return mSearch
    }

    fun searchRecipesApi() {

        if (mRetrieveRecipesRunnable != null) {
            mRetrieveRecipesRunnable = null
        }
        mRetrieveRecipesRunnable = RetreiveRecipesRunnable()
        val handler = AppExecutors.getInstance().networkIO().submit(mRetrieveRecipesRunnable)

        AppExecutors.getInstance().networkIO().schedule(object : Runnable {
            override fun run() {
                handler.cancel(true)
            } // let the user know its timed out
        }, NETWORK_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)

    }

    fun searchRestaurantsApi() {
        if (mRetreiveSearchRunnable != null) {
            mRetreiveSearchRunnable = null
        }
        mRetreiveSearchRunnable = RetreiveSearchRunnable()
        val handler = AppExecutors.getInstance().networkIO().submit(mRetreiveSearchRunnable)

        AppExecutors.getInstance().networkIO().schedule(object : Runnable {
            override fun run() {
                handler.cancel(true)
            }

        }, NETWORK_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
    }

    inner class RetreiveRecipesRunnable : Runnable {
        internal var cancelRequest: Boolean = false

        constructor() {
            this.cancelRequest = false
        }

        override fun run() {
            try {
                var response = getRecipes().execute()
                if (cancelRequest)
                    return
                if (response.code() == 200) {
                    Log.i("Run", response.body()!!.getRecipes().toString())
                    val list = (response.body()!!.getRecipes())
                    //Log.i("list" , list!!.size.toString())
                    mRecipes!!.postValue(list)
                } else {
                    val error: String = response.errorBody()!!.string()
                    Log.e(TAG, "run: " + error)
                    mRecipes!!.postValue(null)
                }
            } catch (e: IOException) {
                e.printStackTrace()
                mRecipes!!.postValue(null)
            }
        }

        fun getRecipes(): Call<CategoryResponse> {
            return ServiceGenerator.recipeApi.searchCategories()
        }

        private fun cancelRequest() {
            Log.d(TAG, "cancelRequest: canceling the search request.")
            cancelRequest = true
        }


    }

    inner class RetreiveSearchRunnable : Runnable {
        internal var cancelRequest: Boolean = false

        constructor() {
            this.cancelRequest = false
        }

        override fun run() {
            try {
                val queryParams1 = Constants.lattitude
                val queryParams2 = Constants.longitude
                val queryParams3 = "real_distance"

                var response = getSearchRes(queryParams1,queryParams2,queryParams3).execute()
                if (cancelRequest)
                    return
                if (response.code() == 200) {
                    Log.i("Run1", response.body()!!.restaurants!!.get(0).restaurant!!.name)
                    val list = response.body()!!.getSearchRest()
                    mSearch!!.postValue(list)
                } else {
                    val error: String = response.errorBody()!!.string()
                    Log.e(TAG, "run: " + error)
                    mRecipes!!.postValue(null)
                }
            }catch (e:IOException)
            {
                e.printStackTrace()
                mSearch!!.postValue(null)
            }
        }

        fun getSearchRes(queryParams1: String, queryParams2: String, queryParams3: String):Call<SearchResponse>
        {
            return ServiceGenerator.recipeApi.searchApi(queryParams1,queryParams2,queryParams3)
        }

    }


}


