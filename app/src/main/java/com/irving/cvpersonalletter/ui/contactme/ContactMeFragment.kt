package com.irving.cvpersonalletter.ui.contactme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.irving.cvpersonalletter.R

class ContactMeFragment : Fragment() {

    private lateinit var contactMeViewModel: ContactMeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
//        contactMeViewModel =
//                ViewModelProviders.of(this).get(ContactMeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_contact_me, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        contactMeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }
}
