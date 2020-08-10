package com.irving.cvpersonalletter

import com.irving.cvpersonalletter.database.Repository
import com.irving.cvpersonalletter.database.CVFireDAO
import com.irving.cvpersonalletter.ui.contactme.ContactMeViewModelFactory
import com.irving.cvpersonalletter.ui.coverletter.CoverLetterViewModelFactory
import com.irving.cvpersonalletter.ui.cv.viewmodel.CVDetailsViewModelFactory
import com.irving.cvpersonalletter.ui.cv.viewmodel.CVViewModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
object InjectorUtils {

    private fun getRepository (): Repository{
        return Repository.getInstance(
            CVFireDAO()
        )
    }

    fun provideCVDetailsViewModelFactory(): CVDetailsViewModelFactory{
        return CVDetailsViewModelFactory(getRepository())
    }

    fun provideCVViewModelFactory(): CVViewModelFactory {
        return CVViewModelFactory(getRepository())
    }

    fun provideContactMeViewModel(): ContactMeViewModelFactory {
        return ContactMeViewModelFactory(getRepository())
    }

    fun providCoverLetterViewModel(): CoverLetterViewModelFactory {
        return CoverLetterViewModelFactory(getRepository())
    }

}