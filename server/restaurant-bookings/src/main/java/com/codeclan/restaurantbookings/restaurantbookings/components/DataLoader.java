package com.codeclan.restaurantbookings.restaurantbookings.components;

import com.codeclan.restaurantbookings.restaurantbookings.models.Booking;
import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;
import com.codeclan.restaurantbookings.restaurantbookings.models.RestaurantTable;
import com.codeclan.restaurantbookings.restaurantbookings.repositories.BookingRepository.BookingRepository;
import com.codeclan.restaurantbookings.restaurantbookings.repositories.CustomerRepository.CustomerRepository;
import com.codeclan.restaurantbookings.restaurantbookings.repositories.RestaurantTableRepository.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.*;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RestaurantTableRepository restaurantTableRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        // 6 table of 4:
        RestaurantTable table1 = new RestaurantTable(1,4);
        restaurantTableRepository.save(table1);
        RestaurantTable table2 = new RestaurantTable(2,4);
        restaurantTableRepository.save(table2);
        RestaurantTable table3 = new RestaurantTable(3,4);
        restaurantTableRepository.save(table3);
        RestaurantTable table4 = new RestaurantTable(4,4);
        restaurantTableRepository.save(table4);
        RestaurantTable table5 = new RestaurantTable(5,4);
        restaurantTableRepository.save(table5);
        RestaurantTable table6 = new RestaurantTable(6,4);
        restaurantTableRepository.save(table6);

        // 5 customers:
        Customer customer1 = new Customer("Pim", "07392383829", "Pim@codeclan.com");
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Annabel", "07892380029", "Annabel@codeclan.com");
        customerRepository.save(customer2);
        Customer customer3 = new Customer("Maria", "07293940234", "Maria@codeclan.com");
        customerRepository.save(customer3);
        Customer customer4 = new Customer("Becky", "072443455332", "Becky@codeclan.com");
        customerRepository.save(customer4);
        Customer customer5 = new Customer("Charlie", "01314411321", "Charlie@codeclan.com");
        customerRepository.save(customer5);

        List myTables = new ArrayList<RestaurantTable>(Arrays.asList((table1), (table2)));

        // 3 bookings:
        Booking booking1 = new Booking(customer1, "01-06-2019", "1700", 20, "Graduation dinner", myTables);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking(customer2, "01-06-2019", "1700", 3, "", myTables );
        bookingRepository.save(booking2);
        Booking booking3 = new Booking(customer3, "01-06-2019", "1700", 1, "Window seat if possible", myTables );
        bookingRepository.save(booking3);
        Booking booking4 = new Booking(customer3, "05-06-2019", "1900", 2, "Not facing the toilet", myTables );
        bookingRepository.save(booking4);

    }


}
