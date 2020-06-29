package com.example.cvpersonalletter.ui.cv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.cvpersonalletter.R

private const val ARG_OBJECT = "object"

class CVFragment : Fragment() {

    private lateinit var cvViewModel: CVViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        cvViewModel = ViewModelProvider(this).get(CVViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_cv, container, false)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
//        cvViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
//            val textView: TextView = view.findViewById(android.R.id.text1)
//            textView.text = getInt(ARG_OBJECT).toString()
        }
    }
}
