package com.mobileapps.bhhslux.views.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.model.datasource.remote.mock.MockDataBase
import com.mobileapps.bhhslux.model.searchfilter.SearchFilter

class MapFragment(private var filter: SearchFilter) : Fragment(), OnMapReadyCallback {



    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

       /* // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))*/

        val houses = db.getFilterHousesByFilter(filter)

        for(house in houses)
        {
            val macLatLng = house.geoLocation
            mMap.addMarker(MarkerOptions().position(macLatLng).title("$${house.price}")).showInfoWindow() //SHow the title with the price in showInfoWindow
        }


        val macLatLng = LatLng(33.90957,-84.479215) //You location
        mMap.moveCamera(CameraUpdateFactory.newLatLng(macLatLng))
        mMap.setMinZoomPreference(15.0f)

    }

    private lateinit var mMap: GoogleMap
    private val db : MockDataBase = MockDataBase()



    companion object {
        fun newInstance(filter: SearchFilter) = MapFragment(filter)
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
