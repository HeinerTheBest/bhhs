package com.mobileapps.bhhslux.model.house

import com.google.android.gms.maps.model.LatLng

data class House(
        var id               : String  = "",
        var price            : Long  = 0L,
        var oldPrice         : Long? = 0L,
        var address          : String  = "",
        var lat              : Double  = 0.0,
        var long             : Double  = 0.0,
        var shortDescription : String  = "",
        var imagePatch       : String  = "",
        var searchType       : String  = "For Sale",   // Can be  (For Sale) (For Rent) (Recently Sold)
        var isNewToMarket    : Boolean = true,
        var isOpenHouse      : Boolean = true,
        var isActive         : Boolean = true,
        var listingDetails   : ListingDetails = ListingDetails()
        )
{

    var geoLocation = LatLng(lat,long)

    fun getStatus() : String
    {
        var statusToReturn = searchType
        statusToReturn = if(isActive) "$statusToReturn - Active" else "$statusToReturn - Pending"
        return statusToReturn
    }

}

