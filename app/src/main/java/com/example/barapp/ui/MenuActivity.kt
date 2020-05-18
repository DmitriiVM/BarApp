package com.example.barapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.barapp.R
import com.example.barapp.extensions.animateClose
import com.example.barapp.extensions.animateOpen
import com.example.barapp.extensions.dpToPx
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.header.*
import kotlinx.android.synthetic.main.header.view.*

class MenuActivity : AppCompatActivity() {

    private val icons = arrayListOf(
        R.drawable.ic_snack,
        R.drawable.ic_main_course,
        R.drawable.ic_dessert,
        R.drawable.ic_cup,
        R.drawable.ic_alcohol
    )

    private var isMenuOpen = false
    private var lastPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = ViewPagerAdapter(this)
        viewPager.offscreenPageLimit = 5
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.icon = getDrawable(icons[position])
        }.attach()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                val progress = (position + positionOffset) / 4
                motionLayout.imageView.scaleX = 1.6f
                motionLayout.imageView.translationX = 250 - progress * 300
            }
        })

        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val progress = -verticalOffset / appBarLayout.totalScrollRange.toFloat()
            appBarLayout.textViewName.alpha = 0.7.toFloat() - progress

            val offsetDiff = verticalOffset - lastPosition
            lastPosition = verticalOffset
            Log.d("mmm", "MenuActivity :  offsetDiff --  $offsetDiff")
            bottomSheet.translationY = androidx.core.math.MathUtils.clamp(bottomSheet.translationY - offsetDiff.toFloat(), 0f, this.dpToPx(50))
        })

//        recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                Log.d("mmm", "MenuActivity :  onScrolled --  $dy")
//                super.onScrolled(recyclerView, dx, dy)
//            }
//        })





        fabMenu.setOnClickListener {
            if (!isMenuOpen) {
                openMenu()
            } else {
                closeMenu()
            }

        }

        menuScrim.setOnClickListener {
            closeMenu()
        }

    }

    fun openMenu() {
        isMenuOpen = true

        menuScrim.isVisible = true
        menuScrim.animate().alpha(1f).setDuration(700)

        fabExit.animateOpen(0)
        textViewExit.animateOpen(200)

        fabAccount.animateOpen(50)
        textViewAccount.animateOpen(250)

        fabSpecialOffer.animateOpen(100)
        textViewSpecialOffer.animateOpen(300)

        fabBooking.animateOpen(150)
        textViewBooking.animateOpen(350)

        fabContacts.animateOpen(200)
        textViewContacts.animateOpen(400)
    }

    fun closeMenu() {
        isMenuOpen = false
        menuScrim.animate().alpha(0f).setDuration(700).withEndAction { menuScrim.isVisible = false }

        textViewContacts.animateClose(0)
        fabContacts.animateClose(200)
        textViewBooking.animateClose(50)
        fabBooking.animateClose(250)
        textViewSpecialOffer.animateClose(100)
        fabSpecialOffer.animateClose(300)
        textViewAccount.animateClose(150)
        fabAccount.animateClose(350)
        textViewExit.animateClose(200)
        fabExit.animateClose(400)
    }

    override fun onBackPressed() {
        if (isMenuOpen) {
            closeMenu()
        } else {
            super.onBackPressed()
        }
    }
}