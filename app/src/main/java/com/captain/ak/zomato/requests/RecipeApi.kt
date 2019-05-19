package com.captain.ak.zomato.requests

import com.captain.ak.zomato.requests.response.CategoryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

public interface RecipeApi {


    //categories
    @GET("api/v2.1/categories")
    fun searchCategories(
        @Header("user-key")key:String):Call<CategoryResponse>




}