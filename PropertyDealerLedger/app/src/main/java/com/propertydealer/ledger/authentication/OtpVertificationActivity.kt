package com.propertydealer.ledger.authentication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.propertydealer.ledger.MainActivity
import com.propertydealer.ledger.R
import com.propertydealer.ledger.activities.HomeActivity
import com.propertydealer.ledger.databinding.ActivityMobileverificationBinding
import com.propertydealer.ledger.databinding.ActivityOtpBinding

class OtpVertificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOtpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)

    /*    window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.statusBarColor = Color.WHITE*/

        binding.btnVerifyOtp.setOnClickListener {
            startActivity(Intent(this, Password::class.java));
        }

        binding.btnChangePhoneNumber.setOnClickListener {
            startActivity(Intent(this, MobileVertificationActivity::class.java));
        }
        binding.ivArrow.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}