package com.captain.ak.zomato.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Location(@SerializedName("address")
                    @Expose
                    val address:String,
                    @SerializedName("locality")
                    @Expose
                    val locality:String,
                    @SerializedName("city")
                    @Expose
                    val city:String,
                    @SerializedName("zipcode")
                    @Expose
                    val zipcode:String
                    ) {
}