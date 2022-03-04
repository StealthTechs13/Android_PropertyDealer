package com.propertydealer.ledger.authentication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.propertydealer.ledger.activities.HomeActivity
import com.propertydealer.ledger.databinding.ActivityMobileverificationBinding
import com.propertydealer.ledger.databinding.CreateAccountBinding
import com.propertydealer.ledger.databinding.HomeActivityBinding

class CreateAccount : AppCompatActivity() {

        private lateinit var binding: CreateAccountBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = CreateAccountBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.backLogin.setOnClickListener {
                startActivity(Intent(this, MobileVertificationActivity::class.java));
                finish()
            }
            binding.btnCreateAccount.setOnClickListener {
                startActivity(Intent(this, HomeActivity::class.java));
            }
            binding.ivArrow.ivBack.setOnClickListener {
                onBackPressed()
            }
        }
    }