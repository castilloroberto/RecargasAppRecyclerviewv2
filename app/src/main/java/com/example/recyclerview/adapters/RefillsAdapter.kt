package com.example.recyclerview.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.Refill
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.view.*
import kotlin.math.sign

class RefillsAdapter(
    private val context: Context,
    private val dataSource:ArrayList<Refill>
):RecyclerView.Adapter<RefillsAdapter.ViewHolder>() {


    private val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        // val rowView: View = inflater.inflate(R.layout.list_item,parent,false)
        val itemTitle: TextView = itemView.findViewById(R.id.tv_title)
        val itemDescription: TextView = itemView.tv_description
        val itemPrice: TextView = itemView.tv_price
        val itemDuration : TextView = itemView.tv_duration
        init {
            itemView.setOnClickListener{v: View ->
                val position: Int = adapterPosition
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val refill = getItem(position) as Refill

        holder.itemTitle.text = refill.title
        holder.itemDescription.text = refill.description
        holder.itemPrice.text = refill.price.toString()
        holder.itemDuration.text = refill.duration
    }
    private fun getItem(position: Int):Any{
        return dataSource[position]
    }


}