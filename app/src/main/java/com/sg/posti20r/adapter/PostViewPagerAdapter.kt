package com.sg.posti20r.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.sg.posti20r.R
import com.sg.posti20r.model.Post
import com.sg.posti20r.tools.DrawPostHelper

class PostViewPagerAdapter(private val posts: ArrayList<Post>) : RecyclerView.Adapter<PostViewPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layout = itemView?.findViewById<ConstraintLayout>(R.id.itemLayout)!!
        fun bindItems(post: Post) {
            DrawPostHelper().drawPost(layout, post)
        }
    }
}
