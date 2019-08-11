package com.mobileapps.bhhslux.model.house

class House(

    var id               : String  = "",
    var price            : String  = "",
    var oldPrice         : String? = null,
    var address          : String  = "", // Change to object address
    var shortDescription : String  = "",
    var imagePatch       : String  = "",
    var searchType       : String  = "For Sale",   // Can be  (For Sale) (For Rent) (Recently Sold)
    var isNewToMarket    : Boolean = false,
    var isOpenHouse      : Boolean = false,
    var isActive         : Boolean = false

)



//Properties can be
//