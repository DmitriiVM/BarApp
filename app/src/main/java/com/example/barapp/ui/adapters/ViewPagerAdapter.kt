package com.example.barapp.ui.adapters

import androidx.fragment.app.*
import androidx.navigation.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.barapp.R
import com.example.barapp.ui.MenuFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> MenuFragment.newInstance("")
                    1 -> MenuFragment.newInstance("")
                    2 -> MenuFragment.newInstance("")
                    3 -> MenuFragment.newInstance("")
                    else -> MenuFragment.newInstance("")
                }
    }
}