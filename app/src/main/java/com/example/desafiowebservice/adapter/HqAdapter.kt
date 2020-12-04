package com.example.desafiowebservice.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiowebservice.R
import com.example.desafiowebservice.enitities.ResultsHq
import com.squareup.picasso.Picasso



class HqAdapter(var listener:OnclickThumbnail): RecyclerView.Adapter<HqAdapter.ResultViewHolder>() {
    var listaThumb = ArrayList<ResultsHq>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent,false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        var item = listaThumb[position]

        Picasso.get().load("${item.thumbnail.path}.${item.thumbnail.extension}").fit().into(holder.thumbHq)
        holder.text.text = "#${position.toString()} "
        Log.i("TAG","${item.thumbnail.path}.${item.thumbnail.extension}")


    }

    override fun getItemCount() = listaThumb.size

    fun addList(list: ArrayList<ResultsHq>){
        listaThumb.addAll(list)
        notifyDataSetChanged()
    }

    inner class ResultViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {

        var thumbHq: ImageView = view.findViewById(R.id.imageHqDetail)
        var text : TextView = view.findViewById(R.id.textTitle)


        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onClickThumbnail(position)
            }
        }

    }


    interface OnclickThumbnail {
        fun onClickThumbnail(position: Int)
    }
}