package com.example.barapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.barapp.R
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.header.*
import kotlinx.android.synthetic.main.header.view.*

class MenuActivity : AppCompatActivity() {

    private val icons = arrayListOf(R.drawable.ic_snack, R.drawable.ic_main_course, R.drawable.ic_dessert, R.drawable.ic_cup, R.drawable.ic_alcohol)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = ViewPagerAdapter(this)
        viewPager.offscreenPageLimit = 5
        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            tab.icon = getDrawable(icons[position])
        }.attach()

        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                val progress = (position + positionOffset) / 4
                motionLayout.imageView.scaleX = 1.6f
                motionLayout.imageView.translationX = 250 - progress * 300
            }
        })
    }
}