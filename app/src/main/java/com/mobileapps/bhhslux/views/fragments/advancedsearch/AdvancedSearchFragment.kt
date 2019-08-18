package com.mobileapps.bhhslux.views.fragments.advancedsearch

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.databinding.AdvancedSearchFragmentBinding
import com.mobileapps.bhhslux.views.fragments.showhouses.ShowHousesFragment

class AdvancedSearchFragment : Fragment() {

    companion object {
        fun newInstance() = AdvancedSearchFragment()
    }

    private lateinit var viewModel: AdvancedSearchViewModel
    private lateinit var binding : AdvancedSearchFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AdvancedSearchViewModel::class.java)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.advanced_search_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewModel = viewModel
        
        // TODO: Use the ViewModel

        val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
        viewModel.setFragmentTransaction(fragmentTransaction)
    }

}
