package com.propertydealer.ledger.introduction

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.propertydealer.ledger.R
import com.propertydealer.ledger.authentication.CreateAccount
import com.propertydealer.ledger.authentication.MobileVertificationActivity
import com.propertydealer.ledger.databinding.OnBoadingBinding

class OnBoardingActivity: AppCompatActivity() {
    private lateinit var binding: OnBoadingBinding


    private var myViewPagerAdapter: MyViewPagerAdapter? = null

    private var dots: Array<TextView?> = emptyArray()
    private var layouts: IntArray? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OnBoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeStatusBarColor()
        setDots()
        setAdapter()
        setListeners()

    }


    private var viewPagerPageChangeListener: ViewPager.OnPageChangeListener =
        object : ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                addBottomDots(position)

            }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {}

            override fun onPageScrollStateChanged(arg0: Int) {}
        }

    private fun setDots() {
        layouts =
            intArrayOf(
                R.drawable.onboard_first,
                R.drawable.onboard_second,
                R.drawable.onboard_third
            )
        addBottomDots(0)
    }

    private fun setAdapter() {
        myViewPagerAdapter = MyViewPagerAdapter()
        this.binding.viewPager.adapter = myViewPagerAdapter
        binding.viewPager.addOnPageChangeListener(viewPagerPageChangeListener)
    }

    private fun setListeners() {
        binding.btnSignup.setOnClickListener {
            startActivity(Intent(this, CreateAccount::class.java))
        }

        binding.btnlogin.setOnClickListener {
            startActivity(Intent(this, MobileVertificationActivity::class.java))
        }
     /*   binding.ivNextArrow.setOnClickListener {

            if (binding.viewPager.currentItem<2){
                binding.viewPager.setCurrentItem(binding.viewPager.currentItem+1,true)
            }else{
                startActivity(Intent(this, SignInActivity::class.java))

            }
        }*/

    }

    private fun addBottomDots(currentPage: Int) {
        dots = arrayOfNulls(layouts!!.size)
        val colorsActive = resources.getIntArray(R.array.array_dot_active)
        val colorsInactive = resources.getIntArray(R.array.array_dot_inactive)
        binding.layoutDots.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.text = Html.fromHtml("&#8226;")
            dots[i]!!.textSize = 45f
            dots[i]!!.setTextColor(colorsInactive[currentPage])
            binding.layoutDots.addView(dots[i])
        }
        if (dots.isNotEmpty())
            dots[currentPage]!!.setTextColor(colorsActive[currentPage])
    }

    /*private fun getItem(i: Int): Int {
        return binding.viewPager.currentItem + i
    }*/


    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    inner class MyViewPagerAdapter : PagerAdapter() {
        private var layoutInflater: LayoutInflater? = null

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = layoutInflater!!.inflate(R.layout.image_slider, container, false)
            val imageview = view.findViewById<ImageView>(R.id.imageView_first)
            imageview.setImageResource(layouts?.get(position)!!)
            container.addView(view)
            return view
        }

        override fun getCount(): Int {
            return layouts!!.size
        }

        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view === obj
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val view = `object` as View
            container.removeView(view)
        }
    }
}