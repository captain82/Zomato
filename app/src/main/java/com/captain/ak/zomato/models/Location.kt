package com.captain.ak.zomato.models

import android.os.Parcel
import android.os.Parcelable
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
                    ):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(address)
        parcel.writeString(locality)
        parcel.writeString(city)
        parcel.writeString(zipcode)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Location> {
        override fun createFromParcel(parcel: Parcel): Location {
            return Location(parcel)
        }

        override fun newArray(size: Int): Array<Location?> {
            return arrayOfNulls(size)
        }
    }
}