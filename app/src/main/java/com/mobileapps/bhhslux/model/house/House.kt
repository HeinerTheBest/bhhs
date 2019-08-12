package com.mobileapps.bhhslux.model.house

class House(

    var id               : String  = "",
    var price            : Int  = 0,
    var oldPrice         : Int? = null,
    var address          : String  = "", // Change to object address
    var shortDescription : String  = "",
    var imagePatch       : String  = "",
    var searchType       : String  = "For Sale",   // Can be  (For Sale) (For Rent) (Recently Sold)
    var isNewToMarket    : Boolean = false,
    var isOpenHouse      : Boolean = false,
    var isActive         : Boolean = false,
    var listingDetails   : ListingDetails = ListingDetails()


)
{

    fun getStatus() : String
    {
        var statusToReturn = searchType
        statusToReturn = if(isActive) "$statusToReturn - Active" else "$statusToReturn - Pending"
        return statusToReturn
    }


}

