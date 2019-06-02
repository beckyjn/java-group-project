package com.codeclan.restaurantbookings.restaurantbookings.models;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TransactionTest {

    Transaction transaction;
    Booking booking;
    Booking booking1;
    Customer customer;
    Customer customer2;
    List<RestaurantTable> myTables;
    RestaurantTable restaurantTable;
    RestaurantTable restaurantTable2;



    @Before
    public void setUp() throws Exception {
        myTables = new ArrayList<RestaurantTable>(Arrays.asList((restaurantTable), (restaurantTable2)));
        restaurantTable = new RestaurantTable(1, 4);
        restaurantTable2 = new RestaurantTable(2, 2);
        booking = new Booking(customer, "01-06-2019", "1800", 103, "GF", myTables );
        booking1 = new Booking(customer, "01-06-2019", "1800", 103, "GF", myTables);
        customer = new Customer("Jordan", "5553381507", "jordan@fakeemail.com");
        customer2 = new Customer("Annabel", "5553455345", "annabel@fakeemail.com");
        transaction = new Transaction(new Date(20190601), 50, 50, customer, booking );
    }

    @Test
    public void getId() {
        assertNull(transaction.getId());
    }

    @Test
    public void setId() {
        transaction.setId((long) 103);
        assertEquals(103, (long) transaction.getId());
    }

    @Test
    public void getDate() {
        assertEquals(new Date(20190601), transaction.getDate());
    }

    @Test
    public void setDate() {
        transaction.setDate(new Date(20190501));
        assertEquals(new Date(20190501), transaction.getDate());

    }

    @Test
    public void getAmountPaid() {
        assertEquals(50, transaction.getAmountPaid());
    }

    @Test
    public void setAmountPaid() {
        transaction.setAmountPaid(100);
        assertEquals(100, transaction.getAmountPaid());

    }

    @Test
    public void getAmountOwing() {
        assertEquals(50, transaction.getAmountOwing());

    }

    @Test
    public void setAmountOwing() {
        transaction.setAmountOwing(100);
        assertEquals(100, transaction.getAmountOwing());

    }

    @Test
    public void getWarnings() {
        assertEquals("", transaction.getWarnings());
    }

    @Test
    public void setWarnings() {
        transaction.setWarnings("Threw food everywhere");
        assertEquals("Threw food everywhere", transaction.getWarnings());

    }

    @Test
    public void getCustomer() {
        assertEquals(customer, transaction.getCustomer());
    }

    @Test
    public void setCustomer() {
        transaction.setCustomer(customer2);
        assertEquals(customer2, transaction.getCustomer());
    }

    @Test
    public void getBooking() {
        assertEquals(booking, transaction.getBooking());
    }

    @Test
    public void setBooking() {
        transaction.setBooking(booking1);
        assertEquals(booking1, transaction.getBooking());
    }

    @Test
    public void getBalance(){
        assertEquals(0, transaction.getBalance());
    }

    @Test
    public void setBalance(){
        transaction.setBalance(10);
        assertEquals(10, transaction.getBalance());
    }

    @Test
    public void calculateBalance(){
        transaction.setBalance(transaction.calculateBalance());
        assertEquals(0, transaction.getBalance());


    }
}