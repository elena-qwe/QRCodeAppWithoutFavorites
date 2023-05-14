package com.example.qrcodeapp.fragments.mark

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.qrcodeapp.R
import com.example.qrcodeapp.fragments.history.ScanAdapter
import com.example.qrcodeapp.model.Scan

class FavoriteItemsAdapter(private val items: List<Scan>) : RecyclerView.Adapter<FavoriteItemsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name_txt)
        val contentTextView: TextView = itemView.findViewById(R.id.content_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_scan, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.contentTextView.text = item.content
    }

    override fun getItemCount(): Int = items.size
}