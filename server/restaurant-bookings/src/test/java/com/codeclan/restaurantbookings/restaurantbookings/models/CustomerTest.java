package com.codeclan.restaurantbookings.restaurantbookings.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Jordan", "5553381507", "jordan@fakeemail.com");
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
}