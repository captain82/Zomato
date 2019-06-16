package com.captain.ak.zomato.view.adapter

import android.content.Context
import android.content.Intent
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.captain.ak.zomato.view.DetailActivity
import com.squareup.picasso.Picasso

object BindingAdapter {

    @BindingAdapter("app:setImage")
    @JvmStatic
    fun setImage(view:ImageView,imageUrl:String)
    {
        if(imageUrl.isEmpty())
        {

        }else
        {
            Glide.with(view.context).load(imageUrl).into(view)

        }
    }

}