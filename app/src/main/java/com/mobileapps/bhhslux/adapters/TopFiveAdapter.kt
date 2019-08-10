package com.mobileapps.bhhslux.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mobileapps.bhhslux.views.activities.BaseActivity
import com.mobileapps.bhhslux.views.fragments.topfivehouse.TopFiveHousesHolderFragment

class TopFiveAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm)
{
    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a TopFiveHousesHolderFragment (defined as a static inner class below).
        return TopFiveHousesHolderFragment.newInstance(position + 1)
    }

    override fun getCount(): Int {
        // Show 5 total pages.(we will use 5 pages so change it to 5)
        return 5
    }
}


