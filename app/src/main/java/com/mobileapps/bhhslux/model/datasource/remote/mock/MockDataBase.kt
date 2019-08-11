package com.mobileapps.bhhslux.model.datasource.remote.mock

import com.mobileapps.bhhslux.model.house.House
import com.mobileapps.bhhslux.model.searchfilter.SearchFilter
import com.mobileapps.bhhslux.views.fragments.showhouses.ShowHousesViewModel

class MockDataBase
{



    fun getAllHouses(): ArrayList<House> {
        val listHouses = arrayListOf<House>()

        listHouses.add(House("1", 1350  , null      ,"1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166", "4bd 3 ba", "https://i.ytimg.com/vi/Xx6t0gmQ_Tw/maxresdefault.jpg"                                                             ,"For Sale"     ,true ,true  ,true))
        listHouses.add(House("2", 399900, 450000    ,"1590 Arden Drive SW Marietta, GA 30008-3731"             , "3bd 2 ba", "https://assets.themortgagereports.com/wp-content/uploads/2017/12/How-to-Buy-a-House-with-Low-Income-This-Year.jpg","For Sale"     ,false,true  ,false))
        listHouses.add(House("3", 310000, null      ,"1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166", "4bd 3 ba", "https://cdn.decorpad.com/photos/2017/09/19/8e667843102e.jpg"                                                      ,"For Rent"     ,true ,false ,true))
        listHouses.add(House("4", 295775, null      ,"1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166", "4bd 3 ba", "https://upload.wikimedia.org/wikipedia/commons/d/d8/SaltBoxHouse1.jpg"                                            ,"Recently Sold",false,false ,false))
        listHouses.add(House("5", 399900, 470000    ,"1590 Arden Drive SW Marietta, GA 30008-3731"             , "3bd 2 ba", "https://assets.themortgagereports.com/wp-content/uploads/2017/12/How-to-Buy-a-House-with-Low-Income-This-Year.jpg","For Sale"     ,false,true  ,false))
        listHouses.add(House("6", 310000, null      ,"1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166", "4bd 3 ba", "https://cdn.decorpad.com/photos/2017/09/19/8e667843102e.jpg"                                                      ,"For Rent"     ,true ,false ,true))
        listHouses.add(House("7", 295775, null      ,"1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166", "4bd 3 ba", "https://upload.wikimedia.org/wikipedia/commons/d/d8/SaltBoxHouse1.jpg"                                            ,"Recently Sold",false,false ,false))
        listHouses.add(House("8", 310000, null      ,"1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166", "4bd 3 ba", "https://cdn.decorpad.com/photos/2017/09/19/8e667843102e.jpg"                                                      ,"For Rent"     ,true ,false ,true))
        listHouses.add(House("9", 295775, null      ,"1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166", "4bd 3 ba", "https://upload.wikimedia.org/wikipedia/commons/d/d8/SaltBoxHouse1.jpg"                                            ,"Recently Sold",false,false ,false))
        listHouses.add(House("10",399900, 550200    ,"1590 Arden Drive SW Marietta, GA 30008-3731"             , "3bd 2 ba", "https://assets.themortgagereports.com/wp-content/uploads/2017/12/How-to-Buy-a-House-with-Low-Income-This-Year.jpg","For Sale"     ,false,true  ,false))

        return listHouses
    }


    fun getHouses(i : Int) : ArrayList<House> {
        val houses = getAllHouses()
        val arrayListToReturn = ArrayList<House>()

        for (index in 0 .. i)
        {
            arrayListToReturn.add(houses[index])
        }

        return arrayListToReturn
    }


    fun getFilterHousesByFilter(filter : SearchFilter): ArrayList<ShowHousesViewModel> {
        val houses = getAllHouses()
        val arrayListToReturn = ArrayList<ShowHousesViewModel>()

        for (house in houses)
        {
            if(validateHouseWithFilter(house,filter))
                arrayListToReturn.add(ShowHousesViewModel(house))
        }
        return arrayListToReturn
    }

    private fun validateHouseWithFilter(house: House, filter: SearchFilter) : Boolean
    {
        if (filter.justSearchType)
            return validateJustSearchType(house,filter)

        if(filter.newToMarket && !isTheHouseNewInTheMarke(house))
            return false

        if(filter.openHouse && !isTheHouseAopenHouse(house))
            return false

        if(filter.priceChanged && !theHouseChangeValue(house))
            return false

        if(!filter.nearbyForSale      && house.searchType == "For Sale")      return false
        if(!filter.nearbyForRent      && house.searchType == "For Rent")      return false
        if(!filter.nearbyRecentlySold && house.searchType == "Recently Sold") return false

        return true
    }

    private fun validateJustSearchType(house: House, filter: SearchFilter) : Boolean
    {
        if(!filter.nearbyForSale      && house.searchType == "For Sale")      return false
        if(!filter.nearbyForRent      && house.searchType == "For Rent")      return false
        if(!filter.nearbyRecentlySold && house.searchType == "Recently Sold") return false

        return true
    }

    private fun theHouseChangeValue(house: House):Boolean
    {
        return house.oldPrice != null
    }

    private fun isTheHouseAopenHouse(house: House) : Boolean
    {
        return house.isOpenHouse
    }

    private fun isTheHouseNewInTheMarke(house: House) : Boolean
    {
        return house.isNewToMarket
    }
}