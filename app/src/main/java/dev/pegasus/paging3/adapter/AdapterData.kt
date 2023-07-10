package dev.pegasus.paging3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dev.pegasus.paging3.R
import dev.pegasus.paging3.databinding.ItemDataBinding
import dev.pegasus.paging3.models.Result

/**
 * @Author: SOHAIB AHMED
 * @Date: 10,July,2023
 * @Accounts
 *      -> https://github.com/epegasus
 *      -> https://stackoverflow.com/users/20440272/sohaib-ahmed
 */

class AdapterData : PagingDataAdapter<Result, AdapterData.DataViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(ItemDataBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_data, parent, false)))
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        getItem(position)?.let {
            holder.binding.root.text = it.content
        }
    }

    inner class DataViewHolder(val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }

        }
    }
}

