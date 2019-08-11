package com.mobileapps.bhhslux.model.datasource.remote.mock

import com.mobileapps.bhhslux.model.house.House
import com.mobileapps.bhhslux.model.searchfilter.SearchFilter
import com.mobileapps.bhhslux.views.fragments.showhouses.ShowHousesViewModel

class MockDataBase
{



    fun getAllHouses(): ArrayList<House> {
        val listHouses = arrayListOf<House>()

        listHouses.add(House("1", "$1,350"  , null      ,"1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166", "4bd 3 ba", "https://i.ytimg.com/vi/Xx6t0gmQ_Tw/maxresdefault.jpg"                                                             ,"For Sale"     ,true ,true  ,true))
        listHouses.add(House("2", "$399,900", "$450,000","1590 Arden Drive SW Marietta, GA 30008-3731"             , "3bd 2 ba", "https://assets.themortgagereports.com/wp-content/uploads/2017/12/How-to-Buy-a-House-with-Low-Income-This-Year.jpg","For Sale"     ,false,true  ,false))
        listHouses.add(House("3", "$310,000", null      ,"1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166", "4bd 3 ba", "https://cdn.decorpad.com/photos/2017/09/19/8e667843102e.jpg"                                                      ,"For Rent"     ,true ,false ,true))
        listHouses.add(House("4", "$295,775", null      ,"1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166", "4bd 3 ba", "https://upload.wikimedia.org/wikipedia/commons/d/d8/SaltBoxHouse1.jpg"                                            ,"Recently Sold",false,false ,false))

        return listHouses
    }

    fun getFilterHousesByFilter(filter : SearchFilter): ArrayList<ShowHousesViewModel> {
        val houses = getAllHouses()
        val arrayListToResturn = ArrayList<ShowHousesViewModel>()

        for (house in houses)
        {
            arrayListToResturn.add(ShowHousesViewModel(house))
        }

        return arrayListToResturn
    }




    fun getHouses(): ArrayList<ShowHousesViewModel> {


        val arrayList = ArrayList<ShowHousesViewModel>()


        val house1 = House("1", "$1,350"  , null      ,"1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166", "4bd 3 ba", "https://i.ytimg.com/vi/Xx6t0gmQ_Tw/maxresdefault.jpg"                                                             ,"For Sale"     ,true ,true  ,true)
        val house2 = House("2", "$399,900", "$450,000","1590 Arden Drive SW Marietta, GA 30008-3731"             , "3bd 2 ba", "https://assets.themortgagereports.com/wp-content/uploads/2017/12/How-to-Buy-a-House-with-Low-Income-This-Year.jpg","For Sale"     ,false,true  ,false)
        val house3 = House("3", "$310,000", null      ,"1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166", "4bd 3 ba", "https://cdn.decorpad.com/photos/2017/09/19/8e667843102e.jpg"                                                      ,"For Rent"     ,true ,false ,true)
        val house4 = House("4", "$295,775", null      ,"1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166", "4bd 3 ba", "https://upload.wikimedia.org/wikipedia/commons/d/d8/SaltBoxHouse1.jpg"                                            ,"Recently Sold",false,false ,false)


/*
        val showHousesViewModel1 = ShowHousesViewModel(house1)
        val showHousesViewModel2 = ShowHousesViewModel(house2)
        val showHousesViewModel3 = ShowHousesViewModel(house3)
        val showHousesViewModel4 = ShowHousesViewModel(house4)*/

        arrayList.add(ShowHousesViewModel(house1))
        arrayList.add(ShowHousesViewModel(house2))
        arrayList.add(ShowHousesViewModel(house3))
        arrayList.add(ShowHousesViewModel(house4))

        return arrayList
    }


}