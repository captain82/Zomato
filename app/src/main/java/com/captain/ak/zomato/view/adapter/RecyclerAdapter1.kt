package com.captain.ak.zomato.view.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.android.databinding.library.baseAdapters.BR
import com.captain.ak.zomato.R
import com.captain.ak.zomato.databinding.CategoriesRecyclerViewBinding
import com.captain.ak.zomato.databinding.RecyclerSingleBinding
import com.captain.ak.zomato.models.Restaurant
import com.captain.ak.zomato.models.Restaurants
import com.squareup.picasso.Picasso

class RecyclerAdapter1(val resList:List<Restaurants>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object
    {
        private const val TYPE_HEADER = 0
        private const val TYPE_DETAIL = 1
    }



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {

        val layoutInflater = LayoutInflater.from(p0.context)

        return when (p1) {
            TYPE_HEADER -> {
                HeaderViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.categories_recycler_view, p0, false))
            }

            TYPE_DETAIL -> {
                DetailViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.recycler_single, p0, false))

            }
            else -> throw IllegalArgumentException()

        }
    }

    override fun getItemCount(): Int {
        return resList.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {

        val element = resList.get(p1)

        when (p0) {
            is HeaderViewHolder -> p0.bind(resList)
            is DetailViewHolder -> p0.bind(element)

        }
    }

    override fun getItemViewType(position: Int): Int {

        return if (position == 0) {
            TYPE_HEADER
        } else {
            TYPE_DETAIL
        }
    }



    inner class HeaderViewHolder(private val binding: CategoriesRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(response: List<Restaurants>) = with(binding) {
        binding.categoryRecyclerView.adapter = categoriesAdapter(response)
        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(binding.categoryRecyclerView.context,LinearLayout.HORIZONTAL,false)


    }
}

    inner class DetailViewHolder(private val binding: RecyclerSingleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(response: Restaurants) = with(binding) {
            binding.setVariable(BR.restaurants,response)
            executePendingBindings()

        }
    }
}

