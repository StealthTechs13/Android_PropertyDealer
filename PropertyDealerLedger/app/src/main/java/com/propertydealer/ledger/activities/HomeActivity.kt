package com.propertydealer.ledger.activities

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.propertydealer.ledger.R
import com.propertydealer.ledger.databinding.HomeActivityBinding
import com.propertydealer.ledger.fragments.*
import com.propertydealer.ledger.fragments.DiaryFtagment.DiaryFragment

@Suppress("DEPRECATION")
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: HomeActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val seller = Seller()
        openFragment(seller)
        listener()

    }

    private fun listener() {
        val bottomNavigation: BottomNavigationView = binding.navigationView
        val bottomNavigationd = BottomNavigationView.OnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.navigation_seller -> {
                    // item.setIcon(R.drawable.seller_selected)
                    val seller = Seller()
                    openFragment(seller)
                    return@OnNavigationItemSelectedListener true

                }

                R.id.navigation_buyer -> {
                    val buyer = BuyerFragment()
                    openFragment(buyer)
                    // item.setIcon(R.drawable.buyer_selected)
                    return@OnNavigationItemSelectedListener true

                }

                R.id.navigation_diary -> {
                    val diary = DiaryFragment()
                    openFragment(diary)
                    return@OnNavigationItemSelectedListener true

                }

                R.id.navigation_client -> {
                    val client = ClientFragment()
                    openFragment(client)
                    return@OnNavigationItemSelectedListener true

                }

                R.id.navigation_setting -> {
                    val setting = SettingFragment()
                    openFragment(setting)
                    return@OnNavigationItemSelectedListener true

                }

            }

            false


        }
        bottomNavigation.setOnNavigationItemSelectedListener(bottomNavigationd)

    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.detach(fragment);
        transaction.attach(fragment);
        transaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (getFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else {
            super.onBackPressed()

        }
    }
}