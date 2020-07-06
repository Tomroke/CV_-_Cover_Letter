package com.example.cvpersonalletter.ui.cv.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.cvpersonalletter.ui.cv.viewmodel.CVDetailsViewModel
import com.example.cvpersonalletter.R
import com.example.cvpersonalletter.ui.cv.viewmodel.CVViewModel

class CVDetailsFragment : Fragment() {

    private val viewModel: CVDetailsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.cv_detailed_fragment, container, false)
    }


}