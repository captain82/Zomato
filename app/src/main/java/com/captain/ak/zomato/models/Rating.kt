package com.captain.ak.zomato.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rating(@SerializedName("aggregate_rating")
                  @Expose
                  val rating:String,
                  @SerializedName("rating_text")
                  @Expose
                  val rating_text:String,
                  @SerializedName("votes")
                  @Expose
                  val votes:String
                  ) {
}