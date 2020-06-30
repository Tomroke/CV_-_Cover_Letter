package com.example.cvpersonalletter.viewpager.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.cvpersonalletter.R
import com.example.cvpersonalletter.viewpager.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    private val tabIcons: IntArray = intArrayOf(
        R.drawable.ic_cv_employments,
        R.drawable.ic_cover_letter,
        R.drawable.ic_contact_me
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager = view_pager
        viewPagerAdapter =
            ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(tab_layout, viewPager) { tab, position ->
            tab.setIcon(tabIcons[position])
            when(position){
                0 -> { tab.text = getString(R.string.title_cv) }
                1 -> { tab.text = getString(R.string.title_cover_letter) }
                2 -> { tab.text = getString(R.string.title_contact) }
            }
        }.attach()



//        val navController = findNavController(R.id.nav_host_fragment)
//        val navView: BottomNavigationView = findViewById(R.id.nav_view)
//
//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_cv, R.id.navigation_cover_letter, R.id.navigation_contact))
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        navView.setupWithNavController(navController)
    }

}