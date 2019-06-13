package com.captain.ak.zomato.view.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.databinding.library.baseAdapters.BR
import com.captain.ak.zomato.R
import com.captain.ak.zomato.databinding.CategoriesRecyclerViewBinding
import com.captain.ak.zomato.databinding.RecyclerSingleBinding
import com.captain.ak.zomato.models.Restaurant
import com.captain.ak.zomato.models.Restaurants
import com.squareup.picasso.Picasso

class RecyclerAdapter(val resList:List<Restaurants>): RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    companion object
    {
        const val TYPE_HEAD = 0
        const val TYPE_LIST = 1
    }

    var  binding:ViewDataBinding? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerViewHolder {




         //val binding:RecyclerSingleBinding = DataBindingUtil.inflate(LayoutInflater.from(p0.context),
            //R.layout.recycler_single,p0,false)


        //val binding2:CategoriesRecyclerViewBinding =



        // if(p1== TYPE_LIST)
        //{
            //binding = DataBindingUtil.inflate(LayoutInflater.from(p0.context),
           // R.layout.recycler_single,p0,false)
        //}
        //else
        //{
            //binding = DataBindingUtil.inflate(
               // LayoutInflater.from(p0.context),R.layout.categories_recycler_view,p0,false)
        //}

        return if(p1== TYPE_LIST)
        {
            RecyclerViewHolder(DataBindingUtil.inflate(LayoutInflater.from(p0.context),
                R.layout.recycler_single,p0,false), TYPE_LIST)

        }else
        {
            RecyclerViewHolder(DataBindingUtil.inflate(LayoutInflater.from(p0.context),
                R.layout.categories_recycler_view,p0,false), TYPE_HEAD)
        }

        //return RecyclerViewHolder(binding!!)

    }

    override fun getItemCount(): Int {

        return resList.size

    }

    override fun onBindViewHolder(p0: RecyclerViewHolder, p1: Int) {

        if(p0.equals(TYPE_LIST)) {

            p0.bind(resList.get(p1))
        }
        else if(p0.equals(TYPE_HEAD))
        {


        }




            //p0.binding.restaurants = resList.get(p1)
            //if (resList.get(p1).restaurant!!.thumbnail.isEmpty()) {

            //} else {
                //Picasso.get().load(resList.get(p1).restaurant!!.thumbnail).into()
            //}
        //}
       // else if(p0.equals(TYPE_HEAD))
       // {

      //  }

    }


    class RecyclerViewHolder( var binding: ViewDataBinding ,var viewType:Int) : RecyclerView.ViewHolder(binding.getRoot())
    {


        fun bind(data:Restaurants)
        {
            binding.setVariable(BR.restaurants,data)
            binding.executePendingBindings()
        }
        fun bind1()
        {

        }

        init {
            if (viewType== TYPE_HEAD)
            {
                viewType=0
            }
            else if (viewType== TYPE_LIST)
            {
                viewType=1
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        return if (position != 0) {
            TYPE_LIST
        } else {
            TYPE_HEAD
        }

    }




}