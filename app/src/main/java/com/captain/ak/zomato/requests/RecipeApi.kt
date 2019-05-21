package com.captain.ak.zomato.requests

import com.captain.ak.zomato.requests.response.CategoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

public interface RecipeApi {


    //categories
    @Headers("user_key: 327e75c31ca03dbb55cbabe4257acfa9")
    @GET("api/v2.1/categories")
    fun searchCategories():Call<CategoryResponse>




}