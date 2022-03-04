package com.propertydealer.ledger.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.propertydealer.ledger.R
import com.propertydealer.ledger.activities.MeetingDetail
import com.propertydealer.ledger.databinding.TodayTabAdapterBinding

class TodayTabAdapter(var context: Context?) :
    RecyclerView.Adapter<TodayTabAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int

    ): MyViewHolder {

        val binding = TodayTabAdapterBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {

        holder.binding.rlParent.setOnClickListener {
            context?.startActivity(Intent(context, MeetingDetail::class.java))
        }

        holder.binding.ivMore.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(context, holder.binding.ivMore)
            popupMenu.menuInflater.inflate(R.menu.meeting_detail_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.completed ->
                        Toast.makeText(context, "You Clicked : " + item.title, Toast.LENGTH_SHORT)
                            .show()
                    R.id.reschdule ->
                        Toast.makeText(context, "You Clicked : " + item.title, Toast.LENGTH_SHORT)
                            .show()

                }
                true
            })
            popupMenu.show()
        }

    }
    //load image into view
    //load image into view
    //   Picasso.get().load("https://stealthtechnocrats.com/ecom/public/"+category_list.get(position).img_url).fit().into(holder.binding.ivCategory)


    override fun getItemCount(): Int {
        return 3
    }

    class MyViewHolder(val binding: TodayTabAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //s pi

    }


}