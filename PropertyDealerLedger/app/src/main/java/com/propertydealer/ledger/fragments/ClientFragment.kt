package com.propertydealer.ledger.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.propertydealer.ledger.databinding.SellerFragBinding

class ClientFragment: Fragment() {


    private lateinit var binding : SellerFragBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SellerFragBinding.inflate(inflater, container, false)






        return binding.root


    }
}