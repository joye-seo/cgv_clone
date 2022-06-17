package com.example.cgv_clone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cgv_clone.adapter.MainViewPagerAdapter
import com.example.cgv_clone.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    private lateinit var mMainViewPager: MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewPager()

        binding.btnTicket.setOnClickListener {
            val intent = Intent (this,LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun viewPager() = with(binding) {
        mMainViewPager = MainViewPagerAdapter(this@HomeActivity)
        viewpagerHome.adapter = mMainViewPager
        viewpagerHome.offscreenPageLimit = 6

        TabLayoutMediator(tabLayoutHome, viewpagerHome) { tab, position ->
            when (position) {
                0 -> tab.text = "홈"
                1 -> tab.text = "이벤트"
                2 -> tab.text = "무비톡"
                3 -> tab.text = "패스트오더"
                4 -> tab.text = "기프트샵"
                else -> tab.text = "\u0040CGV"
            }
        }.attach()

        viewpagerHome.isNestedScrollingEnabled = true


    }

    override fun onBackPressed() {
        //홈화면 백프레스 시 이동하는 로직 구현해야함!
        binding.viewpagerHome.currentItem = 0
    }


}