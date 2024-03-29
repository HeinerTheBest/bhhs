package com.mobileapps.bhhslux.views.fragments.map

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.model.datasource.remote.mock.MockDataBase
import com.mobileapps.bhhslux.model.house.House
import com.mobileapps.bhhslux.model.searchfilter.SearchFilter
import com.mobileapps.bhhslux.views.fragments.housesdetail.HousesDetailFragment

class MapFragment(private var filter: SearchFilter, private var latLngToLook:LatLng) : Fragment(), OnMapReadyCallback {



    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap


        val houses = db.getFilterHousesByFilter(filter)

        for(house in houses)
        {
            val macLatLng = house.geoLocation
            mMap.addMarker(MarkerOptions().position(macLatLng).title(house.id)) //SHow the title with the price in showInfoWindow
        }


        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngToLook))
        mMap.setMinZoomPreference(15.0f)


        mMap.setOnMarkerClickListener { marker ->

                val id = marker.title.toInt()
                val house = db.getHouseById(marker.title.toInt())
                val titleWithPrice = "$${house?.price}"
                marker.title = titleWithPrice
                marker.showInfoWindow()
                marker.title = id.toString()

                openAlertDialog(house,id)

            true
        }
    }

    private fun openAlertDialog(house: House?, id: Int)
    {
        val builder = AlertDialog.Builder(this@MapFragment.context!!)

        // Set the alert dialog title
        builder.setTitle("Description")
        // Display a message on alert dialog
        builder.setMessage("${house?.address}\n\n$${house?.price}\n\n${house?.shortDescription}")

        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton("Details"){ _, _ ->
            // Do something when user press the positive button
            val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.addToBackStack(null)

            val detailHouseFragment = HousesDetailFragment.newInstance(id)
            fragmentTransaction?.replace(R.id.fragmentLayout,detailHouseFragment)
            fragmentTransaction?.commit()
        }

        // Display a neutral button on alert dialog
        builder.setNeutralButton("Close"){_,_ ->
        }

        // Finally, make the alert dialog using builder
        val dialog: AlertDialog = builder.create()

        // Display the alert dialog on app interface
        dialog.show()
    }

    private lateinit var mMap: GoogleMap
    private val db : MockDataBase = MockDataBase()



    companion object {
        fun newInstance(filter: SearchFilter, latLngToLook : LatLng) = MapFragment(filter,latLngToLook)
    }

    private lateinit var viewModel: MapViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.map_fragment, container, false)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MapViewModel::class.java)



        // TODO: Use the ViewModel
    }

}
