package com.irving.cvpersonalletter.ui.cv.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.irving.cvpersonalletter.R
import com.irving.cvpersonalletter.database.firebase.CVFireDAO
import com.irving.cvpersonalletter.databinding.FragmentCvBinding
import com.irving.cvpersonalletter.ui.cv.adapters.WorkplaceAdapter
import com.irving.cvpersonalletter.ui.cv.viewmodel.CVViewModelFactory
import com.irving.cvpersonalletter.ui.cv.viewmodel.CVViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

private const val SPANCOUNT: Int = 2

@ExperimentalCoroutinesApi
class CVFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewModelFactory = CVViewModelFactory( dataSource = CVFireDAO())
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(CVViewModel::class.java)
        val layoutManager = GridLayoutManager(context,  SPANCOUNT, RecyclerView.VERTICAL, false)

        val binding: FragmentCvBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_cv, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        val workplaceAdapter = WorkplaceAdapter(WorkplaceAdapter.CVListener {
                id -> viewModel.onCVClicked(id)
        })

        viewModel.navigateToDetailedCV.observe(viewLifecycleOwner, Observer { id ->
            id?.let {
                this.findNavController().navigate(CVFragmentDirections.actionCVFragmentToCVDetailsFragment(id))
                viewModel.onCVClickedNavigated()
            }
        })

        binding.cvRecyclerview.adapter = workplaceAdapter
        binding.cvRecyclerview.layoutManager = layoutManager

        viewModel.allCv.observe(viewLifecycleOwner, Observer {
            it.let {
                workplaceAdapter.submitList(it)
            }
        })

        return binding.root
    }
}