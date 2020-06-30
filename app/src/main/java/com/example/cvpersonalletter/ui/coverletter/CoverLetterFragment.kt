package com.example.cvpersonalletter.ui.coverletter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cvpersonalletter.R

class CoverLetterFragment : Fragment() {

    private lateinit var coverLetterViewModel: CoverLetterViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        coverLetterViewModel =
                ViewModelProviders.of(this).get(CoverLetterViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_cover_letter, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        coverLetterViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
