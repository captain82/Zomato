package com.captain.ak.zomato.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Restaurants(@SerializedName("restaurants")
                       @Expose
                       val restaurant:Restaurant? = null) {


}