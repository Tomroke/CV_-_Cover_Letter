package com.irving.cvpersonalletter.ui.contactme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.irving.cvpersonalletter.InjectorUtils
import com.irving.cvpersonalletter.R
import com.irving.cvpersonalletter.databinding.FragmentContactMeBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class ContactMeFragment : Fragment() {

    private val viewModel: ContactMeViewModel by viewModels { InjectorUtils.provideContactMeViewModel() }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        val binding: FragmentContactMeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact_me, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }
}
