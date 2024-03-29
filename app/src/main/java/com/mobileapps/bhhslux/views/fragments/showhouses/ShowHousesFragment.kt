package com.mobileapps.bhhslux.views.fragments.showhouses

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.adapters.ShowHousesAdapter
import com.mobileapps.bhhslux.model.searchfilter.SearchFilter

class ShowHousesFragment(private var filter: SearchFilter,private var opc : Int) : Fragment() {


    private lateinit var recyclerView:RecyclerView
    private lateinit var showHousesAdapter: ShowHousesAdapter



    companion object {
        fun newInstance(filter : SearchFilter,opc : Int) = ShowHousesFragment(filter,opc)

    }

    private lateinit var viewModel: ShowHousesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ShowHousesViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.show_houses_fragment, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rvShowHouses) as RecyclerView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)




        val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
        fragmentTransaction?.addToBackStack(null)


        viewModel.getHousesList(filter,fragmentTransaction,opc).observe(this, Observer
        {
            showHousesViewModel ->
            showHousesAdapter = ShowHousesAdapter(this@ShowHousesFragment.context,showHousesViewModel!!)
            recyclerView.layoutManager = LinearLayoutManager(this@ShowHousesFragment.context)
            recyclerView.adapter = showHousesAdapter
        })



    }





}
