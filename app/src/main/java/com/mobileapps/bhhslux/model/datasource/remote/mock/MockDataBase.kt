package com.mobileapps.bhhslux.model.datasource.remote.mock

import android.util.Log
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.database.*
import com.mobileapps.bhhslux.model.house.House
import com.mobileapps.bhhslux.model.searchfilter.SearchFilter
import com.mobileapps.bhhslux.views.fragments.showhouses.ShowHousesViewModel

class MockDataBase
{

   //todo delete private var database = FirebaseDatabase.getInstance().reference
    //private val myRef    = database.getReference("houses")


    fun getAllHouses() : ArrayList<House> {
        val listHouses = arrayListOf<House>()

        listHouses.add(House("5", 399900, 470000    ,"1775 The Exchange SE #200, Atlanta, GA 30339"            , 33.9082112,-84.481082, "3bd 2 ba", "https://pmcvariety.files.wordpress.com/2018/07/bradybunchhouse_sc11.jpg?w=1000&h=563&crop=1","For Sale"     ,false,true  ,true))
        listHouses.add(House("1", 1350  , null      ,"1815 The Exchange SE, Atlanta, GA 30339"                 , 33.909243,-84.4803857, "4bd 3 ba", "https://i.ytimg.com/vi/Xx6t0gmQ_Tw/maxresdefault.jpg"                                                             ,"For Sale"     ,true ,true  ,true))
        listHouses.add(House("2", 399900, 450000    ,"1849 The Exchange SE # 200, Atlanta, GA 30339"           , 33.9090115,-84.4801926, "3bd 2 ba", "https://assets.themortgagereports.com/wp-content/uploads/2017/12/How-to-Buy-a-House-with-Low-Income-This-Year.jpg","For Sale"     ,false,true  ,false))
        listHouses.add(House("3", 310000, null      ,"1820 The Exchange SE, Atlanta, GA 30339"                 , 33.9075434,-84.4821763, "4bd 3 ba", "https://cdn.decorpad.com/photos/2017/09/19/8e667843102e.jpg"                                                      ,"For Rent"     ,true ,false ,true))
        listHouses.add(House("4", 295775, null      ,"1770 The Exchange SE Suite 200, Atlanta, GA 30339"       , 33.9075434,-84.4821763, "4bd 3 ba", "https://upload.wikimedia.org/wikipedia/commons/d/d8/SaltBoxHouse1.jpg"                                            ,"Recently Sold",false,false ,false))
        listHouses.add(House("11",436000, null      ,"1651 Massachusetts St SW, Marietta, GA 30008"            , 33.9128652,-84.5723727, "2bd 1 ba", "https://images.adsttc.com/media/images/59a4/c624/b22e/389d/3e00/02a3/newsletter/MHA.JR_201708_038.jpg?1503970808"                                                      ,"For Rent"     ,true ,false ,true))
        listHouses.add(House("10",399900, 550200    ,"2475 Windy Hill Rd SE, Marietta, GA 30067"               , 33.9061354,-84.4819092, "3bd 2 ba", "https://www.eliteholidayhomes.com.au/wp-content/uploads/2018/08/banner2.jpg","For Sale"     ,false,true  ,false))
        listHouses.add(House("6", 310000, null      ,"1755 The Exchange SE #204, Atlanta, GA 30339"            , 33.9093587,-84.4819307, "4bd 3 ba", "https://static.dezeen.com/uploads/2017/08/clifton-house-project-architecture_dezeen_hero-1.jpg"                                                      ,"For Rent"     ,true ,false ,true))
        listHouses.add(House("7", 295775, null      ,"1760 The Exchange SE, Atlanta, GA 30339"                 , 33.9093587,-84.4819307, "4bd 3 ba", "https://amp.businessinsider.com/images/5d1b6f31a17d6c27a5698704-750-562.jpg"                                            ,"Recently Sold",false,false ,false))
        listHouses.add(House("8", 310000, null      ,"1995 N Park Pl SE # 425, Atlanta, GA 30339"              , 33.9061354,-84.4819092, "4bd 3 ba", "https://freshome.com/wp-content/uploads/2018/09/contemporary-exterior.jpg"                                                      ,"For Rent"     ,true ,false ,true))
        listHouses.add(House("9", 295775, null      ,"2000 S Park Pl NW, Atlanta, GA 30339"                    , 33.9061354,-84.4819092, "4bd 3 ba", "https://indaily.com.au/wp-content/uploads/2019/04/Screen-Shot-2019-04-12-at-8.04.06-am-850x455.png"                                            ,"Recently Sold",false,false ,false))

        return listHouses
    }

