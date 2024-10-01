//package com.example.test2
//
//import android.content.Context
//import android.support.v7.widget.RecyclerView
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.TextView
//import androidx.core.content.contentValuesOf
//
//class WordListAdapter : RecyclerView.Adapter<WordViewHolder>() {
//    lateinit var list: MutableList<String>
//    lateinit var inflater: LayoutInflater
//
//    fun WordListAdapter(list: MutableList<String>, context: Context) {
//        this.list = list
//        this.inflater = inflater
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
//        var view = inflater.inflate(R.layout.recycleview_row, parent, false)
//        var viewHolder = WordViewHolder(view)
//        return viewHolder
//    }
//
//    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
//        holder.getTextView().setText(list.get(position))
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//}

package com.example.test2

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class WordListAdapter(
    private val list: MutableList<String>,
    context: Context
) : RecyclerView.Adapter<WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = inflater.inflate(R.layout.recycleview_row, parent, false)
        return WordViewHolder(view)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.getTextView().text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}