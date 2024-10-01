package com.example.test2

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView

class WordViewHolder(itemView: View?, context: Context) : RecyclerView.ViewHolder(itemView) {
    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var inflater: LayoutInflater

    fun WordViewHolder (itemView: View, context: Context) {
        super.itemView
        inflater = LayoutInflater.from(context)
        button = itemView.findViewById(R.id.button1);
    }
    fun getTextView(): TextView {
        return textView
    }
}