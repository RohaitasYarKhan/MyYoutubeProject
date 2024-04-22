package com.rohaitas.myyotubeproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rohaitas.myyotubeproject.R
import com.rohaitas.myyotubeproject.database.User
import com.rohaitas.myyotubeproject.databinding.ItemUsersBinding

class AdapterUsers : RecyclerView.Adapter<AdapterUsers.Holder>() {

    var list :List<User>? = null

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        // default
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_users  , parent, false)
        return Holder(itemView)


    }

    override fun getItemCount(): Int {
        return if(list == null) 0 else list!!.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val binding = ItemUsersBinding.bind(holder.itemView)
        binding.tvUser.text = list?.get(position)!!.name

    }

    fun setData(list: List<User>) {

        this.list = list
        notifyDataSetChanged()

    }
}