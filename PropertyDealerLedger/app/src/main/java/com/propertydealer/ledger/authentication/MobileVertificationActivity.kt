package com.propertydealer.ledger.authentication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.propertydealer.ledger.R
import com.propertydealer.ledger.databinding.ActivityMobileverificationBinding

class MobileVertificationActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMobileverificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
        binding= ActivityMobileverificationBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnSendOtp.setOnClickListener {
            startActivity(Intent(this, OtpVertificationActivity::class.java));

        }
        binding.btnLoginPssword.setOnClickListener {
            startActivity(Intent(this, Password::class.java));
        }
        binding.ivArrow.ivBack.setOnClickListener {
            onBackPressed()
        }

    }
}