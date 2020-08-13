package com.irving.cvpersonalletter.ui.contactme.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.irving.cvpersonalletter.InjectorUtils
import com.irving.cvpersonalletter.R
import com.irving.cvpersonalletter.databinding.FragmentContactMeBinding
import com.irving.cvpersonalletter.ui.contactme.adapter.ContactAdapter
import com.irving.cvpersonalletter.ui.contactme.viewmodel.ContactMeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.util.*

@ExperimentalCoroutinesApi
class ContactMeFragment : Fragment() {

    private val viewModel: ContactMeViewModel by viewModels { InjectorUtils.provideContactMeViewModel() }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        val binding: FragmentContactMeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact_me, container, false)

        val contactAdapter = ContactAdapter()

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.contactRecyclerview.adapter = contactAdapter
        binding.contactRecyclerview.layoutManager = layoutManager

        viewModel.contactMe.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            it.let {
                contactAdapter.submitList(it)
            }
        })



        return binding.root
    }
}
