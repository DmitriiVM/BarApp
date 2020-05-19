package com.example.barapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.math.MathUtils
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.example.barapp.R
import com.example.barapp.extensions.ANIMATION_DURATION
import com.example.barapp.extensions.animateClose
import com.example.barapp.extensions.animateOpen
import com.example.barapp.extensions.dpToPx
import com.example.barapp.util.getIcons
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.app_menu.*
import kotlinx.android.synthetic.main.app_menu.view.*
import kotlinx.android.synthetic.main.header.*
import kotlinx.android.synthetic.main.header.view.*
import kotlinx.android.synthetic.main.menu_item.*

class MenuActivity : AppCompatActivity() {

    private var isMenuOpen = false
    private var lastPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewPager()
        initListeners()
    }

    private fun initViewPager() {
        viewPager.adapter = ViewPagerAdapter(this)
        viewPager.offscreenPageLimit = 5
        val icons = getIcons()

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.icon = getDrawable(icons[position])
        }.attach()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int, positionOffset: Float, positionOffsetPixels: Int
            ) {
                val progress = (position + positionOffset) / PAGE_NUMBERS
                header.imageViewHeader.scaleX = IMAGE_SCALE_FACTOR
                header.imageViewHeader.translationX =
                    IMAGE_INITIAL_TRANSLATION - progress * IMAGE_TRANSLATION_OFFSET_X
            }
        })
    }

    private fun initListeners() {
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            animateTitle(verticalOffset, appBarLayout)
            animateBottomSheet(verticalOffset)
        })

        fabMenu.setOnClickListener {
            if (!isMenuOpen) openMenu() else closeMenu()
        }

        menuScrim.setOnClickListener { closeMenu() }
    }

    private fun animateTitle(
        verticalOffset: Int,
        appBarLayout: AppBarLayout
    ) {
        val progress = -verticalOffset / appBarLayout.totalScrollRange.toFloat()
        appBarLayout.textViewName.alpha = 1 - progress
    }

    private fun animateBottomSheet(verticalOffset: Int) {
        val offsetDiff = verticalOffset - lastPosition
        lastPosition = verticalOffset
        bottomSheet.translationY = MathUtils.clamp(
            bottomSheet.translationY - offsetDiff.toFloat(),
            BOTTOMSHEET_INITIAL_TRANSLATION,
            resources.getDimension(R.dimen.bottomsheet_peek_height)
        )
    }

    private fun openMenu() {
        isMenuOpen = true

        menuScrim.isVisible = true
        menuScrim.animate().alpha(ALPHA_FINAL_VALUE)
            .setDuration(8 * ANIMATION_DELAY + ANIMATION_DURATION)

        fabExit.animateOpen(ANIMATION_INITIAL_DELAY)
        textViewExit.animateOpen(4 * ANIMATION_DELAY)
        fabAccount.animateOpen(ANIMATION_DELAY)
        textViewAccount.animateOpen(5 * ANIMATION_DELAY)
        fabSpecialOffer.animateOpen(2 * ANIMATION_DELAY)
        textViewSpecialOffer.animateOpen(6 * ANIMATION_DELAY)
        fabBooking.animateOpen(3 * ANIMATION_DELAY)
        textViewBooking.animateOpen(7 * ANIMATION_DELAY)
        fabContacts.animateOpen(4 * ANIMATION_DELAY)
        textViewContacts.animateOpen(8 * ANIMATION_DELAY)
    }

    private fun closeMenu() {
        isMenuOpen = false
        menuScrim.animate().alpha(ALPHA_INITIAL_VALUE)
            .setDuration(8 * ANIMATION_DELAY + ANIMATION_DURATION)
            .withEndAction { menuScrim.isVisible = false }

        textViewContacts.animateClose(ANIMATION_INITIAL_DELAY)
        fabContacts.animateClose(4 * ANIMATION_DELAY)
        textViewBooking.animateClose(ANIMATION_DELAY)
        fabBooking.animateClose(5 * ANIMATION_DELAY)
        textViewSpecialOffer.animateClose(2 * ANIMATION_DELAY)
        fabSpecialOffer.animateClose(6 * ANIMATION_DELAY)
        textViewAccount.animateClose(3 * ANIMATION_DELAY)
        fabAccount.animateClose(7 * ANIMATION_DELAY)
        textViewExit.animateClose(4 * ANIMATION_DELAY)
        fabExit.animateClose(8 * ANIMATION_DELAY)
    }

    override fun onBackPressed() {
        if (isMenuOpen) closeMenu() else super.onBackPressed()
    }

    companion object {
        private const val PAGE_NUMBERS = 5
        private const val IMAGE_SCALE_FACTOR = 1.6f
        private const val IMAGE_INITIAL_TRANSLATION = 250
        private const val IMAGE_TRANSLATION_OFFSET_X = 300
        private const val BOTTOMSHEET_INITIAL_TRANSLATION = 0f
        private const val ANIMATION_INITIAL_DELAY = 0L
        private const val ANIMATION_DELAY = 30L
        private const val ALPHA_INITIAL_VALUE = 0f
        private const val ALPHA_FINAL_VALUE = 1f
    }
}