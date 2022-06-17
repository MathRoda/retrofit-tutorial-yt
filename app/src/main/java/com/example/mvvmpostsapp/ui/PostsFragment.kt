package com.example.mvvmpostsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mvvmpostsapp.R
import com.example.mvvmpostsapp.databinding.FragmentPostsBinding

class PostsFragment : Fragment() {

    private lateinit var binding: FragmentPostsBinding
    private val viewModel: PostsViewModel by viewModels()
    private lateinit var adapter: PostsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentPostsBinding.inflate(inflater, container, false)

        adapter = PostsAdapter()

        viewModel.getPostsList()
        binding.rvPosts.adapter = adapter
        observerPosts()


        return binding.root
    }

    private fun observerPosts() {
        viewModel.posts.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

}