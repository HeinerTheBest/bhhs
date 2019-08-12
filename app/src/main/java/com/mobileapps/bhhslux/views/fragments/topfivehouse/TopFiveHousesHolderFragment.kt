package com.mobileapps.bhhslux.views.fragments.topfivehouse

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mobileapps.bhhslux.R
import com.mobileapps.bhhslux.model.datasource.remote.mock.MockDataBase
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_main.view.*

class TopFiveHousesHolderFragment : Fragment() {

    private val db : MockDataBase = MockDataBase()


    @SuppressLint("SetTextI18n")
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


        val houses = db.getHouses(5)

        for(i in 0..5)
        {
            if (arguments!!.getInt(ARG_SECTION_NUMBER) == i+1) {
                rootView.tvPrice.text = "$${houses[i].price}"
                rootView.imgPicture.setImageResource(R.drawable.housedemo)
                rootView.tvHouseAddress.text = houses[i].address
                rootView.tvDescription.text = houses[i].shortDescription
                rootView.tvIndex.text = indexText
                Picasso.with(context).load(houses[i].imagePatch).placeholder(R.drawable.housedemo).into(rootView.imgPicture)
            }
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