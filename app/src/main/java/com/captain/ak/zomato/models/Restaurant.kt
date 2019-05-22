package com.captain.ak.zomato.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Restaurant(@SerializedName("name")
                      @Expose
                      val name:String,
                      @SerializedName("id")
                      @Expose
                      val res_id:String,
                      @SerializedName("url")
                      @Expose
                      val url:String,
                      @SerializedName("cuisines")
                      @Expose
                      val cuisines:String,
                      @SerializedName("thumb")
                      @Expose
                      val thumbnail:String,
                      @SerializedName("menu_url")
                      @Expose
                      val menu:String,
                      @SerializedName("location")
                      @Expose
                      val location: Location,
                      @SerializedName("user_rating")
                      @Expose
                      val rating:Rating

                      ):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        TODO("location"),
        TODO("rating")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(res_id)
        parcel.writeString(url)
        parcel.writeString(cuisines)
        parcel.writeString(thumbnail)
        parcel.writeString(menu)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Restaurant> {
        override fun createFromParcel(parcel: Parcel): Restaurant {
            return Restaurant(parcel)
        }

        override fun newArray(size: Int): Array<Restaurant?> {
            return arrayOfNulls(size)
        }
    }
}