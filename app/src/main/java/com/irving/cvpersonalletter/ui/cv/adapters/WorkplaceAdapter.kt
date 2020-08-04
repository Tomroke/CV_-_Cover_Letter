package com.irving.cvpersonalletter.ui.cv.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.irving.cvpersonalletter.database.CVData
import com.irving.cvpersonalletter.databinding.CvRecylcerItemBinding

class WorkplaceAdapter(private val clickListener: CVListener): ListAdapter<CVData, RecyclerView.ViewHolder>( WorkDiffCallback() ){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CVHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val cvItem = getItem(position)
        (holder as CVHolder).bind(clickListener, cvItem)
    }

    class CVHolder private constructor(val binding: CvRecylcerItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(cvClickListener: CVListener, item: CVData) {
            binding.cv = item
            binding.clickListener = cvClickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): CVHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CvRecylcerItemBinding.inflate( layoutInflater, parent, false )
                return CVHolder(binding)
            }
        }
    }

    class CVListener(val clickListener: (cvId: Int) -> Unit){
        fun onClick(cvData: CVData) = clickListener(cvData.cvId)
    }

    private class WorkDiffCallback : DiffUtil.ItemCallback<CVData>() {
        override fun areItemsTheSame(oldItem: CVData, newItem: CVData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CVData, newItem: CVData): Boolean {
            return oldItem == newItem
        }
    }

}