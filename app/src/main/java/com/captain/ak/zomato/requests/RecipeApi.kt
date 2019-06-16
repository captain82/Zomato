package com.captain.ak.zomato.requests

import com.captain.ak.zomato.requests.response.CategoryResponse
import com.captain.ak.zomato.requests.response.SearchResponse
import retrofit2.Call
import retrofit2.http.*

public interface RecipeApi {


    //for getting categories
    @Headers("user_key: 327e75c31ca03dbb55cbabe4257acfa9")
    @GET("api/v2.1/categories")
    fun searchCategories():Call<CategoryResponse>


    //for getting all details of restaurant using cityid or lattitude and longitude and collection id
    @Headers("user_key: 327e75c31ca03dbb55cbabe4257acfa9")
    @GET("api/v2.1/search")
    fun searchApi(@Query("lat") queryParameters1: String,
                  @Query("lon")queryParams2: String,
                  @Query("sort")queryParams3: String):Call<SearchResponse>





}