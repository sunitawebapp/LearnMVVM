package com.sunitawebapp.learnmvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sunitawebapp.learnmvvm.Models.DetailsLists
import com.sunitawebapp.learnmvvm.R


class DetailsAdapter(var detailslist : MutableList<DetailsLists>) : RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {

    class DetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      var tvDetails : TextView

        init {
            tvDetails = itemView.findViewById(R.id.tvDetails)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        return DetailsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_details, parent, false))

    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
     var detailslistpos=detailslist.get(position)
        holder.tvDetails.text=detailslistpos.text


    }

    override fun getItemCount(): Int {
      return detailslist.size
    }


}
