package com.example.cvpersonalletter.ui.cv.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cvpersonalletter.R
import kotlinx.android.synthetic.main.cv_recylcer_item.view.*

class WorkplaceAdapter(private val workPlaces: Int): RecyclerView.Adapter<WorkplaceAdapter.WorkHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cv_recylcer_item, parent, false)
        return WorkHolder(view)
    }

    override fun getItemCount() =  workPlaces

    override fun onBindViewHolder(holder: WorkHolder, position: Int) {
        holder.title.text = "Position $position at"
        holder.employer.text = "employer $position"
    }

    class WorkHolder(view: View): RecyclerView.ViewHolder(view) {
        val image = view.workplace_image
        val title = view.workplace_title_string
        val employer = view.workplace_employer_string
    }

}
