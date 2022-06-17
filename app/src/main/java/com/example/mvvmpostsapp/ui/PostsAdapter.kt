package com.example.mvvmpostsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpostsapp.databinding.PostsItemBinding
import com.example.mvvmpostsapp.network.Posts

class PostsAdapter:
ListAdapter<Posts, PostsAdapter.ViewHolder>(DiffCallback){

    class ViewHolder(
        var binding: PostsItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(posts: Posts) {
            binding.tvTitle.text = posts.name
            binding.tvEmail.text = posts.email
            binding.tvBody.text = posts.body

            binding.executePendingBindings()
        }
    }

    object DiffCallback: DiffUtil.ItemCallback<Posts>() {
        override fun areItemsTheSame(oldItem: Posts, newItem: Posts): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Posts, newItem: Posts): Boolean {
            return oldItem ==newItem
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            PostsItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }

}