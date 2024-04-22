package com.rohaitas.myyotubeproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rohaitas.myyotubeproject.R

class AdapterRecyclerview : RecyclerView.Adapter<AdapterRecyclerview.Holder>() {

    var list :ArrayList<String>? = null

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    // lets use a function to change layout file at run time


    var flag = false


    // THE BUG THAT i was mentioning is fixed by this function
    // When you change layout manager and file of item
    // you must over ride this if you don't sometime you get problem. All item of rv are not rebuild
    // some of them will use horizontal and some will grid. So this fun must be implemented without writing any code
    // Thanks
    override fun getItemViewType(position: Int): Int {
        if(flag){
            return 1
        }else{
            return 0
        }
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        // now we can also change the layout file
        when(viewType){
            0->{
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_horizontal  , parent, false)
                return Holder(itemView)

            }
            1->{
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_grid  , parent, false)
                return Holder(itemView)

            }
        }

        // default
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid  , parent, false)
        return Holder(itemView)


    }

    override fun getItemCount(): Int {
        return if(list == null) 0 else list!!.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        /// we will skip this
     }

    fun setData(list: ArrayList<String>) {

        this.list = list
        notifyDataSetChanged()

    }
}