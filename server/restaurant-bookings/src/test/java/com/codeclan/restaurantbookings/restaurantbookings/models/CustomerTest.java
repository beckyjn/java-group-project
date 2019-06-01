package com.codeclan.restaurantbookings.restaurantbookings.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerTest {

    Customer customer;
    Booking booking1;
    Booking booking2;
    Booking booking3;
    List myBookings;

    @Before
    public void setUp() {
        booking1 = new Booking(new Date(20190601), "1800", 103, "GF");
        booking2 = new Booking(new Date(20190602), "1900", 5, "Birthday party, make a cake");
        booking3 = new Booking(new Date(20190603), "2000", 2, "allergic to peanuts");
        customer = new Customer("Jordan", "5553381507", "jordan@fakeemail.com");
        myBookings = new ArrayList<Booking>(Arrays.asList((booking1), (booking2)));

    }

    @Test
    public void getId() {
        assertEquals(null, customer.getId());
    }

    @Test
    public void getName() {
        assertEquals("Jordan", customer.getName());
    }

    @Test
    public void setName() {
        customer.setName("Jason");
        assertEquals("Jason", customer.getName());
    }

    @Test
    public void getPhone() {
        assertEquals("5553381507", customer.getPhone());
    }

    @Test
    public void setPhone() {
        customer.setPhone("555581507");
        assertEquals("555581507", customer.getPhone());
    }

    @Test
    public void getEmail() {
        assertEquals("jordan@fakeemail.com", customer.getEmail());
    }

    @Test
    public void setEmail() {
        customer.setEmail("jason@fakeemail.com");
        assertEquals("jason@fakeemail.com", customer.getEmail());
    }

    @Test
    public void getBookings() {
        assertEquals(0, customer.getBookings().size());
    }

    @Test
    public void setBookings() {
        customer.setBookings(myBookings);
        assertEquals(booking1, customer.getBookings().get(0));
    }

    @Test
    public void addBooking() {
        customer.setBookings(myBookings);
        customer.addBooking(booking3);
        assertEquals(booking3, customer.getBookings().get(2));
        assertEquals(3, customer.countBookings());
    }

    @Test
    public void countBookings(){
        assertEquals(0, customer.countBookings());
        customer.setBookings(myBookings);
        assertEquals(2, customer.countBookings());
        customer.addBooking(booking3);
        assertEquals(3, customer.countBookings());

    }

    @Test
    public void removeBooking(){
        customer.setBookings(myBookings);
        assertEquals(2, customer.countBookings());
        customer.removeBooking(booking1);
        assertEquals(1, customer.countBookings());
        assertEquals(booking2, customer.getBookings().get(0));
    }

    @Test
    public void getBookingById() {
        customer.setBookings(myBookings);
        booking2.setId((long) 103);
        booking1.setId((long) 5);
        assertEquals(booking2, customer.getBookingById((long) 103));
    }

    @Test
    public void removeBookingById() {
        customer.setBookings(myBookings);
        booking2.setId((long) 103);
        booking1.setId((long) 5);
        customer.removeBookingById((long) 5);
        assertNull(customer.getBookingById((long) 5));
    }

    @Test
    public void hasNoBookings() {
        assertEquals(false, customer.hasBookings());
    }

    @Test
    public void hasBookings() {
        customer.addBooking(booking3);
        assertEquals(true, customer.hasBookings());
    }

    @Test
    public void removeAllBookings() {
        customer.setBookings(myBookings);
        customer.addBooking(booking3);
        assertEquals(true, customer.hasBookings());
        customer.removeAllBookings();
        assertEquals(false, customer.hasBookings());
    }
}