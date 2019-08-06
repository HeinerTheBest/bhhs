package com.mobileapps.bhhslux.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobileapps.bhhslux.model.House

class ShowHousesViewModel : ViewModel
{
    var id    = ""
    var price = ""
    var address = ""
    var status = ""
    var shortDescription = ""
    var imagePatch       = ""


    constructor() : super()

    constructor(house : House) : super() {
        this.id               = house.id
        this.price            = house.price
        this.address          = house.address
        this.status           = house.status
        this.shortDescription = house.shortDescription
        this.imagePatch       = house.imagePatch
    }


    var arrayListMutableLiveData = MutableLiveData<ArrayList<ShowHousesViewModel>>()

    var arrayList = ArrayList<ShowHousesViewModel>()

    fun getArrayList() : MutableLiveData<ArrayList<ShowHousesViewModel>>
    {
        val house1 = House("1","$1,350","1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166","For Sale - Active","4bd 3 ba","https://i.ytimg.com/vi/Xx6t0gmQ_Tw/maxresdefault.jpg")
        val house2 = House("2","$399,900","1590 Arden Drive SW Marietta, GA 30008-3731","For Sale - Active","3bd 2 ba","http://nisartmacka.com/images/3.bp.blogspot.com/_X1QryFC2O28/TLDYMWzE4LI/AAAAAAAAAMM/14ZjpMgKveg/s1600/048.JPG")
        val house3 = House("3","$310,000","1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166","For Sale - Active","4bd 3 ba","https://cdn.decorpad.com/photos/2017/09/19/8e667843102e.jpg")
        val house4 = House("4","$295,775","1651 Massachussetts Avenue SW#17 Marietta, GA 30008-7166","For Sale - Active","4bd 3 ba","https://upload.wikimedia.org/wikipedia/commons/d/d8/SaltBoxHouse1.jpg")



        val showHousesViewModel1 : ShowHousesViewModel = ShowHousesViewModel(house1)
        val showHousesViewModel2 : ShowHousesViewModel = ShowHousesViewModel(house2)
        val showHousesViewModel3 : ShowHousesViewModel = ShowHousesViewModel(house3)
        val showHousesViewModel4 : ShowHousesViewModel = ShowHousesViewModel(house4)

        arrayList!!.add(showHousesViewModel1)
        arrayList!!.add(showHousesViewModel2)
        arrayList!!.add(showHousesViewModel3)
        arrayList!!.add(showHousesViewModel4)

        arrayListMutableLiveData.value = arrayList



        return arrayListMutableLiveData
    }


}
