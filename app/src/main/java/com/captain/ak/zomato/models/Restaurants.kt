package com.captain.ak.zomato.models

import android.databinding.BaseObservable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Restaurants(@SerializedName("restaurant")
                       @Expose
                       val restaurant:Restaurant? = null): BaseObservable() {




}