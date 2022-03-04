package com.propertydealer.ledger.utils

import android.app.DatePickerDialog
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.os.Build
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat


class Constants {

    companion object {
        const val BASEURL = "https://medsyapp.com/nodeapis/api/";
        const val SIGNUP = BASEURL + "signup1";
        const val SIGNUP2 = BASEURL + "signup2";

        var checknevalue: Int = 0
        lateinit var customDialog: AlertDialog
        var error_msg: String = ""

        fun Context.toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}