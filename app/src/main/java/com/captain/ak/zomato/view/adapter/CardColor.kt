package com.captain.ak.zomato.view.adapter

import android.content.res.Resources
import android.databinding.BindingAdapter
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import com.captain.ak.zomato.R

object CardColor {

    @BindingAdapter("app:cardColor")
    @JvmStatic
    fun setColor(view:CardView,rating:String)
    {
        val rate = rating.toFloat()
        if (rate>=3) {
            view.setCardBackgroundColor(Color.parseColor("#4CAF50"))
        }
        else if(rate>=2 && rate<3)
        {
            view.setCardBackgroundColor(Color.parseColor("#C8FFA500"))
        }
        else
            view.setCardBackgroundColor(Color.parseColor("#B5F44336"))
    }
}