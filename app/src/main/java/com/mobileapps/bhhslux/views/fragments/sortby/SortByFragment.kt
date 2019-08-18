package com.mobileapps.bhhslux.views.fragments.sortby

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.databinding.LoginFragmentBinding
import com.mobileapps.bhhslux.databinding.SortByFragmentBinding
import com.mobileapps.bhhslux.model.searchfilter.SearchFilter
import com.mobileapps.bhhslux.views.fragments.auth.login.LoginViewModel
import com.mobileapps.bhhslux.views.fragments.auth.signup.SignUpFragment
import com.mobileapps.bhhslux.views.fragments.showhouses.ShowHousesFragment
import com.mobileapps.bhhslux.views.fragments.showhouses.ShowHousesViewModel

class SortByFragment(private var filter: SearchFilter) : BottomSheetDialogFragment() {

    companion object {
        fun newInstance(filter : SearchFilter) = SortByFragment(filter)
    }

    var fragmentTransaction2 : FragmentTransaction? = null

    private lateinit var viewModel: SortByViewModel
    private lateinit var binding : SortByFragmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SortByViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.sort_by_fragment, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        binding.viewModel = viewModel


        val fragmentTransaction = activity?.supportFragmentManager


        viewModel.setFragmentTransaction(fragmentTransaction,filter)

    }

}
