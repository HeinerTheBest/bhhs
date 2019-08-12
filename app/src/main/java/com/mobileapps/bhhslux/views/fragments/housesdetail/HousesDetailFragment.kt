package com.mobileapps.bhhslux.views.fragments.housesdetail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.model.house.House

class HousesDetailFragment : Fragment() {

    companion object {
        fun newInstance(id : Int) = HousesDetailFragment()
    }

    private lateinit var viewModel: HousesDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.houses_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HousesDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
