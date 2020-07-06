package com.example.navigationcompsampleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PetsAdapter(var data: ArrayList<Pet>, private val onClick: OnPetClick) : RecyclerView.Adapter<PetsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mName: TextView = itemView.findViewById(R.id.name)
        val mValue: TextView = itemView.findViewById(R.id.value)
        val mContainer: RelativeLayout = itemView.findViewById(R.id.item_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.mName.text = data[position].name
        viewHolder.mValue.text = data[position].breed
        viewHolder.mContainer.setOnClickListener { onClick.onPetClick(data[position]) }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}