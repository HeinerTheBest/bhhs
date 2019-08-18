package com.mobileapps.bhhslux.views.fragments.sortby

import android.app.Activity
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.model.searchfilter.SearchFilter
import com.mobileapps.bhhslux.views.fragments.showhouses.ShowHousesFragment
import java.util.logging.Filter

class SortByViewModel : ViewModel()
{
    val sortType = MutableLiveData<Int>()
    var fragmentTransaction2 : FragmentManager? = null
    lateinit var  filter : SearchFilter
    lateinit var activity : Activity

    fun defaultSort()
    {
        Log.d("Heiner","Default way")
        sortType.postValue(0)

        val showHousesFragment = ShowHousesFragment.newInstance(filter,0)

        fragmentTransaction2?.beginTransaction()
                ?.replace(R.id.fragmentLayout,showHousesFragment)
                ?.addToBackStack(showHousesFragment.tag)
                ?.commit()

    }

    fun priceLowToHightSort()
    {
        Log.d("Heiner","Low to Hight")
        sortType.postValue(1)
        val showHousesFragment = ShowHousesFragment.newInstance(filter,1)
        fragmentTransaction2?.beginTransaction()
                ?.replace(R.id.fragmentLayout,showHousesFragment)
                ?.addToBackStack(showHousesFragment.tag)
                ?.commit()
    }


    fun priceHightToLowSort()
    {
        Log.d("Heiner","Hight to Low")
        sortType.postValue(2)
        val showHousesFragment = ShowHousesFragment.newInstance(filter,2)
        fragmentTransaction2?.beginTransaction()
                ?.replace(R.id.fragmentLayout,showHousesFragment)
                ?.addToBackStack(showHousesFragment.tag)
                ?.commit()

    }



    fun setFragmentTransaction(fragmentTransaction2: FragmentManager?,filter: SearchFilter) {

        this.fragmentTransaction2 = fragmentTransaction2
        this.filter = filter
    }

}
