package com.codeclan.restaurantbookings.restaurantbookings.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class BookingTest {

    Booking booking;
    Customer customer;
    Customer customer2;

    @Before
    public void setUp()  {
        customer = new Customer("Jordan", "5553381507", "jordan@fakeemail.com");
        customer2 = new Customer("Annabel", "5553455345", "annabel@fakeemail.com");

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


}