package com.propertydealer.ledger.authentication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.propertydealer.ledger.activities.HomeActivity
import com.propertydealer.ledger.databinding.CreateAccountBinding
import com.propertydealer.ledger.databinding.PremiumBinding

class Premium: AppCompatActivity() {

    private lateinit var binding: PremiumBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PremiumBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}