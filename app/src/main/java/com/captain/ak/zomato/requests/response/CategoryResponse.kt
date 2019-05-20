package com.captain.ak.zomato.requests.response

import com.captain.ak.zomato.models.Categories
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CategoryResponse {

    @SerializedName("categories")
    @Expose
    private val categories: List<Categories>? = null

    fun getRecipes(): List<Categories>? {
        return categories
    }


    override fun toString(): String {
        return "CategoriesResponse{" +
                "categories="+categories+'}'
    }

}