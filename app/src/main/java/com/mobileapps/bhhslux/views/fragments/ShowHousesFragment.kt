package com.mobileapps.bhhslux.views.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.adapters.ShowHousesAdapter
import com.mobileapps.bhhslux.viewmodel.ShowHousesViewModel

class ShowHousesFragment : Fragment() {

    public val TAG = "ShowHousesFragment"
    private lateinit var recyclerView:RecyclerView
    private lateinit var showHousesAdapter: ShowHousesAdapter

    companion object {
        fun newInstance() = ShowHousesFragment()
    }

    private lateinit var viewModel: ShowHousesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.show_houses_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rvShowHouses) as RecyclerView

        var showHousesViewModel : ShowHousesViewModel = ViewModelProviders.of(this).get(ShowHousesViewModel::class.java)

        showHousesViewModel.getArrayList().observe(this, Observer
        {

            showHousesViewModel ->
            showHousesAdapter = ShowHousesAdapter(this@ShowHousesFragment.context,showHousesViewModel!!)
            recyclerView.layoutManager = LinearLayoutManager(this@ShowHousesFragment.context)
            recyclerView.adapter = showHousesAdapter
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ShowHousesViewModel::class.java)
        // TODO: Use the ViewModel
    }



}
