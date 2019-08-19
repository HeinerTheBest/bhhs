package com.mobileapps.bhhslux

import com.mobileapps.bhhslux.model.datasource.remote.mock.MockDataBase
import com.mobileapps.bhhslux.model.house.House
import com.mobileapps.bhhslux.model.searchfilter.SearchFilter
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ValidationHouseTest
{
    //Houses
    lateinit var houseForSale        : House
    lateinit var houseForRent        : House
    lateinit var houseRecentlySold   : House
    lateinit var houseNothing        : House

    lateinit var mockDataBase        : MockDataBase




    @Before
    fun setUp()
    {
        houseForSale      = House(searchType = "For Sale")
        houseForRent      = House(searchType = "For Rent")
        houseRecentlySold = House(searchType = "Recently Sold")
        houseNothing      = House(searchType = "")

        mockDataBase = MockDataBase()
    }

    @Test
    fun theHouseIsForSale()
    {
        Assert.assertTrue(mockDataBase.validateJustSearchType(houseForSale,SearchFilter(nearbyForSale = true)))
    }

    @Test
    fun theHouseIsNotForSale()
    {
        Assert.assertTrue(mockDataBase.validateJustSearchType(houseNothing,SearchFilter(nearbyForSale = true)))
    }

    @Test
    fun theHouseIsForRent()
    {
        Assert.assertTrue(mockDataBase.validateJustSearchType(houseForRent,SearchFilter(nearbyForRent = true)))
    }

    @Test
    fun theHouseIsNotForRent()
    {
        Assert.assertTrue(mockDataBase.validateJustSearchType(houseNothing,SearchFilter(nearbyForRent = true)))
    }

    @Test
    fun theHouseIsRecentlySold()
    {
        Assert.assertTrue(mockDataBase.validateJustSearchType(houseRecentlySold,SearchFilter(nearbyRecentlySold = true)))
    }

    @Test
    fun theHouseIsNotRecentlySold()
    {
        Assert.assertTrue(mockDataBase.validateJustSearchType(houseNothing,SearchFilter(nearbyRecentlySold = true)))
    }


}