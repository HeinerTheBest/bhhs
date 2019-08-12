package com.mobileapps.bhhslux.views.fragments.housesdetail

import android.util.Log
import androidx.lifecycle.ViewModel
import com.mobileapps.bhhslux.model.datasource.remote.mock.MockDataBase

class HousesDetailViewModel : ViewModel()
{
    var bath = ""
    var bed  = ""
    var type : String = ""
    var status  = ""
    var subDIvision  = ""
    var county  = ""
    var yearBuilt  = ""
    var hightSchool  = ""
    var middleSchool = ""
    var elementarySchool  = ""
    var halfBaths  = ""
    var sqft  = ""
    var lotSize  = ""
    var taxesyear  = ""
    var listingId  = ""
    var listingProvidedCourtesyOf  = ""
    var price = ""
    var address = ""


    private val db : MockDataBase = MockDataBase()

    fun updateUI(id : Int)
    {
        val house = db.getHouseById(id)
        Log.d("Heiner","Here")
        Log.d("Heiner",house?.listingDetails?.fullBath.toString())

        bath = house?.listingDetails?.fullBath.toString()
        bed  = house?.listingDetails?.beds.toString()
        type = house?.listingDetails?.type ?: ""
        status = house?.getStatus()!!
        subDIvision = house.listingDetails.subDivision
        county = house.listingDetails.county
        yearBuilt = house.listingDetails.yearBuilt
        hightSchool = house.listingDetails.highSchool
        middleSchool = house.listingDetails.middleSchool
        elementarySchool = house.listingDetails.elementarySchool
        halfBaths = house.listingDetails.halfBath.toString()
        sqft =house.listingDetails.sqFt.toString()
        lotSize = house.listingDetails.lotSize.toString()
        taxesyear = house.listingDetails.taxesYear
        listingId = house.listingDetails.listingId
        listingProvidedCourtesyOf = house.listingDetails.listingProvided
        price = "$${house.price}"
        address = house.address

    }






}
