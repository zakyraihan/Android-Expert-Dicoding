package com.zaky.androidexpertdicoding.core.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zaky.androidexpertdicoding.core.R
import com.zaky.androidexpertdicoding.core.databinding.ItemListBinding
import com.zaky.androidexpertdicoding.core.domain.model.Teams

class TeamsAdapter : RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder>() {

    private var dataList = ArrayList<Teams>()
    var onItemClick: ((Teams) -> Unit)? = null

    fun setData(newData: List<Teams>?) {
        if (newData == null) {
            Log.d("TeamsAdapter", "Data is null")
            return
        }
        dataList.clear()
        dataList.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TeamsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = dataList.size

    inner class TeamsViewHolder(itemVIew: View) : RecyclerView.ViewHolder(itemVIew) {
        private val binding = ItemListBinding.bind(itemVIew)
        fun bind(data: Teams) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.strTeamBadge)
                    .into(imgLogo)
                title.text = data.strTeam
                year.text = data.intFormedYear
                country.text = data.strCountry
            }
        }
        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(dataList[adapterPosition])
            }
        }
    }
}