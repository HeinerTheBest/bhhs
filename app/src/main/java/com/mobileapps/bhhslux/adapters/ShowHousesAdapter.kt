package com.mobileapps.bhhslux.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.databinding.ShowHousesBinding
import com.mobileapps.bhhslux.views.fragments.showhouses.ShowHousesViewModel

class ShowHousesAdapter(private val context: Context?, private val arrayList: ArrayList<ShowHousesViewModel>) : RecyclerView.Adapter<ShowHousesAdapter.CustomView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {
        val layoutInflater = LayoutInflater.from(parent.context)
        val showHousesBinding : ShowHousesBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_house,parent,false)
        return CustomView(showHousesBinding)
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {
        val showHousesViewModel = arrayList[position]
        holder.bind(showHousesViewModel)
    }


    class CustomView(val showHousesBindind : ShowHousesBinding) : RecyclerView.ViewHolder(showHousesBindind.root)
    {
        fun bind (showHousesViewModel: ShowHousesViewModel)
        {
            this.showHousesBindind.showHousesModel = showHousesViewModel
            showHousesBindind.executePendingBindings()
        }
    }

}