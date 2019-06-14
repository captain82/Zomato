package com.captain.ak.zomato.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.captain.ak.zomato.R
import com.squareup.picasso.Picasso

class categoriesAdapter(val imageList: Array<Int>): RecyclerView.Adapter<categoriesAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CategoryViewHolder {

        val view = LayoutInflater.from(p0.context).inflate(R.layout.categories_single,p0,false)

        return CategoryViewHolder(view)


    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(p0: CategoryViewHolder, p1: Int) {

        Picasso.get().load(imageList[p1]).into(p0.image)


    }

    class CategoryViewHolder(val view:View):RecyclerView.ViewHolder(view)
    {

        var image = view.findViewById<ImageView>(R.id.image)

    }
}