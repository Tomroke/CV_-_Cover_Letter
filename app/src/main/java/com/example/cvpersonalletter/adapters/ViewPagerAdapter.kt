package com.example.cvpersonalletter.adapters

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cvpersonalletter.ui.cv.CVFragment
import com.example.cvpersonalletter.ui.dashboard.DashboardFragment
import com.example.cvpersonalletter.ui.home.HomeFragment

const val CV_INDEX = 0
const val COVER_LETTER_INDEX = 1
const val CONTACT_ME_INDEX = 2
class ViewPagerAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        CV_INDEX to { CVFragment() },
        COVER_LETTER_INDEX to { DashboardFragment()},
        CONTACT_ME_INDEX to {HomeFragment()}
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}

