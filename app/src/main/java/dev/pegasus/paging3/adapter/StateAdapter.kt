package dev.pegasus.paging3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.pegasus.paging3.R
import dev.pegasus.paging3.databinding.ItemLoadStateBinding

/**
 * @Author: SOHAIB AHMED
 * @Date: 13,July,2023
 * @Accounts
 *      -> https://github.com/epegasus
 *      -> https://stackoverflow.com/users/20440272/sohaib-ahmed
 */

class StateAdapter : LoadStateAdapter<StateAdapter.StateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): StateViewHolder {
        val binding = ItemLoadStateBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_load_state, parent, false))
        return StateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StateViewHolder, loadState: LoadState) {
        holder.binding.progressBarStateAdapter.isVisible = loadState is LoadState.Loading
    }

    inner class StateViewHolder(val binding: ItemLoadStateBinding) : RecyclerView.ViewHolder(binding.root)
}