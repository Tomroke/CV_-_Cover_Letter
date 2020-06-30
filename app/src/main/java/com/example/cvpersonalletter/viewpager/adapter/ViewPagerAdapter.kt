package com.example.cvpersonalletter.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cvpersonalletter.ui.cv.fragments.CVFragment
import com.example.cvpersonalletter.ui.coverletter.CoverLetterFragment
import com.example.cvpersonalletter.ui.contactme.ContactMeFragment

const val CV_INDEX = 0
const val COVER_LETTER_INDEX = 1
const val CONTACT_ME_INDEX = 2

class ViewPagerAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        CV_INDEX to { CVFragment() },
        COVER_LETTER_INDEX to { CoverLetterFragment()},
        CONTACT_ME_INDEX to {ContactMeFragment()}
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}

