package com.irving.cvpersonalletter.viewpager.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.irving.cvpersonalletter.R
import com.irving.cvpersonalletter.viewpager.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
class MainFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    private val tabIcons: IntArray = intArrayOf(
        R.drawable.ic_cv_employments,
        R.drawable.ic_cover_letter,
        R.drawable.ic_contact_me
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i("TEST", "IN VIEWPAGER")
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager = view_pager
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tab_layout, viewPager) { tab, position ->
            tab.setIcon(tabIcons[position])
            when(position){
                0 -> { tab.text = getString(R.string.title_cv) }
                1 -> { tab.text = getString(R.string.title_cover_letter) }
                2 -> { tab.text = getString(R.string.title_contact) }
            }
        }.attach()

    }

}