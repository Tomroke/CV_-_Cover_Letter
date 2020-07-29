package com.irving.cvpersonalletter.ui.cv.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.irving.cvpersonalletter.ui.cv.viewmodel.CVDetailsViewModel
import com.irving.cvpersonalletter.R
import com.irving.cvpersonalletter.database.firebase.CVFireDAO
import com.irving.cvpersonalletter.databinding.CvDetailedFragmentBinding
import com.irving.cvpersonalletter.ui.cv.viewmodel.CVDetailedViewModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi

class CVDetailsFragment : Fragment() {

    @ExperimentalCoroutinesApi
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val viewModelFactory = CVDetailedViewModelFactory(dataSource = CVFireDAO())
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(CVDetailsViewModel::class.java)

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