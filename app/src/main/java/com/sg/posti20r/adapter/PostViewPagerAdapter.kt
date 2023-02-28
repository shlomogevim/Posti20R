package com.sg.posti20r.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.sg.posti20r.R
import com.sg.posti20r.activities.PostDetailesActivity
import com.sg.posti20r.model.Post
import com.sg.posti20r.tools.DrawPostHelper
import com.sg.posti20r.tools.SHARPREF_ALMA
import com.sg.posti20r.tools.SHARPREF_CURRENT_POST

class PostViewPagerAdapter(private val posts: ArrayList<Post>) : RecyclerView.Adapter<PostViewPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view,parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    inner class ViewHolder(itemView: View,context: Context) : RecyclerView.ViewHolder(itemView) {
        val layout = itemView?.findViewById<ConstraintLayout>(R.id.itemLayout)!!

        init {
            itemView.setOnClickListener {
                val currentPost=posts[adapterPosition]
                val pref = context.getSharedPreferences(SHARPREF_ALMA, Context.MODE_PRIVATE)
                val editor = pref.edit()
                val gson = Gson()
                val json: String = gson.toJson(currentPost)
                editor.putString(SHARPREF_CURRENT_POST, json)
                editor.apply()
                context.startActivity(Intent(context, PostDetailesActivity::class.java))
            }
        }

        fun bindItems(post: Post) {
            DrawPostHelper().drawPost(layout, post)
        }
    }
}





/*class PostViewPagerAdapter(val context: Context,private val posts: ArrayList<Post>) : RecyclerView.Adapter<PostViewPagerAdapter.ViewHolder>() {
    val pref = context.getSharedPreferences(SHARPREF_ALMA, Context.MODE_PRIVATE)

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

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layout = itemView?.findViewById<ConstraintLayout>(R.id.itemLayout)!!
        val image = itemView?.findViewById<ImageView>(R.id.pagerImage)

        fun bindItems(post: Post) {
            DrawPostHelper().drawPost(layout, post)
            image.setOnClickListener {
                val editor = pref.edit()
                val gson = Gson()
                val json: String = gson.toJson(post)
                editor.putString(SHARPREF_CURRENT_POST, json)
                editor.apply()
                context.startActivity(Intent(context, PostDetailesActivity::class.java))
            }
        }
    }
}*/