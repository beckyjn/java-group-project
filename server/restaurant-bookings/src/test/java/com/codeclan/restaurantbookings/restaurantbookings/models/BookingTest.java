package com.codeclan.restaurantbookings.restaurantbookings.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class BookingTest {

    Booking booking;
    Customer customer;
    Customer customer2;
    RestaurantTable  restaurantTable;
    RestaurantTable  restaurantTable2;
    RestaurantTable  restaurantTable3;
    List<RestaurantTable> myTables;


    @Before
    public void setUp()  {
        customer = new Customer("Jordan", "5553381507", "jordan@fakeemail.com");
        customer2 = new Customer("Annabel", "5553455345", "annabel@fakeemail.com");
        restaurantTable = new RestaurantTable(1, 4);
        restaurantTable2 = new RestaurantTable(2, 2);
        restaurantTable3 = new RestaurantTable(3, 103);
        myTables = new ArrayList<RestaurantTable>(Arrays.asList((restaurantTable), (restaurantTable2)));

        booking = new Booking(new Date(20190601), "1800", 103, "GF");
    }

    @Test
    public void getId() {
        assertEquals(null, booking.getId());
    }

    @Test
    public void getDate() {
        assertEquals(new Date(20190601), booking.getDate());
    }

    @Test
    public void setDate() {
        booking.setDate(new Date(20190604));
        assertEquals(new Date(20190604), booking.getDate());
    }

    @Test
    public void getTime() {
        assertEquals("1800", booking.getTime());
    }

    @Test
    public void setTime() {
        booking.setTime("1915");
        assertEquals("1915", booking.getTime());
    }

    @Test
    public void getNumberInParty() {
        assertEquals(103, booking.getNumberInParty());
    }

    @Test
    public void setNumberInParty() {
       booking.setNumberInParty(99);
       assertEquals(99, booking.getNumberInParty());
    }

    @Test
    public void getNotes() {
        assertEquals("GF", booking.getNotes());
    }

    @Test
    public void setNotes() {
        booking.setNotes("Vegan");
        assertEquals("Vegan", booking.getNotes());
    }

    @Test
    public void getCustomer() {
        assertNull(booking.getCustomer());
    }

    @Test
    public void setCustomer() {
        booking.setCustomer(customer);
        assertEquals(customer, booking.getCustomer());
        booking.setCustomer(customer2);
        assertEquals(customer2, booking.getCustomer());

    }


    @Test
    public void getRestaurantTables() {
        assertEquals(0, booking.getRestaurantTables().size());
        assertEquals(true, booking.getRestaurantTables().isEmpty());
    }

    @Test
    public void setRestaurantTables() {
        booking.setRestaurantTables(myTables);
        assertEquals(2, booking.getRestaurantTables().size());
        assertEquals(restaurantTable, booking.getRestaurantTables().get(0));
    }

    @Test
    public void addRestaurantTable() {
        booking.addRestaurantTable(restaurantTable3);
        assertEquals(1, booking.getRestaurantTables().size());
        assertEquals(restaurantTable3, booking.getRestaurantTables().get(0));
    }

    @Test
    public void removeRestaurantTable() {
        booking.setRestaurantTables(myTables);
        booking.addRestaurantTable(restaurantTable3);
        assertEquals(3, booking.getRestaurantTables().size());
        assertEquals(restaurantTable2, booking.getRestaurantTables().get(1));
        booking.removeRestaurantTable(restaurantTable2);
        assertEquals(restaurantTable3, booking.getRestaurantTables().get(1));

    }

    @Test
    public void countRestaurantTables() {
        booking.setRestaurantTables(myTables);
        assertEquals(2, booking.countRestaurantTables());
    }

    @Test
    public void getRestaurantTableById() {
        booking.setRestaurantTables(myTables);
        booking.addRestaurantTable(restaurantTable3);
        restaurantTable.setId((long) 3);
        restaurantTable2.setId((long) 98);
        restaurantTable3.setId((long) 12);
        assertEquals(restaurantTable2, booking.getRestaurantTableById((long) 98));
    }

    @Test
    public void removeRestaurantTableById() {
        booking.setRestaurantTables(myTables);
        booking.addRestaurantTable(restaurantTable3);
        restaurantTable.setId((long) 3);
        restaurantTable2.setId((long) 98);
        restaurantTable3.setId((long) 12);
        assertEquals(restaurantTable2, booking.getRestaurantTableById((long) 98));
        booking.removeRestaurantTableById((long) 98);
        assertNull(booking.getRestaurantTableById((long) 98));
        assertEquals(restaurantTable3, booking.getRestaurantTableById((long) 12));

    }

    @Test
    public void hasRestaurantTables() {
        booking.addRestaurantTable(restaurantTable);
        assertEquals(true, booking.hasRestaurantTables());
    }

    @Test
    public void removeAllRestaurantTables() {
        booking.addRestaurantTable(restaurantTable);
        booking.removeAllRestaurantTables();
        assertEquals(false, booking.hasRestaurantTables());
    }

    @Test
    public void countSeating() {
        booking.setRestaurantTables(myTables);
        assertEquals(6, booking.countSeating());
        booking.addRestaurantTable(restaurantTable3);
        assertEquals(109, booking.countSeating());

    }
}