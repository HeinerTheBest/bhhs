package com.mobileapps.bhhslux.views.fragments.sortby

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;

class SortByViewModel : ViewModel()
{
    val sortType = MutableLiveData<Int>()

    fun defaultSort()
    {
        Log.d("Heiner","Default way")
        sortType.postValue(0)
    }

    fun priceHightToLowSort()
    {
        Log.d("Heiner","Hight to Low")
        sortType.postValue(1)

    }

    fun priceLowToHightSort()
    {
        Log.d("Heiner","Low to Hight")
        sortType.postValue(2)
    }

}
