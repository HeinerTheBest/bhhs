package com.mobileapps.bhhslux.views.fragments.housesdetail

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.model.datasource.remote.mock.MockDataBase
import com.mobileapps.bhhslux.model.house.House
import com.squareup.picasso.Picasso

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
    var imagePatch = ""


    private val db : MockDataBase = MockDataBase()

    var house : House? = null

    fun updateUI(id : Int)
    {
        house = db.getHouseById(id)
        Log.d("Heiner","Here")
        Log.d("Heiner",house?.listingDetails?.fullBath.toString())

        bath = house?.listingDetails?.fullBath.toString()
        bed  = house?.listingDetails?.beds.toString()
        type = house?.listingDetails?.type ?: ""
        status = house?.getStatus()!!
        subDIvision = house!!.listingDetails.subDivision
        county = house!!.listingDetails.county
        yearBuilt = house!!.listingDetails.yearBuilt
        hightSchool = house!!.listingDetails.highSchool
        middleSchool = house!!.listingDetails.middleSchool
        elementarySchool = house!!.listingDetails.elementarySchool
        halfBaths = house!!.listingDetails.halfBath.toString()
        sqft = house!!.listingDetails.sqFt.toString()
        lotSize = house!!.listingDetails.lotSize.toString()
        taxesyear = house!!.listingDetails.taxesYear
        listingId = house!!.listingDetails.listingId
        listingProvidedCourtesyOf = house!!.listingDetails.listingProvided
        price = "$${house!!.price}"
        address = house!!.address
        imagePatch = house!!.imagePatch

    }


    object ImageBindingAdapter
    {
        @JvmStatic
        @BindingAdapter("android:src")
        fun setImageViewResource(imageView: ImageView, resource :Int)
        {
            Picasso.with(imageView.context).load(resource).placeholder(R.drawable.housedemo).into(imageView)
        }
    }

}



