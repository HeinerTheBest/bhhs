package com.mobileapps.bhhslux.views.fragments.advancedsearch

import android.text.Editable
import android.util.Log
import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel;
import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.model.searchfilter.SearchFilter
import com.mobileapps.bhhslux.views.fragments.showhouses.ShowHousesFragment
import kotlinx.android.synthetic.main.advanced_search_fragment.*

class AdvancedSearchViewModel : ViewModel() , Observable
{


    val propertyChangeRegistry = PropertyChangeRegistry()


    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }

    fun notifyAllViewsChanged(){
        propertyChangeRegistry.notifyChange(this,0)
    }

    lateinit var  filter : SearchFilter
    var fragmentTransaction2 : FragmentTransaction? = null

    @Bindable
    var minPrice = ""
    @Bindable
    var maxPrice = ""
    @Bindable
    var beds     = ""
    @Bindable
    var batch    = ""
    @Bindable
    var newListing = false
    @Bindable
    var openHOuses = false
    @Bindable
    var recentPriceChange = false
    @Bindable
    var forSale = false
    @Bindable
    var forRent = false
    @Bindable
    var recentlySOld = false
    @Bindable
    var status = true







    fun setFragmentTransaction(fragmentTransaction2: FragmentTransaction?) {
        this.fragmentTransaction2 = fragmentTransaction2
    }



    fun onMinPriceChanged(minPrice : Editable)
    {
        this.minPrice = minPrice.toString()
    }

    fun onMaxPriceChanged(maxPrice : Editable)
    {
        this.maxPrice = maxPrice.toString()
    }

    fun onBedChanged(beds : Editable)
    {
        this.beds = beds.toString()
    }

    fun onBathsChanged(batch : Editable)
    {
        this.batch = batch.toString()
    }



    fun forSale()
    {
        forSale = !forSale
    }

    fun forRent()
    {
        forRent = !forRent
    }

    fun recSold()
    {
        recentlySOld = !recentlySOld
    }

    fun statuActive()    { status = true}
    fun statuDesactive() { status = false}

    fun newListing()
    {
        newListing = !newListing
    }

    fun openHouse()
    {
        openHOuses = !openHOuses
    }

    fun priceChanged()
    {
        recentPriceChange = !recentPriceChange
    }



    fun clear()
    {

        Log.d("Heiner","min price = $minPrice  for sale = $forSale")
         minPrice = ""
         maxPrice = ""
         beds     = ""
         batch    = ""
         newListing = false
         openHOuses = false
         recentPriceChange = false
        forSale = false
         forRent = false
         recentlySOld = false
        status = true
        notifyAllViewsChanged()
    }

    fun search()
    {
        filter = SearchFilter()
        filter.advanced = true
        filter.status   = status
        filter.nearbyForSale = forSale
        filter.nearbyForRent = forRent
        filter.nearbyRecentlySold = recentlySOld
        filter.newToMarket = newListing
        filter.priceChanged = recentPriceChange
        filter.openHouse = openHOuses
        if (minPrice.isNotEmpty()) filter.minimumPrice = minPrice.toInt()
        if (maxPrice.isNotEmpty()) filter.maxPrice     = maxPrice.toInt()
        if (beds.isNotEmpty()) filter.manyBeds = beds.toInt()
        if(batch.isNotEmpty()) filter.manyBaths = batch.toInt()

        Log.d("Heiner","THe filter is: \n"+
        filter.nearbyForSale+"\n"+
        filter.newToMarket+"\n"+
        filter.priceChanged  +"\n"+
        filter.openHouse         +"\n"+
        filter.nearbyForRent      +"\n"+
        filter.nearbyRecentlySold +"\n"+
        filter.all                +"\n"+
        filter.advanced          +"\n"+
        filter.minimumPrice       +"\n"+
        filter.maxPrice           +"\n"+
        filter.manyBeds          +"\n"+
        filter.manyBaths          +"\n"+
        filter.status
        )


        val showHouses = ShowHousesFragment.newInstance(filter,0)
        fragmentTransaction2?.replace(R.id.fragmentLayout,showHouses)
        fragmentTransaction2?.addToBackStack(null)?.commit()

    }

}
