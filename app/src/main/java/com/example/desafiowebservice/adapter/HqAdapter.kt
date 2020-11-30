package com.example.desafiowebservice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiowebservice.R
import kotlinx.android.synthetic.main.recycler_item.view.*

class HqAdapter(): RecyclerView.Adapter<HqAdapter.ResultViewHolder>() {
    var listResult = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent,false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        var item = listResult[position]
        holder.textHq.text = item
    }

    override fun getItemCount() = listResult.size

    fun addList(list: ArrayList<String>){
        listResult.addAll(list)
        notifyDataSetChanged()
    }

    class ResultViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textHq: TextView = view.textTitle
        val imageHq: ImageView = view.imageHq
    }
}