package com.irving.cvpersonalletter.ui.contactme.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.irving.cvpersonalletter.database.dataobjects.ContactMeData
import com.irving.cvpersonalletter.databinding.ContactRecyclerItemBinding

class ContactAdapter (): ListAdapter<ContactMeData, RecyclerView.ViewHolder>( ContactDiffCallback() ){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ContactHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as ContactHolder).bind(item)
    }

    class ContactHolder(private val binding: ContactRecyclerItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item: ContactMeData) {
            binding.contactMeData = item

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ContactHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ContactRecyclerItemBinding.inflate( layoutInflater, parent, false )
                return ContactHolder(binding)
            }
        }
    }

    private class ContactDiffCallback : DiffUtil.ItemCallback<ContactMeData>() {
        override fun areItemsTheSame(oldItem: ContactMeData, newItem: ContactMeData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ContactMeData, newItem: ContactMeData): Boolean {
            return oldItem == newItem
        }
    }

}