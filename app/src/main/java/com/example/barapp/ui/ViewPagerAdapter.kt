package com.example.barapp.ui

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> CategoryFragment.newInstance("")
                    1 -> CategoryFragment.newInstance("")
                    2 -> CategoryFragment.newInstance("")
                    3 -> CategoryFragment.newInstance("")
                    else -> CategoryFragment.newInstance("")
                }
    }
}