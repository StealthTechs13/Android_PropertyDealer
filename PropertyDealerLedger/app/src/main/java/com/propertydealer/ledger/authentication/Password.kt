package com.propertydealer.ledger.authentication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.propertydealer.ledger.activities.HomeActivity
import com.propertydealer.ledger.databinding.CreateAccountBinding
import com.propertydealer.ledger.databinding.EnterPasswordBinding

class Password : AppCompatActivity() {

    private lateinit var binding: EnterPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EnterPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivArrow.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.btnlogin.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java));
        }
        binding.btnloginWithOtp.setOnClickListener {
            startActivity(Intent(this, OtpVertificationActivity::class.java));
        }


    }
}