package com.captain.ak.zomato.requests

import com.captain.ak.zomato.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())


    private val retrofit = retrofitBuilder.build()

    val recipeApi: RecipeApi = retrofit.create(RecipeApi::class.java)
}