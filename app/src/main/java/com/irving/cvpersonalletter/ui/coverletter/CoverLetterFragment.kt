package com.irving.cvpersonalletter.ui.coverletter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.irving.cvpersonalletter.InjectorUtils
import com.irving.cvpersonalletter.R
import com.irving.cvpersonalletter.databinding.FragmentCoverLetterBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class CoverLetterFragment : Fragment() {

    private val viewModel: CoverLetterViewModel by viewModels { InjectorUtils.provideCoverLetterViewModel() }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        val binding: FragmentCoverLetterBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_cover_letter, container,false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }
}
