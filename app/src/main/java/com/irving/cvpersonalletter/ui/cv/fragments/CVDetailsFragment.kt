package com.irving.cvpersonalletter.ui.cv.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.irving.cvpersonalletter.InjectorUtils
import com.irving.cvpersonalletter.ui.cv.viewmodel.CVDetailsViewModel
import com.irving.cvpersonalletter.R
import com.irving.cvpersonalletter.databinding.CvDetailedFragmentBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class CVDetailsFragment : Fragment() {

    private val viewModel: CVDetailsViewModel by viewModels { InjectorUtils.provideCVDetailsViewModelFactory() }

    @ExperimentalCoroutinesApi
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: CvDetailedFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.cv_detailed_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.cvID.observe(viewLifecycleOwner, Observer {
            viewModel.startFetchingSingleCV()
        })

        val arg = CVDetailsFragmentArgs.fromBundle(requireArguments())
        viewModel.setCVID(arg.cvSafeArg)

        return binding.root
    }

}