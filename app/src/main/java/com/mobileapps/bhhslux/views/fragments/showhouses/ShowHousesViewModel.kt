package com.mobileapps.bhhslux.views.fragments.showhouses

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.model.datasource.remote.mock.MockDataBase
import com.mobileapps.bhhslux.model.house.House
import com.mobileapps.bhhslux.model.searchfilter.SearchFilter
import com.squareup.picasso.Picasso

class ShowHousesViewModel : ViewModel
{
    var id    = ""
    var price = ""
    var address = ""
    var searchType = ""
    var shortDescription = ""
    var imagePatch       = ""
    var status           = "Active"


    var visibleNewToMarket = View.VISIBLE

    var visibleOpenHouse = View.VISIBLE


    val db : MockDataBase = MockDataBase()

    constructor() : super()

    constructor(house : House) : super() {
        this.id               = house.id
        this.price            = house.price
        this.address          = house.address
        this.searchType       = house.searchType
        this.shortDescription = house.shortDescription
        this.imagePatch       = house.imagePatch

        visibleNewToMarket = if(house.isNewToMarket) View.VISIBLE else View.GONE
        visibleOpenHouse   = if(house.isOpenHouse) View.VISIBLE else View.GONE
        status             = if(house.isActive) "Active" else "Pending"


    }


    var arrayListMutableLiveData = MutableLiveData<ArrayList<ShowHousesViewModel>>()


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




        arrayListMutableLiveData.value = db.getHouses()



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
