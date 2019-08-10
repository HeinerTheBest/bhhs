package com.mobileapps.bhhslux.views.fragments.topfivehouse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mobileapps.bhhslux.R
import kotlinx.android.synthetic.main.fragment_main.view.*

class TopFiveHousesHolderFragment : Fragment() {

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
        fun newInstance(sectionNumber: Int): TopFiveHousesHolderFragment {
            val fragment = TopFiveHousesHolderFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }

}