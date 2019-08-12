package com.mobileapps.bhhslux.views.fragments.showhouses

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.model.datasource.remote.mock.MockDataBase
import com.mobileapps.bhhslux.model.house.House
import com.mobileapps.bhhslux.model.searchfilter.SearchFilter
import com.mobileapps.bhhslux.views.fragments.housesdetail.HousesDetailFragment
import com.squareup.picasso.Picasso

class ShowHousesViewModel : ViewModel
{
    var id    = ""
    var oldPrice = ""
    var price = ""
    var address = ""
    var searchType = ""
    var shortDescription = ""
    var imagePatch       = ""
    var status           = "Active"


    var visibleNewToMarket = View.VISIBLE
    var visibleOldPrice    = View.VISIBLE

    var visibleOpenHouse = View.VISIBLE


    var fragmentTransaction2 : FragmentTransaction? = null




    private val db : MockDataBase = MockDataBase()

    constructor() : super()

    constructor(house : House, fragmentTransaction2 : FragmentTransaction?) : super() {
        this.id               = house.id
        this.price            = "$${house.price}"
        this.address          = house.address
        this.searchType       = house.searchType
        this.shortDescription = house.shortDescription
        this.imagePatch       = house.imagePatch
        this.fragmentTransaction2 = fragmentTransaction2


        visibleNewToMarket = if(house.isNewToMarket) View.VISIBLE else View.GONE
        visibleOpenHouse   = if(house.isOpenHouse) View.VISIBLE else View.GONE
        status             = if(house.isActive) "Active" else "Pending"

        oldPrice = "$${house.oldPrice}"
        visibleOldPrice = if(house.oldPrice != null) View.VISIBLE else View.GONE


    }


    var arrayListMutableLiveData = MutableLiveData<ArrayList<ShowHousesViewModel>>()


    fun getImageUrl():String{
        return imagePatch
    }

    fun startDetails()
    {
        Log.d("Heiner", "This house is price $price")
        val detailHouseFragment = HousesDetailFragment.newInstance(id.toInt())
        fragmentTransaction2?.replace(R.id.fragmentLayout,detailHouseFragment)
        fragmentTransaction2?.commit()
        if(fragmentTransaction2 == null) Log.d("Heiner","Yes") else Log.d("Heiner","No")


    }


    fun getHousesList(filter: SearchFilter,fragmentTransaction2 : FragmentTransaction?) : MutableLiveData<ArrayList<ShowHousesViewModel>>
    {
        arrayListMutableLiveData.value = db.getFilterHousesByFilter(filter,fragmentTransaction2)
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
