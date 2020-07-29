package com.irving.cvpersonalletter.ui.cv.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.irving.cvpersonalletter.R
import com.irving.cvpersonalletter.database.CVData
import com.irving.cvpersonalletter.databinding.CvRecylcerItemBinding
import com.irving.cvpersonalletter.ui.cv.fragments.CVFragmentDirections

class WorkplaceAdapter(val clickListener: CVListener): ListAdapter<CVData, RecyclerView.ViewHolder>( WorkDiffCallback() ){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder { return from(parent) }

    //TODO REMOVE ONCE BACKEND DATA IS AVAILABLE
    override fun getItemCount() = 10

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //TODO HOCK UP WITH ACTUAL DATA
        val cv = CVData()
        (holder as CVHolder).bind(clickListener, cv)
    }

    class CVHolder (private val binding: CvRecylcerItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(cvClickListener: CVListener, item: CVData) {
            binding.apply {
                cv = item
                clickListener = cvClickListener
                executePendingBindings()
            }
        }
    }

    class CVListener(val clickListener: (cvId: String) -> Unit){
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

    companion object {
        private fun from(parent: ViewGroup): CVHolder {
            return CVHolder( CvRecylcerItemBinding.inflate( LayoutInflater.from(parent.context), parent, false ) )
        }
    }
}