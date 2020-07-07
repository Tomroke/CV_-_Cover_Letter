package com.example.cvpersonalletter.ui.cv.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cvpersonalletter.R
import com.example.cvpersonalletter.databinding.CvRecylcerItemBinding
import com.example.cvpersonalletter.data.Work

class WorkplaceAdapter: ListAdapter<Work, RecyclerView.ViewHolder>(WorkDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return WorkHolder(CvRecylcerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = 10

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val work = getItem(position)
        val work = Work()
        (holder as WorkHolder).bind(work)
    }

    class WorkHolder(private val binding: CvRecylcerItemBinding): RecyclerView.ViewHolder(binding.root) {

        init { binding.setClickListener { binding.root.findNavController().navigate(R.id.action_detailed_look_at_cv_item) } }

        fun bind(item: Work) {
            binding.apply {
                work = item
                executePendingBindings()
            }
        }

    }

    private class WorkDiffCallback : DiffUtil.ItemCallback<Work>() {

        override fun areItemsTheSame(oldItem: Work, newItem: Work): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Work, newItem: Work): Boolean {
            return oldItem == newItem
        }
    }

}

//class WorkplaceAdapter(private val workPlaces: Int): RecyclerView.Adapter<WorkplaceAdapter.WorkHolder>(){
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.cv_recylcer_item, parent, false)
//        return WorkHolder(view)
////        return WorkHolder(CvRecylcerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
//    }
//
//    override fun getItemCount() =  workPlaces
//
//    override fun onBindViewHolder(holder: WorkHolder, position: Int) {
//        holder.title.text = "Position $position at"
//        holder.employer.text = "employer $position"
//    }
//
//    class WorkHolder(view: View): RecyclerView.ViewHolder(view) {
//        val image: ImageView = view.workplace_image
//        val title: TextView = view.workplace_title_string
//        val employer: TextView = view.workplace_employer_string
//
//        init { view.setOnClickListener { view.findNavController().navigate(R.id.action_detailed_look_at_cv_item) } }
//
//    }
//
//}
