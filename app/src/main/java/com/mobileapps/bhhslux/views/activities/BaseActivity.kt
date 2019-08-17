package com.mobileapps.bhhslux.views.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.model.LatLng
import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.adapters.TopFiveAdapter
import com.mobileapps.bhhslux.model.searchfilter.SearchFilter
import com.mobileapps.bhhslux.views.fragments.map.MapFragment
import com.mobileapps.bhhslux.views.fragments.accessibility.AccessibilityFragment
import com.mobileapps.bhhslux.views.fragments.advancedsearch.AdvancedSearchFragment
import com.mobileapps.bhhslux.views.fragments.contact.ContactFragment
import com.mobileapps.bhhslux.views.fragments.auth.login.LoginFragment
import com.mobileapps.bhhslux.views.fragments.showhouses.ShowHousesFragment
import com.mobileapps.bhhslux.views.fragments.sortby.SortByFragment
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.content_base.*
import kotlinx.android.synthetic.main.fragment_head_nav.*
import java.lang.Exception
import java.lang.IllegalStateException

class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private val mSectionsPagerAdapter = TopFiveAdapter(supportFragmentManager)
    private val fragmentManager = supportFragmentManager
    private val CALL_REQUEST_CODE = 101
    private lateinit var viewModel: BaseActivityViewModel
    private var searchFilter = SearchFilter()
    private var latLngToLook = LatLng(33.90957,-84.479215) //todo You location





    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme) //Set The splash
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        nav_view.setNavigationItemSelectedListener(this)

        //SetUp UI
        topFiveContainerForPictures.adapter = mSectionsPagerAdapter

        viewModel = ViewModelProviders.of(this).get(BaseActivityViewModel::class.java)


    }

    fun shareLinkPlayStore()
    {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type = getString(R.string.type_link)
        shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.link_share))
        startActivity(Intent.createChooser(shareIntent,""))
    }


    //Permission to call
    private fun makeRequest() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CALL_PHONE),
                CALL_REQUEST_CODE)
    }


    //Navigation Drawer
    private fun replaceFragment(fragment:Fragment)
    {
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentLayout,fragment)
                .addToBackStack(fragment.tag)
                .commit()
    }


    //Generic OnClick to remove with MVVM
    fun onClick(view : View)
    {
        when (view.id)
        {
            R.id.imgBurgerButton ->  drawer_layout.openDrawer(GravityCompat.START)

            R.id.imgCloseButton  ->  drawer_layout.closeDrawer(Gravity.LEFT)

            R.id.btnBack         ->  closeFragment()

            R.id.btnShare        ->  shareLinkPlayStore()

            R.id.btnContact      ->  showContactDialog()

            R.id.btnCall         ->  callContact()

            R.id.btnEmailToSee   ->  sendHelpEmail() //Todo can do better

            R.id.btnSort         ->  showSortDialog()

            R.id.btnMap          -> openMap()

            R.id.btnRecycler    ->  closeFragment()

            R.id.btnRefine      -> openAdvanceSearch()

            R.id.btnSearch      -> openMapInThisLocation()
        }
    }

    private fun openMapInThisLocation() {
        if(etSearchHouses.text.isEmpty())
        {
            Toast.makeText(this,"You need to add a valid address",Toast.LENGTH_SHORT).show()
        }
        else
        {
            getLatLngBasedOfAddress(etSearchHouses.text.toString())?.let {
                searchFilter = SearchFilter(all = true)
                latLngToLook = it
                etSearchHouses.text.clear()
                drawer_layout.closeDrawers()
                val mapFragment = MapFragment.newInstance(searchFilter, latLngToLook)
                replaceFragment(mapFragment)
            }
        }
    }





    private fun getLatLngBasedOfAddress(address : String):LatLng?
    {
        val geoCoder = Geocoder(this)
        return try {
            val addressInfo = geoCoder.getFromLocationName(address,1)[0]
            LatLng(addressInfo.latitude,addressInfo.longitude)
        }
        catch (e: Exception)
        {
            Toast.makeText(this,"You need to add a valid address",Toast.LENGTH_LONG).show()
            Log.d("Heiner","NuUUUULLLL")
            null
        }
    }

    private fun openAdvanceSearch() {
        val advancedSearch = AdvancedSearchFragment.newInstance()
        replaceFragment(advancedSearch)
    }

    private fun openMap() {
        val mapFragment = MapFragment.newInstance(searchFilter,latLngToLook)
        replaceFragment(mapFragment)
    }

    fun closeFragment()
    {
        fragmentManager.popBackStack()
    }

    private fun showSortDialog() {
        val sortFragment = SortByFragment.newInstance()
        sortFragment.show(supportFragmentManager, "sort_fragment")
    }


    private fun showContactDialog() {
        val contactFragment = ContactFragment()
        contactFragment.show(supportFragmentManager, "contact_fragment")
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_nearby_house_for_sale -> {
                searchFilter = SearchFilter(nearbyForSale = true,justSearchType = true)
                val showNearbyHousesForSale = ShowHousesFragment.newInstance(searchFilter)
                replaceFragment(showNearbyHousesForSale)
            }
            R.id.nav_new_to_market -> {
                searchFilter = SearchFilter(newToMarket = true, nearbyRecentlySold = true, nearbyForRent = true, nearbyForSale = true)
                val showNearbyHousesForSale = ShowHousesFragment.newInstance(searchFilter)
                replaceFragment(showNearbyHousesForSale)
            }
            R.id.nav_price_changes -> {
                searchFilter = SearchFilter(priceChanged = true, nearbyRecentlySold = true, nearbyForRent = true, nearbyForSale = true)
                val showNearbyHousesForSale = ShowHousesFragment.newInstance(searchFilter)
                replaceFragment(showNearbyHousesForSale)
            }
            R.id.nav_open_houses -> {
                searchFilter = SearchFilter(openHouse = true, nearbyRecentlySold = true, nearbyForRent = true, nearbyForSale = true)
                val showNearbyHousesForSale = ShowHousesFragment.newInstance(searchFilter)
                replaceFragment(showNearbyHousesForSale)
            }
            R.id.nav_nearby_for_rent -> {
                searchFilter = SearchFilter(nearbyForRent = true,justSearchType = true)
                val showNearbyHousesForSale = ShowHousesFragment.newInstance(searchFilter)
                replaceFragment(showNearbyHousesForSale)
            }
            R.id.nav_recently_sold -> {
                searchFilter = SearchFilter(nearbyRecentlySold = true,justSearchType = true)
                val showNearbyHousesForSale = ShowHousesFragment.newInstance(searchFilter)
                replaceFragment(showNearbyHousesForSale)
            }
            R.id.nav_advanced_search -> {
                openAdvanceSearch()
            }
            R.id.nav_find_agent_office -> {

            }
            R.id.nav_saved_properties -> {
                //todo validate if the user is logging
            }
            R.id.nav_saved_searches -> {
                //todo validate if the user is logging
            }
            R.id.nav_share -> {
                shareLinkPlayStore()
            }
            R.id.nav_app_help -> {
                sendHelpEmail()
            }
            R.id.nav_login -> {
                val login = LoginFragment.newInstance()
                replaceFragment(login)
            }
            R.id.nav_accessibility -> {
                val accessibility = AccessibilityFragment.newInstance()
                replaceFragment(accessibility)
            }
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }






    private fun callContact() {
        val permission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i("Heiner", "Permission to record denied")
            makeRequest()
        }
        else
        {
            val callIntent = Intent(Intent.ACTION_CALL, Uri.parse(getString(R.string.number_phone_to_call)))
            startActivity(callIntent)
        }
    }




    private fun sendHelpEmail()
    {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse(getString(R.string.email_to))
        intent.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.email_subject))
        intent.putExtra(Intent.EXTRA_TEXT,getString(R.string.email_text))

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }




}
