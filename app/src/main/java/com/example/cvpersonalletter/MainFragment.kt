package com.example.cvpersonalletter

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.cvpersonalletter.adapters.CONTACT_ME_INDEX
import com.example.cvpersonalletter.adapters.COVER_LETTER_INDEX
import com.example.cvpersonalletter.adapters.CV_INDEX
import com.example.cvpersonalletter.adapters.ViewPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerAdapeter: ViewPagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager = view_pager
        viewPagerAdapeter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapeter




//        val navController = findNavController(R.id.nav_host_fragment)
//        val navView: BottomNavigationView = findViewById(R.id.nav_view)
//
//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_cv, R.id.navigation_cover_letter, R.id.navigation_contact))
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        navView.setupWithNavController(navController)
    }

}