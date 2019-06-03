package com.codeclan.restaurantbookings.restaurantbookings;

import com.codeclan.restaurantbookings.restaurantbookings.models.Booking;
import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;
import com.codeclan.restaurantbookings.restaurantbookings.models.RestaurantTable;
import com.codeclan.restaurantbookings.restaurantbookings.repositories.BookingRepository.BookingRepository;
import com.codeclan.restaurantbookings.restaurantbookings.repositories.CustomerRepository.CustomerRepository;
import com.codeclan.restaurantbookings.restaurantbookings.repositories.RestaurantTableRepository.RestaurantTableRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantBookingsApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	RestaurantTableRepository restaurantTableRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindAllBookings() {
		List<Booking> foundBookings = bookingRepository.findAll();
		assertEquals(4, foundBookings.size());
	}

	@Test
	public void canFindAllCustomers() {
		List<Customer> foundCustomers = customerRepository.findAll();
		assertEquals(5, foundCustomers.size());
	}

	@Test
	public void canFindAllRestaurantTables() {
		List<RestaurantTable> foundTables = restaurantTableRepository.findAll();
		assertEquals(6, foundTables.size());
	}


}
