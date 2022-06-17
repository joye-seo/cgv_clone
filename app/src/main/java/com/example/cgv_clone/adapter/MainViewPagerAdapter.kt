package com.example.cgv_clone.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cgv_clone.fragment.*

class MainViewPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 6
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> EventFragment()
            2 -> MovieFragment()
            3 -> OrderFragment()
            4 -> GiftFragment()
            else -> CgvFragment()
        }
    }
}