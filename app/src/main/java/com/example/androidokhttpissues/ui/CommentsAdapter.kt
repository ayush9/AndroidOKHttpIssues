package com.example.androidokhttpissues.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidokhttpissues.R
import com.example.androidokhttpissues.repo.CommentsDataResponse
import java.util.*

class CommentsAdapter(private var commentsList: ArrayList<CommentsDataResponse?>) :
    RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.comments_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = commentsList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var comments: TextView
        fun bind(item: CommentsDataResponse) = with(itemView) {
            comments = itemView.findViewById(R.id.comments)
            comments.text = item.body
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(commentsList[position]!!)
    }
}