    fun populateFireBase()
    {
        val availableHouses: List<House> = mutableListOf(
                House("1", 1350  , null      ,"1815 The Exchange SE, Atlanta, GA 30339"                 , 33.909243,-84.4803857, "4bd 3 ba" , "https://i.ytimg.com/vi/Xx6t0gmQ_Tw/maxresdefault.jpg"                                                             ,"For Sale"     ,true ,true  ,true),
                House("2", 399900, 450000    ,"1849 The Exchange SE # 200, Atlanta, GA 30339"           , 33.9090115,-84.4801926, "3bd 2 ba", "https://assets.themortgagereports.com/wp-content/uploads/2017/12/How-to-Buy-a-House-with-Low-Income-This-Year.jpg","For Sale"     ,false,true  ,false),
                House("3", 310000, null      ,"1820 The Exchange SE, Atlanta, GA 30339"                 , 33.9075434,-84.4821763, "4bd 3 ba", "https://cdn.decorpad.com/photos/2017/09/19/8e667843102e.jpg"                                                      ,"For Rent"     ,true ,true ,true),
                House("4", 295775, null      ,"1770 The Exchange SE Suite 200, Atlanta, GA 30339"       , 33.9075434,-84.4821763, "4bd 3 ba", "https://upload.wikimedia.org/wikipedia/commons/d/d8/SaltBoxHouse1.jpg"                                            ,"Recently Sold",false,false ,false),
                House("5", 399900, 470000    ,"1775 The Exchange SE #200, Atlanta, GA 30339"            , 33.9082112,-84.481082, "3bd 2 ba" , "https://pmcvariety.files.wordpress.com/2018/07/bradybunchhouse_sc11.jpg?w=1000&h=563&crop=1","For Sale"     ,false,true  ,false),
                House("6", 310000, null      ,"1755 The Exchange SE #204, Atlanta, GA 30339"            , 33.9093587,-84.4819307, "4bd 3 ba", "https://static.dezeen.com/uploads/2017/08/clifton-house-project-architecture_dezeen_hero-1.jpg"                                                      ,"For Rent"     ,true ,false ,true),
                House("7", 295775, null      ,"1760 The Exchange SE, Atlanta, GA 30339"                 , 33.9093587,-84.4819307, "4bd 3 ba", "https://freshome.com/wp-content/uploads/2018/09/contemporary-exterior.jpg"                                            ,"Recently Sold",false,false ,false),
                House("8", 310000, null      ,"1995 N Park Pl SE # 425, Atlanta, GA 30339"              , 33.9061354,-84.4819092, "4bd 3 ba", "https://indaily.com.au/wp-content/uploads/2019/04/Screen-Shot-2019-04-12-at-8.04.06-am-850x455.png"                                                      ,"For Rent"     ,true ,false ,true),
                House("9", 295775, null      ,"2000 S Park Pl NW, Atlanta, GA 30339"                    , 33.9061354,-84.4819092, "4bd 3 ba", "https://amp.businessinsider.com/images/5d1b6f31a17d6c27a5698704-750-562.jpg"                                            ,"Recently Sold",false,false ,false),
                House("10",399900, 550200    ,"2475 Windy Hill Rd SE, Marietta, GA 30067"               , 33.9061354,-84.4819092, "3bd 2 ba", "https://www.eliteholidayhomes.com.au/wp-content/uploads/2018/08/banner2.jpg","For Sale"     ,false,true  ,false),
                House("11",436000, null      ,"1651 Massachusetts St SW, Marietta, GA 30008"            , 33.9128652,-84.5723727, "2bd 1 ba", "https://images.adsttc.com/media/images/59a4/c624/b22e/389d/3e00/02a3/newsletter/MHA.JR_201708_038.jpg?1503970808"                                                      ,"For Rent"     ,true ,false ,true)
        )
        availableHouses.forEach {
         //todo delete   database.child("houses").child(it.id).setValue(it)
        }
    }



