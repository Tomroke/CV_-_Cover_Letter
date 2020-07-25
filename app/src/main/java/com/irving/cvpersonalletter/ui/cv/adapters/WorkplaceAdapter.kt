package com.irving.cvpersonalletter.ui.cv.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.irving.cvpersonalletter.R
import com.irving.cvpersonalletter.database.CVData
import com.irving.cvpersonalletter.databinding.CvRecylcerItemBinding
import com.irving.cvpersonalletter.ui.cv.fragments.CVDetailsFragment

class WorkplaceAdapter: ListAdapter<CVData, RecyclerView.ViewHolder>(
    WorkDiffCallback()
){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CVHolder(
            CvRecylcerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    //TODO REMOVE ONCE BACKEND DATA IS AVAILABLE
    override fun getItemCount() = 10

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val work = getItem(position)
        val work = CVData("5")
        (holder as CVHolder).bind(work)
    }

    class CVHolder(private val binding: CvRecylcerItemBinding): RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener {//R.id.action_detailed_look_at_cv_item
                binding.root.findNavController().navigate(R.id.action_detailed_look_at_cv_item)
            }
        }

        fun bind(item: CVData) {
            binding.apply {
                work = item
                executePendingBindings()
            }
        }
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