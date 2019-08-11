package com.mobileapps.bhhslux.model.house

class ListingDetails
(
        var type             : String = "Farm",                   //Use this for filter by    Property type
        var subDivision      : String = "Creekwood - Townhome",
        var county           : String = "Cobb",
        var yearBuilt        : String = "1973",
        var highSchool       : String = "Osborne",
        var middleSchool     : String = "Smitha",
        var elementarySchool : String = "Cheatham Hill",
        var beds             : Int    =  3,
        var fullBath         : Int    =  2,
        var halfBath         : Int    =  1,
        var sqFt             : Int    =  2180,                   //Use this for filter by   Home Sqt
        var lotSize          : Double =  0.38,                   //Use this for filter by   Lot Size
        var taxesYear        : String = "$336/2018",
        var listingId        : String = "6549063",
        var listingProvided  : String = "Georgia Elite Realty Atlanta, LLC."

)