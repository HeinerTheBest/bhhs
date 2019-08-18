package com.mobileapps.bhhslux.views.fragments.housesdetail

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.model.datasource.remote.mock.MockDataBase
import com.mobileapps.bhhslux.model.house.House
import com.mobileapps.bhhslux.views.fragments.advancedsearch.AdvancedSearchFragment
import com.mobileapps.bhhslux.views.fragments.contact.ContactFragment
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

    private  var activity : Activity? = null

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

    fun openNavigation()
    {
        // Create a Uri from an intent string. Use the result to create an Intent.
        val gmmIntentUri = Uri.parse("google.streetview:cbll=${house?.lat},${house?.long}")

        // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        val mapIntent = Intent(Intent.ACTION_VIEW,gmmIntentUri)

        // Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps")

        // Attempt to start an activity that can handle the Intent
         activity?.startActivity(mapIntent)
    }

    var supportFragmentManager : FragmentManager? = null

     fun showContactDialog() {
        val contactFragment = ContactFragment()
        contactFragment.show(supportFragmentManager, "contact_fragment")
    }

    fun shareLinkPlayStore()
    {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type = activity?.getString(R.string.type_link)
        shareIntent.putExtra(Intent.EXTRA_TEXT, activity?.getString(R.string.link_share))
        activity?.startActivity(Intent.createChooser(shareIntent,""))
    }

    fun openAdvanceSearch() {
        val advancedSearch = AdvancedSearchFragment.newInstance()
        supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentLayout,advancedSearch)
                ?.addToBackStack(advancedSearch.tag)
                ?.commit()
    }


    fun setActivity(activity : FragmentActivity?, supportFragmentManager : FragmentManager?)
    {
        this.activity = activity
        this.supportFragmentManager = supportFragmentManager
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



