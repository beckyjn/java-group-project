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

	@Test
	public void canFindBookingsForAGivenDate() {
		List<Booking> foundBookings = bookingRepository.findAllBookingsByDate("01-06-2019");
		assertEquals(3, foundBookings.size());
	}

	@Test
	public void canFindCustomerByName() {
		List<Customer> foundCustomer = customerRepository.findCustomerByName("Maria");
		assertEquals(1, foundCustomer.size());
		assertEquals("Maria", foundCustomer.get(0).getName());
	}

	@Test
	public void canFindCustomerById() {
		List<Customer> foundCustomer = customerRepository.findCustomerById(2L);
		assertEquals(1, foundCustomer.size());
		assertEquals("Annabel", foundCustomer.get(0).getName());
	}

	@Test
	public void canFindAllRestaurantTablesWithANumberOfSeatings() {
		List<RestaurantTable> foundTables = restaurantTableRepository.findTablesBySeating(4);
		assertEquals(6, foundTables.size());
		assertEquals(1, foundTables.get(0).getTableNumber());
		assertEquals(2, foundTables.get(1).getTableNumber());
		assertEquals(3, foundTables.get(2).getTableNumber());
		assertEquals(4, foundTables.get(3).getTableNumber());
		assertEquals(5, foundTables.get(4).getTableNumber());
		assertEquals(6, foundTables.get(5).getTableNumber());
	}

//	@Test
//	public void canFindAParticularBookingByDateTimeAndCustomerId() {
//		List<Booking> foundBooking = bookingRepository.getBookingByDateTimeAndCustomerId("01-06-2019", "1700", 3L);
//	}


}
