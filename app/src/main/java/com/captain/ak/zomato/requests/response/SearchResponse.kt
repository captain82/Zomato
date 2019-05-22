package com.captain.ak.zomato.requests.response

import com.captain.ak.zomato.models.Restaurants
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 class SearchResponse {

    @SerializedName("results_shown")
    @Expose
    private var resultsShown: Int? = null


    @SerializedName("restaurants")
    @Expose
    val restaurants:List<Restaurants>? = null

    fun getSearchRest(): List<Restaurants>? {
        return restaurants
    }

     fun getResultsShown(): Int? {
         return resultsShown
     }



}