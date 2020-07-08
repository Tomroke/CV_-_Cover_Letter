package com.example.cvpersonalletter.ui.cv.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cvpersonalletter.R
import com.example.cvpersonalletter.databinding.FragmentCvBinding
import com.example.cvpersonalletter.ui.cv.adapters.WorkplaceAdapter
import com.example.cvpersonalletter.ui.cv.viewmodel.CVViewModel

private const val SPANCOUNT: Int = 2

class CVFragment : Fragment() {

    private val viewModel: CVViewModel by viewModels()
    private lateinit var workplaceAdapter: WorkplaceAdapter
    private lateinit var _layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _layoutManager = GridLayoutManager(context, SPANCOUNT, RecyclerView.VERTICAL, false)

        val binding: FragmentCvBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_cv, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = this.viewModel

        workplaceAdapter = WorkplaceAdapter()
        binding.cvRecyclerview.adapter = workplaceAdapter
        binding.cvRecyclerview.layoutManager = _layoutManager

        return binding.root
    }

}
