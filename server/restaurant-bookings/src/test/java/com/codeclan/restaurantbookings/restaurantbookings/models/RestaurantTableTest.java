package com.codeclan.restaurantbookings.restaurantbookings.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class RestaurantTableTest {

    RestaurantTable  restaurantTable;
    Booking booking1;
    Booking booking2;
    Booking booking3;
    List myBookings;

    @Before
    public void setUp() {
        booking1 = new Booking(new Date(20190614), "2300", 30, "Graduation");
        booking2 = new Booking(new Date(20190612), "1900", 5, "Vegan");
        booking3 = new Booking(new Date(20200603), "2000", 21, "allergic to peanuts");
        restaurantTable = new RestaurantTable(1, 4);
        myBookings = new ArrayList<Booking>(Arrays.asList((booking1), (booking2)));

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

    @Test
    public void getBookings() {
        assertEquals(0, restaurantTable.getBookings().size());
    }

    @Test
    public void setBookings() {
        restaurantTable.setBookings(myBookings);
        assertEquals(booking1, restaurantTable.getBookings().get(0));

    }

    @Test
    public void addBooking() {
        restaurantTable.addBooking(booking3);
        assertEquals(booking3, restaurantTable.getBookings().get(0));

    }

    @Test
    public void removeBooking() {
        restaurantTable.setBookings(myBookings);
        restaurantTable.addBooking(booking3);
        assertEquals(booking2, restaurantTable.getBookings().get(1));
        restaurantTable.removeBooking(booking2);
        assertEquals(booking3, restaurantTable.getBookings().get(1));
    }

    @Test
    public void countBookings() {
        restaurantTable.setBookings(myBookings);
        assertEquals(2, restaurantTable.countBookings());
        restaurantTable.addBooking(booking3);
        assertEquals(3, restaurantTable.countBookings());

    }

    @Test
    public void getBookingById() {
        booking1.setId((long) 127);
        booking2.setId((long) 42);
        booking3.setId((long) 17);
        restaurantTable.addBooking(booking1);
        restaurantTable.addBooking(booking2);
        restaurantTable.addBooking(booking3);
        assertEquals(booking2, restaurantTable.getBookingById((long) 42));
    }

    @Test
    public void removeBookingById() {
        booking1.setId((long) 127);
        booking2.setId((long) 42);
        booking3.setId((long) 17);
        restaurantTable.addBooking(booking1);
        restaurantTable.addBooking(booking2);
        restaurantTable.addBooking(booking3);
        assertEquals(booking1, restaurantTable.getBookingById((long) 127));
        restaurantTable.removeBookingById((long) 127);
        assertNull(restaurantTable.getBookingById((long) 127));
        assertEquals(booking3, restaurantTable.getBookingById((long) 17));

    }

    @Test
    public void hasBookings() {
        assertEquals(false, restaurantTable.hasBookings());
        restaurantTable.addBooking(booking2);
        assertEquals(true, restaurantTable.hasBookings());
    }

    @Test
    public void removeAllBookings() {
        restaurantTable.setBookings(myBookings);
        assertEquals(true, restaurantTable.hasBookings());
        restaurantTable.removeAllBookings();
        assertEquals(false, restaurantTable.hasBookings());
    }

    @Test
    public void returnsNullIfNotBookedById() {
        booking1.setId((long) 127);
        booking2.setId((long) 42);
        booking3.setId((long) 17);
        restaurantTable.addBooking(booking1);
        restaurantTable.addBooking(booking2);
        restaurantTable.addBooking(booking3);
        assertEquals(booking1, restaurantTable.getBookingById((long) 127));
        assertNull(restaurantTable.getBookingById((long) 23));
    }
}