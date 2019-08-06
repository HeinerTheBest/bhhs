package com.mobileapps.bhhslux.views.activities

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.views.fragments.ShowHousesFragment
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.content_base.*
import kotlinx.android.synthetic.main.fragment_main.view.*

class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private var mSectionsPagerAdapter: PagerAdapter? = null
    private val fragmentManager = getSupportFragmentManager()



    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme) //Set The splash
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)



        nav_view.setNavigationItemSelectedListener(this)

        //Todo 01 Don't delete this
        mSectionsPagerAdapter = PagerAdapter(supportFragmentManager)
        containerForPictures.adapter = mSectionsPagerAdapter





    }

    fun close(view : View)
    {
        fragmentManager.popBackStack()
    }

    private fun replaceFragment(fragment:Fragment)
    {
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentLayout,fragment)
                .addToBackStack(fragment.tag)
                .commit()
    }


    //Todo 02 don't delete this here we set the view Pager
    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1)
        }

        override fun getCount(): Int {
            // Show 5 total pages.(we will use 5 pages so change it to 5)
            return 5
        }
    }



    //Todo 03 Don't delete this is the clss for the sectionsPagerAdapter
    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {

        override fun onCreateView(
                inflater: LayoutInflater, container: ViewGroup?,
                savedInstanceState: Bundle?
        ): View? {
            val rootView = inflater.inflate(R.layout.fragment_main, container, false)
            /*since our views are in fragment_main.xml which is inflated in rootView
              so we have to write rootView.oursomeview
              otherwise it will try to find the view in activity_main.xml so app will crash*/
            //handle swipe/slide

            val indexText = arguments!!.getInt(ARG_SECTION_NUMBER).toString()+" of 5"


            if (arguments!!.getInt(ARG_SECTION_NUMBER) == 1) {
                rootView.tvPrice.text = "$619,000"
                rootView.imgPicture.setImageResource(R.drawable.housedemo)
                rootView.tvHouseAddress.text = "337 Oak Grove Island Drive Brunswick, GA 31523"
                rootView.tvDescription.text = "5bd 5ba"
                rootView.tvIndex.text = indexText
            }
            if (arguments!!.getInt(ARG_SECTION_NUMBER) == 2) {
                rootView.tvPrice.text = "$2,500,000"
                rootView.imgPicture.setImageResource(R.drawable.housedemo)
                rootView.tvHouseAddress.text = "328 Cedar Bank Riad St, GA 31523"
                rootView.tvDescription.text = "2bd 3.5ba"
                rootView.tvIndex.text = indexText
            }
            if (arguments!!.getInt(ARG_SECTION_NUMBER) == 3) {
                rootView.tvPrice.text = "$300,00"
                rootView.imgPicture.setImageResource(R.drawable.housedemo)
                rootView.tvHouseAddress.text = "337 Oak Grove Island Drive Brunswick, GA 31523"
                rootView.tvDescription.text = "5bd 5ba"
                rootView.tvIndex.text = indexText
            }
            if (arguments!!.getInt(ARG_SECTION_NUMBER) == 4) {
                rootView.tvPrice.text = "$619,000"
                rootView.imgPicture.setImageResource(R.drawable.housedemo)
                rootView.tvHouseAddress.text = "337 Oak Grove Island Drive Brunswick, GA 31523"
                rootView.tvDescription.text = "5bd 5ba"
                rootView.tvIndex.text = indexText
            }
            if (arguments!!.getInt(ARG_SECTION_NUMBER) == 5) {
                rootView.tvPrice.text = "$619,000"
                rootView.imgPicture.setImageResource(R.drawable.housedemo)
                rootView.tvHouseAddress.text = "337 Oak Grove Island Drive Brunswick, GA 31523"
                rootView.tvDescription.text = "5bd 5ba"
                rootView.tvIndex.text = indexText
            }
            return rootView
        }

        //Todo 04 the object class
        companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private val ARG_SECTION_NUMBER = "section_number"

            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }

    }


    fun onClick(view : View)
    {
        when (view.id)
        {
            R.id.imgBurgerButton ->  drawer_layout.openDrawer(GravityCompat.START)

            R.id.imgCloseButton ->  drawer_layout.closeDrawer(Gravity.LEFT)

        }
    }









    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_nearby_house_for_sale -> {
                val showNearbyHousesForSale = ShowHousesFragment.newInstance()
                replaceFragment(showNearbyHousesForSale)
            }
            R.id.nav_new_to_market -> {

            }
            R.id.nav_price_changes -> {

            }
            R.id.nav_open_houses -> {

            }
            R.id.nav_nearby_for_rent -> {

            }
            R.id.nav_sold -> {

            }
            R.id.nav_advanced_search -> {

            }
            R.id.nav_find_agent_office -> {

            }
            R.id.nav_saved_properties -> {

            }
            R.id.nav_saved_searches -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_app_help -> {

            }
            R.id.nav_login -> {

            }
            R.id.nav_accessibility -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
