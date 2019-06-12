package com.captain.ak.zomato.view.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.captain.ak.zomato.R
import com.captain.ak.zomato.databinding.RecyclerSingleBinding
import com.captain.ak.zomato.models.Restaurant
import com.captain.ak.zomato.models.Restaurants
import com.squareup.picasso.Picasso

class RecyclerAdapter(val resList:List<Restaurants>): RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {




    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerViewHolder {

        val binding:RecyclerSingleBinding = DataBindingUtil.inflate(LayoutInflater.from(p0.context),
            R.layout.recycler_single,p0,false)

        return RecyclerViewHolder(binding)

    }

    override fun getItemCount(): Int {

        return resList.size

    }

    override fun onBindViewHolder(p0: RecyclerViewHolder, p1: Int) {

        p0.binding.restaurants =resList.get(p1)
        Picasso.get().load(resList.get(p1).restaurant!!.thumbnail).into(p0.binding.thumbImageView)

    }


    class RecyclerViewHolder(val binding: RecyclerSingleBinding) : RecyclerView.ViewHolder(binding.getRoot())
}