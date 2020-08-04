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

    private val viewModel: CVDetailsViewModel by viewModels { InjectorUtils.provideCVDetailsViewModelFactory(this) }

    @ExperimentalCoroutinesApi
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: CvDetailedFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.cv_detailed_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        //TODO REMOVE TEST CODE
        viewModel.work.observe(viewLifecycleOwner, Observer {
            if(it != null){
                Log.i("FireDB", "This is the data : $it")
            }
        })

        //TODO REMOVE TEST CODE
        val arg = CVDetailsFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(context, "ID : ${arg.cvSafeArg}", Toast.LENGTH_SHORT).show()

        return binding.root
    }

}