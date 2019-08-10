package com.mobileapps.bhhslux.viewmodel

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.model.house.House
import com.mobileapps.bhhslux.model.searchfilter.SearchFilter
import com.squareup.picasso.Picasso

class ShowHousesViewModel : ViewModel
{
    var id    = ""
    var price = ""
    var address = ""
    var status = ""
    var shortDescription = ""
    var imagePatch       = ""


    constructor() : super()

    constructor(house : House) : super() {
        this.id               = house.id
        this.price            = house.price
        this.address          = house.address
        this.status           = house.status
        this.shortDescription = house.shortDescription
        this.imagePatch       = house.imagePatch
    }


    var arrayListMutableLiveData = MutableLiveData<ArrayList<ShowHousesViewModel>>()

    var arrayList = ArrayList<ShowHousesViewModel>()

    fun getImageUrl():String{
        return imagePatch
    }


    fun getHousesList(filter: SearchFilter) : MutableLiveData<ArrayList<ShowHousesViewModel>>
    {

        if(filter.nearbyForRent)
        {
            Log.d("Heiner","nearby For rent")
        }

        if(filter.nearbyForSale)
        {
            Log.d("Heiner","nearby For Sale")
        }

        if(filter.newToMarket)
        {
            Log.d("Heiner","new to market")
        }

        if(filter.priceChanged)
        {
            Log.d("Heiner","price changed")
        }

        if(filter.openHouse)
        {
            Log.d("Heiner","open house")
        }

        if(filter.nearbyRecentlySold)
        {
            Log.d("Heiner","nearby recently sold")
        }



        val house1 = House("1", "$1,350", "1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166", "For Sale - Active", "4bd 3 ba", "https://i.ytimg.com/vi/Xx6t0gmQ_Tw/maxresdefault.jpg")
        val house2 = House("2", "$399,900", "1590 Arden Drive SW Marietta, GA 30008-3731", "For Sale - Active", "3bd 2 ba", "https://assets.themortgagereports.com/wp-content/uploads/2017/12/How-to-Buy-a-House-with-Low-Income-This-Year.jpg")
        val house3 = House("3", "$310,000", "1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166", "For Sale - Active", "4bd 3 ba", "https://cdn.decorpad.com/photos/2017/09/19/8e667843102e.jpg")
        val house4 = House("4", "$295,775", "1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166", "For Sale - Active", "4bd 3 ba", "https://upload.wikimedia.org/wikipedia/commons/d/d8/SaltBoxHouse1.jpg")



        val showHousesViewModel1 = ShowHousesViewModel(house1)
        val showHousesViewModel2 = ShowHousesViewModel(house2)
        val showHousesViewModel3 = ShowHousesViewModel(house3)
        val showHousesViewModel4 = ShowHousesViewModel(house4)

        arrayList.add(showHousesViewModel1)
        arrayList.add(showHousesViewModel2)
        arrayList.add(showHousesViewModel3)
        arrayList.add(showHousesViewModel4)

        arrayListMutableLiveData.value = arrayList



        return arrayListMutableLiveData
    }


}


object ImageBindingAdapter
{
    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrl(view:ImageView,url:String)
    {
        Picasso.with(view.context).load(url).placeholder(R.drawable.housedemo).into(view)
    }
}
