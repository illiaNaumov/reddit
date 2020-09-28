package com.naumov.reddit.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.naumov.reddit.R
import com.naumov.reddit.presentation.util.toggleVisibility

class PostLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<PostLoadStateAdapter.LoadStateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_load_state, parent, false)
        return LoadStateViewHolder(view, retry)
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    class LoadStateViewHolder(view: View, retry: () -> Unit) : RecyclerView.ViewHolder(view) {

        private val progressBar: ProgressBar = view.findViewById(R.id.progressView)
        private val retry: Button = view.findViewById<Button>(R.id.retryView)
            .also { it.setOnClickListener { retry() } }


        fun bind(loadState: LoadState) {
            progressBar.toggleVisibility(loadState is LoadState.Loading)
            retry.toggleVisibility(loadState is LoadState.Error)
        }
    }
}