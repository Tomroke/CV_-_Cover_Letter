package com.irving.cvpersonalletter

import android.content.Context
import androidx.fragment.app.Fragment
import com.irving.cvpersonalletter.database.Repository
import com.irving.cvpersonalletter.database.firebase.CVFireDAO
import com.irving.cvpersonalletter.database.room.AppDatabase
import com.irving.cvpersonalletter.ui.cv.viewmodel.CVDetailsViewModelFactory
import com.irving.cvpersonalletter.ui.cv.viewmodel.CVViewModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
object InjectorUtils {

    private fun getRepository (context: Context): Repository{
        return Repository.getInstance(
            CVFireDAO(),
            AppDatabase.getInstance(context.applicationContext!!).cvDao())
    }

    fun provideCVDetailsViewModelFactory(fragment: Fragment): CVDetailsViewModelFactory{
        return CVDetailsViewModelFactory(getRepository(fragment.requireContext()))
    }

    fun provideCVViewModelFactory(fragment: Fragment): CVViewModelFactory {
        return CVViewModelFactory(getRepository(fragment.requireContext()))
    }

}