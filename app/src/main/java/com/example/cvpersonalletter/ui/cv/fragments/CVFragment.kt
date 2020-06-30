package com.example.cvpersonalletter.ui.cv.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cvpersonalletter.R
import com.example.cvpersonalletter.databinding.FragmentCvBinding
import com.example.cvpersonalletter.ui.cv.viewmodel.CVViewModel


class CVFragment : Fragment() {

    private lateinit var cvViewModel: CVViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        cvViewModel = ViewModelProvider(this).get(CVViewModel::class.java)
        val binding: FragmentCvBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_cv, container, false)

        binding.lifecycleOwner = this
        binding.viewmodel = cvViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
