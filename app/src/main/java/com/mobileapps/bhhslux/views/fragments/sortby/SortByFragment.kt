package com.mobileapps.bhhslux.views.fragments.sortby

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

import com.mobileapps.bhhslux.R

class SortByFragment : BottomSheetDialogFragment() {

    companion object {
        fun newInstance() = SortByFragment()
    }

    private lateinit var viewModel: SortByViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.sort_by_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SortByViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
