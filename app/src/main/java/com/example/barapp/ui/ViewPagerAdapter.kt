package com.example.barapp.ui

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> CategoryFragment.newInstance("1", "")
                    1 -> CategoryFragment.newInstance("2", "")
                    2 -> CategoryFragment.newInstance("3", "")
                    3 -> CategoryFragment.newInstance("4", "")
                    else -> CategoryFragment.newInstance("5", "")
                }
    }
}