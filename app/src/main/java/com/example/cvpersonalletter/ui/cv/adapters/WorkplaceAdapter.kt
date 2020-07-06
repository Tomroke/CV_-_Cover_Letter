package com.example.cvpersonalletter.ui.cv.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.cvpersonalletter.R
import com.example.cvpersonalletter.ui.cv.fragments.CVDetailsFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.cv_recylcer_item.view.*
import kotlinx.coroutines.withContext

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
        val image: ImageView = view.workplace_image
        val title: TextView = view.workplace_title_string
        val employer: TextView = view.workplace_employer_string

        init {
            view.setOnClickListener {
//                Toast.makeText(view.context, "$layoutPosition", Toast.LENGTH_SHORT).show()
                val direction: CVDetailsFragment
                view.findNavController().navigate(R.id.action_navigation_cv_to_CVDetailsFragment)

            }
        }
    }

}
