package com.codeclan.restaurantbookings.restaurantbookings.components;

import com.codeclan.restaurantbookings.restaurantbookings.models.Booking;
import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;
import com.codeclan.restaurantbookings.restaurantbookings.models.RestaurantTable;
import com.codeclan.restaurantbookings.restaurantbookings.models.Transaction;
import com.codeclan.restaurantbookings.restaurantbookings.repositories.BookingRepository.BookingRepository;
import com.codeclan.restaurantbookings.restaurantbookings.repositories.CustomerRepository.CustomerRepository;
import com.codeclan.restaurantbookings.restaurantbookings.repositories.RestaurantTableRepository.RestaurantTableRepository;
import com.codeclan.restaurantbookings.restaurantbookings.repositories.TransactionRepository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RestaurantTableRepository restaurantTableRepository;
    @Autowired
    TransactionRepository transactionRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        // 6 table of 4:
        RestaurantTable table1 = new RestaurantTable(1, 4);
        restaurantTableRepository.save(table1);
        RestaurantTable table2 = new RestaurantTable(2, 4);
        restaurantTableRepository.save(table2);
        RestaurantTable table3 = new RestaurantTable(3, 4);
        restaurantTableRepository.save(table3);
        RestaurantTable table4 = new RestaurantTable(4, 4);
        restaurantTableRepository.save(table4);
        RestaurantTable table5 = new RestaurantTable(5, 4);
        restaurantTableRepository.save(table5);
        RestaurantTable table6 = new RestaurantTable(6, 4);
        restaurantTableRepository.save(table6);
        RestaurantTable table7 = new RestaurantTable(7, 4);
        restaurantTableRepository.save(table7);
        RestaurantTable table8 = new RestaurantTable(8, 4);
        restaurantTableRepository.save(table8);
        RestaurantTable table9 = new RestaurantTable(9, 4);
        restaurantTableRepository.save(table9);
        RestaurantTable table10 = new RestaurantTable(10, 4);
        restaurantTableRepository.save(table10);
        RestaurantTable table11 = new RestaurantTable(11, 13);
        restaurantTableRepository.save(table11);
        RestaurantTable table12 = new RestaurantTable(12, 6);
        restaurantTableRepository.save(table12);
        RestaurantTable table13 = new RestaurantTable(13, 6);
        restaurantTableRepository.save(table13);
        RestaurantTable table14 = new RestaurantTable(14, 6);
        restaurantTableRepository.save(table14);
        RestaurantTable table15 = new RestaurantTable(15, 10);
        restaurantTableRepository.save(table15);
        RestaurantTable table16 = new RestaurantTable(16, 10);
        restaurantTableRepository.save(table16);
        RestaurantTable table17 = new RestaurantTable(17, 10);
        restaurantTableRepository.save(table17);
        RestaurantTable table18 = new RestaurantTable(18, 2);
        restaurantTableRepository.save(table18);
        RestaurantTable table19 = new RestaurantTable(19, 2);
        restaurantTableRepository.save(table19);
        RestaurantTable table20 = new RestaurantTable(20, 2);
//
        List myTables = new ArrayList<RestaurantTable>(Arrays.asList((table1)));
        List myTables2 = new ArrayList<RestaurantTable>(Arrays.asList((table18)));
        List myTables3 = new ArrayList<RestaurantTable>(Arrays.asList((table19)));
        List myTables4 = new ArrayList<RestaurantTable>(Arrays.asList((table11)));

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
      // 3 bookings:
        Booking booking1 = new Booking(customer1, LocalDate.parse("2019-06-10"), LocalTime.parse("17:00"), 20, "Graduation dinner", myTables);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking(customer2, LocalDate.parse("2019-06-07"), LocalTime.parse("17:00"), 3, "", myTables );
        bookingRepository.save(booking2);
        Booking booking3 = new Booking(customer3, LocalDate.parse("2019-06-06"), LocalTime.parse("19:00"), 1, "Window seat if possible", myTables2 );
        bookingRepository.save(booking3);
        Booking booking4 = new Booking(customer3, LocalDate.parse("2019-06-06"), LocalTime.parse("19:00"), 2, "Not facing the toilet", myTables3);
        bookingRepository.save(booking4);
        Booking booking5 = new Booking(customer4, LocalDate.parse("2019-06-06"), LocalTime.parse("19:00"), 11, "Birthday's party", myTables4);
        bookingRepository.save(booking5);

          // transactions:
//// LocalDate date, int amountOwing, int amountPaid, Customer customer, Booking booking)
        Transaction transaction1 = new Transaction(LocalDate.parse("2019-06-10"), 30, 30, customer1, booking1);
        Transaction transaction2 = new Transaction(LocalDate.parse("2019-06-01"), 150, 50, customer2, booking2);
        Transaction transaction3 = new Transaction( LocalDate.parse("2019-06-01"), 25, 25, customer3, booking3);
        Transaction transaction4 = new Transaction(LocalDate.parse("2019-06-05"), 40, 40, customer3, booking4);

        transactionRepository.save(transaction1);
        transactionRepository.save(transaction2);
        transactionRepository.save(transaction3);
        transactionRepository.save(transaction4);


    }}