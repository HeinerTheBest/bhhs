package com.mobileapps.bhhslux.views.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.adapters.TopFiveAdapter
import com.mobileapps.bhhslux.model.searchfilter.SearchFilter
import com.mobileapps.bhhslux.views.fragments.accessibility.AccessibilityFragment
import com.mobileapps.bhhslux.views.fragments.contact.ContactFragment
import com.mobileapps.bhhslux.views.fragments.login.LoginFragment
import com.mobileapps.bhhslux.views.fragments.showhouses.ShowHousesFragment
import com.mobileapps.bhhslux.views.fragments.sortby.SortByFragment
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.content_base.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private var mSectionsPagerAdapter: PagerAdapter? = null
    private val fragmentManager = supportFragmentManager
    private val CALL_REQUEST_CODE = 101



    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme) //Set The splash
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        nav_view.setNavigationItemSelectedListener(this)

        //Todo 01 Don't delete this
        mSectionsPagerAdapter = TopFiveAdapter(supportFragmentManager)
        topFiveContainerForPictures.adapter = mSectionsPagerAdapter
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


    //Generic OnClick
    fun onClick(view : View)
    {
        when (view.id)
        {
            R.id.imgBurgerButton ->  drawer_layout.openDrawer(GravityCompat.START)

            R.id.imgCloseButton  ->  drawer_layout.closeDrawer(Gravity.LEFT)

            R.id.btnBack         ->  fragmentManager.popBackStack()

            R.id.btnShare        ->  shareLinkPlayStore()

            R.id.btnContact      ->  showContactDialog()

            R.id.btnCall         ->  callContact()

            R.id.btnEmailToSee   ->  sendHelpEmail() //Todo can do better

            R.id.btnSort         ->  showSortDialog()
        }
    }

    private fun showSortDialog() {
        val sortFragment = SortByFragment()
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
                val showNearbyHousesForSale = ShowHousesFragment.newInstance(SearchFilter(nearbyForSale = true))
                replaceFragment(showNearbyHousesForSale)
            }
            R.id.nav_new_to_market -> {
                val showNearbyHousesForSale = ShowHousesFragment.newInstance(SearchFilter(newToMarket = true))
                replaceFragment(showNearbyHousesForSale)
            }
            R.id.nav_price_changes -> {
                val showNearbyHousesForSale = ShowHousesFragment.newInstance(SearchFilter(priceChanged = true))
                replaceFragment(showNearbyHousesForSale)
            }
            R.id.nav_open_houses -> {
                val showNearbyHousesForSale = ShowHousesFragment.newInstance(SearchFilter(openHouse = true))
                replaceFragment(showNearbyHousesForSale)
            }
            R.id.nav_nearby_for_rent -> {
                val showNearbyHousesForSale = ShowHousesFragment.newInstance(SearchFilter(nearbyForRent = true))
                replaceFragment(showNearbyHousesForSale)
            }
            R.id.nav_recently_sold -> {
                val showNearbyHousesForSale = ShowHousesFragment.newInstance(SearchFilter(nearbyRecentlySold = true))
                replaceFragment(showNearbyHousesForSale)
            }
            R.id.nav_advanced_search -> {

            }
            R.id.nav_find_agent_office -> {

            }
            R.id.nav_saved_properties -> {
                //todo validate if the user is logging
            }
            R.id.nav_saved_searches -> {

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



    private fun shareLinkPlayStore()
    {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type=getString(R.string.type_link)
        shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.link_share))
        startActivity(Intent.createChooser(shareIntent,""))
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
