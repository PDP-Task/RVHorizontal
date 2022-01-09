package com.example.rvhorizontal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rvhorizontal.R
import com.example.rvhorizontal.model.Member

class CustomAdapter(var context: Context, val arrayList: ArrayList<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent ,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = arrayList[position]

        if (holder is CustomViewHolder) {
            holder.textFirst.text = member.firstText
            holder.textSecond.text = member.secondText
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
    class CustomViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textFirst: TextView = itemView.findViewById(R.id.tv_first)
        val textSecond: TextView = itemView.findViewById(R.id.tv_second)
    }
}