package com.propertydealer.ledger.fragments.DiaryFtagment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.propertydealer.ledger.adapters.TodayTabAdapter
import com.propertydealer.ledger.databinding.TodayTabBinding

class TodayTabFragment : Fragment() {
    private lateinit var binding: TodayTabBinding
    private lateinit var adapter: TodayTabAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TodayTabBinding.inflate(layoutInflater, container, false)

        setAdapter()

        return binding.root


    }

    private fun setAdapter() {
        adapter = TodayTabAdapter(context)
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvTabToday.layoutManager = layoutManager
        binding.rvTabToday.adapter = adapter
        binding.rvTabToday.adapter?.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        setAdapter()
    }
}

