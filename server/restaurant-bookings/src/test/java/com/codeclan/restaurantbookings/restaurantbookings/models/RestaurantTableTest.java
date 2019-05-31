package com.codeclan.restaurantbookings.restaurantbookings.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RestaurantTableTest {

    RestaurantTable  restaurantTable;

    @Before
    public void setUp() {
        restaurantTable = new RestaurantTable(1, 4);
    }

    @Test
    public void getId() {
        assertEquals(null, restaurantTable.getId());
    }

    @Test
    public void getTableNumber() {
        assertEquals(1, restaurantTable.getTableNumber());
    }

    @Test
    public void setTableNumber() {
        restaurantTable.setTableNumber(103);
        assertEquals(103, restaurantTable.getTableNumber());
    }

    @Test
    public void getSeating() {
        assertEquals(4, restaurantTable.getSeating());
    }

    @Test
    public void setSeating() {
        restaurantTable.setSeating(8);
        assertEquals(8, restaurantTable.getSeating());
    }
}