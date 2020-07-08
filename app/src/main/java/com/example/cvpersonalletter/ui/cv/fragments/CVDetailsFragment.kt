package com.example.cvpersonalletter.ui.cv.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.cvpersonalletter.ui.cv.viewmodel.CVDetailsViewModel
import com.example.cvpersonalletter.R
import com.example.cvpersonalletter.databinding.CvDetailedFragmentBinding

class CVDetailsFragment : Fragment() {

    private val viewModel: CVDetailsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: CvDetailedFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.cv_detailed_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        return binding.root
    }

}