    fun demo(callBack : CallBack)
    {
        val houses: MutableList<House> = mutableListOf()

        val menuListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataSnapshot.children.mapNotNullTo(houses) { it.getValue<House>(House::class.java) }

                Log.d("Heiner", "Adding $houses")
                Log.d("Heiner", "Details are ${houses[0].listingDetails.county}")
                callBack.getHouses(houses as ArrayList<House>)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                println("loadPost:onCancelled ${databaseError.toException()}")
            }
        }
        //todo delete database.child("houses").addListenerForSingleValueEvent(menuListener)

        for (men in houses) {
            Log.d("Heiner", "THe menu has ${men.price}\n")
        }

        Log.d("Heiner", "The ENd")
    }

    fun getHouseById(i : Int) : House?
    {
        for (house in getAllHouses()) if (house.id.toInt() == i) return house
        return  null
    }

    fun getHouses(i : Int) : ArrayList<House> {
        val houses = getAllHouses()
        val arrayListToReturn = ArrayList<House>()
        for (index in 0 .. i) { arrayListToReturn.add(houses[index]) }
        return arrayListToReturn
    }


    fun getFilterHousesByFilter(filter : SearchFilter, fragmentTransaction2 : FragmentTransaction?,opc : Int): ArrayList<ShowHousesViewModel> {
        val houses = getAllHouses()
        val arrayListToReturn = ArrayList<ShowHousesViewModel>()

        when(opc)
        {
            1 -> houses.sortBy {it.price}
            2 -> houses.sortByDescending {it.price  }
        }

        for (house in houses)
        {
            if(validateHouseWithFilter(house,filter))
                arrayListToReturn.add(ShowHousesViewModel(house,fragmentTransaction2))
        }
        return arrayListToReturn
    }





    fun getFilterHousesByFilter(filter : SearchFilter): ArrayList<House> {
        val houses = getAllHouses()
        val arrayListToReturn = ArrayList<House>()

        for (house in houses)
        {
            if(validateHouseWithFilter(house,filter))
                arrayListToReturn.add(house)
        }
        return arrayListToReturn
    }

    private fun validateHouseWithFilter(house: House, filter: SearchFilter) : Boolean
    {
        if(filter.advanced)
            return validateAdvancedSearch(house,filter)

        if (filter.all)
            return true

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

    private fun validateAdvancedSearch(house: House, filter: SearchFilter): Boolean {

        if(!filter.nearbyForSale      && house.searchType == "For Sale")      return false
        if(!filter.nearbyForRent      && house.searchType == "For Rent")      return false
        if(!filter.nearbyRecentlySold && house.searchType == "Recently Sold") return false



        if(!filter.status == house.isActive) return false

        if(!filter.openHouse == house.isOpenHouse) return false

        if(!filter.priceChanged == (house.oldPrice!=null)) return false


        if(!filter.newToMarket == house.isNewToMarket) return false

        filter.minimumPrice?.let { if(it > house.price.toInt()) return false }

        filter.maxPrice?.let { if(it < house.price.toInt()) return false }

        filter.manyBeds?.let { if (it != house.listingDetails.beds) return false}

        filter.manyBaths?.let { if (it != house.listingDetails.fullBath) return false }


        return true
    }

     fun validateJustSearchType(house: House, filter: SearchFilter) : Boolean
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

    interface CallBack{
        fun getHouses(houses: ArrayList<House>)
    }


}

