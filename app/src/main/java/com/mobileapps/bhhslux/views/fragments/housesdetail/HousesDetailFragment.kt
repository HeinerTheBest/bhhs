package com.mobileapps.bhhslux.views.fragments.housesdetail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.databinding.HousesDetailFragmentBinding
import com.mobileapps.bhhslux.databinding.LoginFragmentBinding
import com.mobileapps.bhhslux.model.datasource.remote.mock.MockDataBase
import com.mobileapps.bhhslux.model.house.House
import com.mobileapps.bhhslux.model.searchfilter.SearchFilter
import com.mobileapps.bhhslux.views.fragments.auth.login.LoginViewModel

class HousesDetailFragment(private val idHouse: Int) : Fragment() {

    private lateinit var viewModel: HousesDetailViewModel
    private lateinit var binding : HousesDetailFragmentBinding



    companion object {
        fun newInstance(idHouse : Int) = HousesDetailFragment(idHouse)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HousesDetailViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.houses_detail_fragment, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.viewModel = viewModel


        // TODO: Use the ViewModel
        viewModel.updateUI(idHouse)

    }

}
