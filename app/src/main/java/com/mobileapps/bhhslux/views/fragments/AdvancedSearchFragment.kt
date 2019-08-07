package com.mobileapps.bhhslux.views.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.viewmodel.AdvancedSearchViewModel

class AdvancedSearchFragment : Fragment() {

    companion object {
        fun newInstance() = AdvancedSearchFragment()
    }

    private lateinit var viewModel: AdvancedSearchViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.advanced_search_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AdvancedSearchViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
