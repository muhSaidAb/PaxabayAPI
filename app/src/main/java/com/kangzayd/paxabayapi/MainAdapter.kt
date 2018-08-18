package com.kangzayd.paxabayapi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kangzayd.paxabayapi.model.HitsItem
import kotlinx.android.synthetic.main.item_recyclerview.view.*

class MainAdapter(val hits: List<HitsItem?>?): RecyclerView.Adapter<MainAdapter.VHolder>() {
    class VHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val text1= itemView!!.textItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.VHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recyclerview, parent, false)
        return VHolder(view)
    }

    override fun getItemCount(): Int {
        return  hits?.size ?: 0
    }

    override fun onBindViewHolder(holder: MainAdapter.VHolder, position: Int) {
        val item = hits!![position]
        holder.text1.text = "${item!!.tags}"
    }

}
