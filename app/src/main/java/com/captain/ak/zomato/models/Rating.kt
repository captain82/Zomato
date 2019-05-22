package com.captain.ak.zomato.models

import android.os.Parcel
import android.os.Parcelable
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
                  ):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(rating)
        parcel.writeString(rating_text)
        parcel.writeString(votes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Rating> {
        override fun createFromParcel(parcel: Parcel): Rating {
            return Rating(parcel)
        }

        override fun newArray(size: Int): Array<Rating?> {
            return arrayOfNulls(size)
        }
    }
}