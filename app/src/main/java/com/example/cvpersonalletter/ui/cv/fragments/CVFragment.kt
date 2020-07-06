package com.example.cvpersonalletter.ui.cv.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cvpersonalletter.R
import com.example.cvpersonalletter.databinding.FragmentCvBinding
import com.example.cvpersonalletter.ui.cv.adapters.WorkplaceAdapter
import com.example.cvpersonalletter.ui.cv.viewmodel.CVViewModel
import kotlinx.android.synthetic.main.fragment_cv.*
import kotlinx.android.synthetic.main.fragment_cv.view.*

private const val SPANCOUNT: Int = 2

class CVFragment : Fragment() {

    private val cvViewModel: CVViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var workplaceAdapter: WorkplaceAdapter
    private lateinit var _layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        cvViewModel = ViewModelProvider(this).get(CVViewModel::class.java)
        _layoutManager = GridLayoutManager(context, SPANCOUNT, RecyclerView.VERTICAL, false)

        val binding: FragmentCvBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_cv, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = cvViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.cv_recyclerview
        workplaceAdapter = WorkplaceAdapter(10)
        recyclerView.apply {
            layoutManager = _layoutManager
            adapter = workplaceAdapter
        }
    }

}
