package com.propertydealer.ledger.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.propertydealer.ledger.adapters.ClientsAdapter
import com.propertydealer.ledger.databinding.ClientsBinding

class Clients : AppCompatActivity() {

    private lateinit var binding: ClientsBinding
    private lateinit var adapter: ClientsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ClientsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.appBar.textHeading.visibility = View.VISIBLE
        binding.appBar.textHeading.setText("Clients")
        binding.appBar.ivBack.setOnClickListener {
            onBackPressed()
        }
        setAdapter()
        binding.btnAddClient.setOnClickListener {
            onBackPressed()
        }

    }

    private fun setAdapter() {
        adapter = ClientsAdapter(this)
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvClients.layoutManager = layoutManager
        binding.rvClients.adapter = adapter
        binding.rvClients.adapter?.notifyDataSetChanged()
    }
}