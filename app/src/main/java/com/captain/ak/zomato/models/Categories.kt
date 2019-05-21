package com.captain.ak.zomato.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Categories(@SerializedName("id")
                      @Expose
                      val category_id:Int,
                      @SerializedName("name")
                      @Expose
                      val category_name:String):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(category_id)
        parcel.writeString(category_name)
    }

    override fun toString(): String {
        return "categories{"+
                "id='"+category_id+'\''+
                ", name='"+category_name+'}'
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Categories> {
        override fun createFromParcel(parcel: Parcel): Categories {
            return Categories(parcel)
        }

        override fun newArray(size: Int): Array<Categories?> {
            return arrayOfNulls(size)
        }
    }
}