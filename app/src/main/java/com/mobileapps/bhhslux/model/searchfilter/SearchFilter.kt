package com.mobileapps.bhhslux.model.searchfilter

class SearchFilter(

        var justSearchType     : Boolean = false,
        var nearbyForSale      : Boolean = false,
        var newToMarket        : Boolean = false,
        var priceChanged       : Boolean = false,
        var openHouse          : Boolean = false,
        var nearbyForRent      : Boolean = false,
        var nearbyRecentlySold : Boolean = false,
        var all                : Boolean = false,
        var advanced           : Boolean = false,
        var minimumPrice       : Int?    = null,
        var maxPrice           : Int?    = null,
        var manyBeds           : Int?    = null,
        var manyBaths          : Int?    = null,
        var status             : Boolean = true



)
