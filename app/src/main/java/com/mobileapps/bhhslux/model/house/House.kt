package com.mobileapps.bhhslux.model.house

class House
{
    var id    =            ""
    var price =            ""
    var address =          ""
    var status =           ""
    var shortDescription = ""
    var imagePatch       = ""

    constructor(id: String, price: String, address: String, status: String, shortDescription: String, imagePatch : String) {
        this.id = id
        this.price = price
        this.address = address
        this.status = status
        this.shortDescription = shortDescription
        this.imagePatch = imagePatch
    }
}