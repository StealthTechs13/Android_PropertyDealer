package com.propertydealer.ledger.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.propertydealer.ledger.databinding.ClientsAdapterBinding


class ClientsAdapter(var context: Context?) :
    RecyclerView.Adapter<ClientsAdapter.MyViewHolder>() {

    private var lastSelectedPosition = -1
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int

    ): MyViewHolder {

        val binding = ClientsAdapterBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.binding.rb.setOnClickListener {
            lastSelectedPosition = position
            notifyDataSetChanged()
        }

        holder.binding.rb.setChecked(position == lastSelectedPosition)



        //load image into view
        //load image into view
        //   Picasso.get().load("https://stealthtechnocrats.com/ecom/public/"+category_list.get(position).img_url).fit().into(holder.binding.ivCategory)

    }


    override fun getItemCount(): Int {
        return 3
    }

    class MyViewHolder(val binding: ClientsAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //s pi

    }


}