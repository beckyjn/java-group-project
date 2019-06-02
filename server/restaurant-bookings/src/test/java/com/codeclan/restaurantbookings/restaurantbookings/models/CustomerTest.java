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
    Transaction transaction;
    Transaction transaction2;
    Transaction transaction3;
    List myTransactions;
    List<RestaurantTable> myTables;
    RestaurantTable restaurantTable;
    RestaurantTable restaurantTable2;

    @Before
    public void setUp() {
        booking1 = new Booking(customer, "01-06-2019", "1800", 103, "GF", myTables );
        booking2 = new Booking(customer, "01-06-2019", "1800", 103, "GF", myTables);
        booking3 = new Booking(customer, "01-06-2019", "1900", 5, "Birthday party, make a cake", myTables);
        myTables = new ArrayList<RestaurantTable>(Arrays.asList((restaurantTable), (restaurantTable2)));
        customer = new Customer("Jordan", "5553381507", "jordan@fakeemail.com");
        myBookings = new ArrayList<Booking>(Arrays.asList((booking1), (booking2)));
        transaction = new Transaction(new Date(20190601), 50, 50, customer, booking1 );
        transaction2 = new Transaction(new Date(20190602), 150, 50, customer, booking2 );
        transaction3 = new Transaction(new Date(20190605), 500, 500, customer, booking3 );
        myTransactions = new ArrayList<Transaction>(Arrays.asList((transaction2), (transaction3)));

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
        assertEquals(true, customer.getBookings().isEmpty());

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

    @Test
    public void getTransactions() {
        assertEquals(true, customer.getTransactions().isEmpty());
    }

    @Test
    public void setTransactions() {
        customer.setTransactions(myTransactions);
        assertEquals(transaction2, customer.getTransactions().get(0));
    }

    @Test
    public void addTransaction() {
        customer.addTransaction(transaction);
        assertEquals(transaction, customer.getTransactions().get(0));

    }

    @Test
    public void removeTransaction() {
        customer.setTransactions(myTransactions);
        assertEquals(transaction2, customer.getTransactions().get(0));
        customer.removeTransaction(transaction2);
        assertEquals(transaction3, customer.getTransactions().get(0));

    }

    @Test
    public void countTransactions() {
        customer.setTransactions(myTransactions);
        assertEquals(2, customer.countTransactions());
    }

    @Test
    public void getTransactionById() {
        transaction.setId((long) 7);
        transaction2.setId((long) 17);
        transaction3.setId((long) 27);
        customer.setTransactions(myTransactions);
        customer.addTransaction(transaction);
        assertEquals(transaction3, customer.getTransactionById((long) 27));

    }

    @Test
    public void removeTransactionById() {
        transaction.setId((long) 7);
        transaction2.setId((long) 17);
        transaction3.setId((long) 27);
        customer.setTransactions(myTransactions);
        customer.addTransaction(transaction);
        assertEquals( transaction3, customer.getTransactions().get(1));
        customer.removeTransactionById((long) 27);
        assertEquals( transaction, customer.getTransactions().get(1));

    }

    @Test
    public void hasNoTransactions() {
        assertEquals(false, customer.hasTransactions());
    }

    @Test
    public void hasTransactions() {
        customer.addTransaction(transaction2);
        assertEquals(true, customer.hasTransactions());

    }

    @Test
    public void removeAllTransactions() {
        customer.setTransactions(myTransactions);
        customer.addTransaction(transaction);
        assertEquals(3, customer.countTransactions());
        customer.removeAllTransactions();
        assertEquals(0, customer.countTransactions());

    }
}