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
        RestaurantTable table7 = new RestaurantTable(7,4);
        restaurantTableRepository.save(table7);
        RestaurantTable table8 = new RestaurantTable(8,4);
        restaurantTableRepository.save(table8);
        RestaurantTable table9 = new RestaurantTable(9,4);
        restaurantTableRepository.save(table9);
        RestaurantTable table10 = new RestaurantTable(10,4);
        restaurantTableRepository.save(table10);
        RestaurantTable table11 = new RestaurantTable(11,13);
        restaurantTableRepository.save(table11);
        RestaurantTable table12 = new RestaurantTable(12,6);
        restaurantTableRepository.save(table12);
        RestaurantTable table13 = new RestaurantTable(13,6);
        restaurantTableRepository.save(table13);
        RestaurantTable table14 = new RestaurantTable(14,6);
        restaurantTableRepository.save(table14);
        RestaurantTable table15 = new RestaurantTable(15,10);
        restaurantTableRepository.save(table15);
        RestaurantTable table16 = new RestaurantTable(16,10);
        restaurantTableRepository.save(table16);
        RestaurantTable table17 = new RestaurantTable(17,10);
        restaurantTableRepository.save(table17);
        RestaurantTable table18 = new RestaurantTable(18,2);
        restaurantTableRepository.save(table18);
        RestaurantTable table19 = new RestaurantTable(19,2);
        restaurantTableRepository.save(table19);
        RestaurantTable table20 = new RestaurantTable(20,2);
// delete the data below this (before other comment) before pull request
        restaurantTableRepository.save(table20);

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
        Customer customer6 = new Customer("Robbyn", "05557411321", "Robbyn@codeclan.com");
        customerRepository.save(customer6);
        Customer customer7 = new Customer("Kim", "01314374571", "Charlie@codeclan.com");
        customerRepository.save(customer7);
        Customer customer8 = new Customer("Elias", "54546411321", "Elias@codeclan.com");
        customerRepository.save(customer8);
        Customer customer9 = new Customer("Arthur", "01314416578", "Arthur@codeclan.com");
        customerRepository.save(customer9);
        Customer customer10 = new Customer("Jannet", "55555555555", "Jannet@codeclan.com");
        customerRepository.save(customer10);
        Customer customer11 = new Customer("Bruce", "02310987321", "Bruce@codeclan.com");
        customerRepository.save(customer11);
        Customer customer12 = new Customer("William", "55599988812", "William@codeclan.com");
        customerRepository.save(customer12);
        Customer customer13 = new Customer("Lisha", "45637869876", "Lisha@codeclan.com");
        customerRepository.save(customer13);
        Customer customer14 = new Customer("Daisey", "77688592534", "Daisey@codeclan.com");
        customerRepository.save(customer14);
        Customer customer15 = new Customer("Heidi", "07784992341", "Heidi@codeclan.com");
        customerRepository.save(customer15);
        Customer customer16 = new Customer("Winston", "77777777098", "Winston@codeclan.com");
        customerRepository.save(customer16);
        Customer customer17 = new Customer("Marietta", "09884411761", "Marietta@codeclan.com");
        customerRepository.save(customer17);
        Customer customer18 = new Customer("Lanny", "01314414567", "Lanny@codeclan.com");
        customerRepository.save(customer18);
        Customer customer19 = new Customer("Juliana", "07555467812", "Juliana@codeclan.com");
        customerRepository.save(customer19);
        Customer customer20 = new Customer("King", "01311111121", "King@codeclan.com");
        customerRepository.save(customer20);

        List myTables = new ArrayList<RestaurantTable>(Arrays.asList((table1)));
        List myTables1 = new ArrayList<RestaurantTable>(Arrays.asList((table15), (table16)));
        List myTables2 = new ArrayList<RestaurantTable>(Arrays.asList((table18)));
        List myTables3 = new ArrayList<RestaurantTable>(Arrays.asList((table19)));
        List myTables4 = new ArrayList<RestaurantTable>(Arrays.asList((table11)));
        List myTables5 = new ArrayList<RestaurantTable>(Arrays.asList((table13)));
        List myTables6 = new ArrayList<RestaurantTable>(Arrays.asList((table14), (table15)));
        List myTables7 = new ArrayList<RestaurantTable>(Arrays.asList((table1), (table2), (table3), (table4), (table5), (table6), (table7), (table8), (table9), (table10), (table11), (table12), (table13), (table14), (table15), (table16), (table17), (table18), (table19), (table20)));
        List myTables8 = new ArrayList<RestaurantTable>(Arrays.asList((table17)));
        List myTables9 = new ArrayList<RestaurantTable>(Arrays.asList((table15), (table16), (table18)));
        List myTables10 = new ArrayList<RestaurantTable>(Arrays.asList((table14)));






        // 3 bookings:
        Booking booking1 = new Booking(customer1, LocalDate.parse("2019-06-05"), LocalTime.parse("17:00"), 20, "Graduation dinner", myTables1);
        bookingRepository.save(booking1);
        table15.addBooking(booking1);
        restaurantTableRepository.save(table15);
        table16.addBooking(booking1);
        restaurantTableRepository.save(table16);
        Booking booking2 = new Booking(customer2, LocalDate.parse("2019-06-01"), LocalTime.parse("17:00"), 3, "", myTables );
        bookingRepository.save(booking2);
        table1.addBooking(booking2);
        restaurantTableRepository.save(table1);

        Booking booking3 = new Booking(customer3, LocalDate.parse("2019-06-01"), LocalTime.parse("19:00"), 1, "Window seat if possible", myTables2 );
        bookingRepository.save(booking3);
        Booking booking4 = new Booking(customer3, LocalDate.parse("2019-06-05"), LocalTime.parse("19:00"), 2, "Not facing the toilet", myTables3);
        bookingRepository.save(booking4);
        Booking booking5 = new Booking(customer4, LocalDate.parse("2019-06-05"), LocalTime.parse("19:00"), 11, "Birthday's party", myTables4);
        bookingRepository.save(booking5);
        Booking booking6 = new Booking(customer5, LocalDate.parse("2019-06-05"), LocalTime.parse("18:30"), 6, "", myTables5);
        bookingRepository.save(booking6);
        Booking booking7 = new Booking(customer6, LocalDate.parse("2019-06-05"), LocalTime.parse("17:30"), 15, "", myTables6);
        bookingRepository.save(booking7);
        Booking booking8 = new Booking(customer7, LocalDate.parse("2019-07-01"), LocalTime.parse("12:30"), 100, "Wedding's party - all day long", myTables7);
        bookingRepository.save(booking8);
        Booking booking9 = new Booking(customer8, LocalDate.parse("2019-06-10"), LocalTime.parse("15:30"), 4, "Window seat if possible", myTables);
        bookingRepository.save(booking9);
        Booking booking10 = new Booking(customer9, LocalDate.parse("2019-07-04"), LocalTime.parse("18:00"), 12, "", myTables4);
        bookingRepository.save(booking10);
        Booking booking11 = new Booking(customer10, LocalDate.parse("2019-06-10"), LocalTime.parse("17:30"), 8, "", myTables8);
        bookingRepository.save(booking11);
        Booking booking12 = new Booking(customer11, LocalDate.parse("2019-07-04"), LocalTime.parse("16:45"), 2, "Anniversary celebration", myTables3);
        bookingRepository.save(booking12);
        Booking booking13 = new Booking(customer12, LocalDate.parse("2019-06-11"), LocalTime.parse("19:45"), 5, "", myTables5);
        bookingRepository.save(booking13);
        Booking booking14 = new Booking(customer12, LocalDate.parse("2019-06-21"), LocalTime.parse("16:45"), 9, "", myTables8);
        bookingRepository.save(booking14);
        Booking booking15 = new Booking(customer13, LocalDate.parse("2019-06-11"), LocalTime.parse("19:45"), 5, "", myTables10);
        bookingRepository.save(booking15);
        Booking booking16 = new Booking(customer3, LocalDate.parse("2019-06-11"), LocalTime.parse("17:30"), 10, "", myTables8);
        bookingRepository.save(booking16);
        Booking booking17 = new Booking(customer14, LocalDate.parse("2019-07-04"), LocalTime.parse("18:40"), 4, "", myTables);
        bookingRepository.save(booking17);
        Booking booking18 = new Booking(customer2, LocalDate.parse("2019-06-21"), LocalTime.parse("16:45"), 25, "E29 Graduation", myTables9);
        bookingRepository.save(booking18);
        Booking booking19 = new Booking(customer4, LocalDate.parse("2019-06-11"), LocalTime.parse("14:15"), 5, "", myTables5);
        bookingRepository.save(booking19);
        Booking booking20 = new Booking(customer12, LocalDate.parse("2019-06-11"), LocalTime.parse("19:45"), 15, "Job promotion", myTables6);
        bookingRepository.save(booking20);

        // transactions:
// LocalDate date, int amountOwing, int amountPaid, Customer customer, Booking booking)
        Transaction transaction1 = new Transaction(LocalDate.parse("2019-06-10"), 30, 30, customer1, booking1);
        Transaction transaction2 = new Transaction(LocalDate.parse("2019-06-01"), 150, 50, customer2, booking2);
        Transaction transaction3 = new Transaction( LocalDate.parse("2019-06-01"), 25, 25, customer3, booking3);
        Transaction transaction4 = new Transaction(LocalDate.parse("2019-06-05"), 40, 40, customer3, booking4);
        Transaction transaction5 = new Transaction(LocalDate.parse("2019-06-05"), 500, 100, customer2, booking4);
        Transaction transaction6 = new Transaction(LocalDate.parse("2019-06-05"), 20, 20, customer1, booking4);
        Transaction transaction7 = new Transaction(LocalDate.parse("2019-06-05"), 25,25, customer2, booking4);
        Transaction transaction8 = new Transaction(LocalDate.parse("2019-06-01"), 10, 10, customer5, booking3);
        Transaction transaction9 = new Transaction(LocalDate.parse("2019-06-01"), 15, 15, customer1, booking3);
        Transaction transaction10 = new Transaction(LocalDate.parse("2019-06-10"), 20, 20, customer2, booking1);

        transactionRepository.save(transaction1);
        transactionRepository.save(transaction2);
        transactionRepository.save(transaction3);
        transactionRepository.save(transaction4);
        transactionRepository.save(transaction5);
        transactionRepository.save(transaction6);
        transactionRepository.save(transaction7);
        transactionRepository.save(transaction8);
        transactionRepository.save(transaction9);
        transactionRepository.save(transaction10);

    }


}
// delete the data above this before pull request

//        // 5 customers:
//        Customer customer1 = new Customer("Pim", "07392383829", "Pim@codeclan.com");
//        customerRepository.save(customer1);
//        Customer customer2 = new Customer("Annabel", "07892380029", "Annabel@codeclan.com");
//        customerRepository.save(customer2);
//        Customer customer3 = new Customer("Maria", "07293940234", "Maria@codeclan.com");
//        customerRepository.save(customer3);
//        Customer customer4 = new Customer("Becky", "072443455332", "Becky@codeclan.com");
//        customerRepository.save(customer4);
//        Customer customer5 = new Customer("Charlie", "01314411321", "Charlie@codeclan.com");
//        customerRepository.save(customer5);
//        Customer customer6 = new Customer("Robbyn", "05557411321", "Robbyn@codeclan.com");
//        customerRepository.save(customer6);
//        Customer customer7 = new Customer("Kim", "01314374571", "Charlie@codeclan.com");
//        customerRepository.save(customer7);
//        Customer customer8 = new Customer("Elias", "54546411321", "Elias@codeclan.com");
//        customerRepository.save(customer8);
//        Customer customer9 = new Customer("Arthur", "01314416578", "Arthur@codeclan.com");
//        customerRepository.save(customer9);
//        Customer customer10 = new Customer("Jannet", "55555555555", "Jannet@codeclan.com");
//        customerRepository.save(customer10);
//        Customer customer11 = new Customer("Bruce", "02310987321", "Bruce@codeclan.com");
//        customerRepository.save(customer11);
//        Customer customer12 = new Customer("William", "55599988812", "William@codeclan.com");
//        customerRepository.save(customer12);
//        Customer customer13 = new Customer("Lisha", "45637869876", "Lisha@codeclan.com");
//        customerRepository.save(customer13);
//        Customer customer14 = new Customer("Daisey", "77688592534", "Daisey@codeclan.com");
//        customerRepository.save(customer14);
//        Customer customer15 = new Customer("Heidi", "07784992341", "Heidi@codeclan.com");
//        customerRepository.save(customer15);
//        Customer customer16 = new Customer("Winston", "77777777098", "Winston@codeclan.com");
//        customerRepository.save(customer16);
//        Customer customer17 = new Customer("Marietta", "09884411761", "Marietta@codeclan.com");
//        customerRepository.save(customer17);
//        Customer customer18 = new Customer("Lanny", "01314414567", "Lanny@codeclan.com");
//        customerRepository.save(customer18);
//        Customer customer19 = new Customer("Juliana", "07555467812", "Juliana@codeclan.com");
//        customerRepository.save(customer19);
//        Customer customer20 = new Customer("King", "01311111121", "King@codeclan.com");
//        customerRepository.save(customer20);
//
//        List myTables = new ArrayList<RestaurantTable>(Arrays.asList((table1)));
//        List myTables1 = new ArrayList<RestaurantTable>(Arrays.asList((table15), (table16)));
//        List myTables2 = new ArrayList<RestaurantTable>(Arrays.asList((table18)));
//        List myTables3 = new ArrayList<RestaurantTable>(Arrays.asList((table19)));
//        List myTables4 = new ArrayList<RestaurantTable>(Arrays.asList((table11)));
//        List myTables5 = new ArrayList<RestaurantTable>(Arrays.asList((table13)));
//        List myTables6 = new ArrayList<RestaurantTable>(Arrays.asList((table14), (table15)));
//        List myTables7 = new ArrayList<RestaurantTable>(Arrays.asList((table1), (table2), (table3), (table4), (table5), (table6), (table7), (table8), (table9), (table10), (table11), (table12), (table13), (table14), (table15), (table16), (table17), (table18), (table19), (table20)));
//        List myTables8 = new ArrayList<RestaurantTable>(Arrays.asList((table17)));
//        List myTables9 = new ArrayList<RestaurantTable>(Arrays.asList((table15), (table16), (table18)));
//        List myTables10 = new ArrayList<RestaurantTable>(Arrays.asList((table14)));
//


//
//
//
//        // 3 bookings:
//        Booking booking1 = new Booking(customer1, LocalDate.parse("2019-06-10"), LocalTime.parse("17:00"), 20, "Graduation dinner", myTables1);
//        bookingRepository.save(booking1);
//        Booking booking2 = new Booking(customer2, LocalDate.parse("2019-06-01"), LocalTime.parse("17:00"), 3, "", myTables );
//        bookingRepository.save(booking2);
//        Booking booking3 = new Booking(customer3, LocalDate.parse("2019-06-01"), LocalTime.parse("19:00"), 1, "Window seat if possible", myTables2 );
//        bookingRepository.save(booking3);
//        Booking booking4 = new Booking(customer3, LocalDate.parse("2019-06-05"), LocalTime.parse("19:00"), 2, "Not facing the toilet", myTables3);
//        bookingRepository.save(booking4);
//        Booking booking5 = new Booking(customer4, LocalDate.parse("2019-06-05"), LocalTime.parse("19:00"), 11, "Birthday's party", myTables4);
//        bookingRepository.save(booking5);
//        Booking booking6 = new Booking(customer5, LocalDate.parse("2019-06-05"), LocalTime.parse("18:30"), 6, "", myTables5);
//        bookingRepository.save(booking6);
//        Booking booking7 = new Booking(customer6, LocalDate.parse("2019-06-05"), LocalTime.parse("17:30"), 15, "", myTables6);
//        bookingRepository.save(booking7);
//        Booking booking8 = new Booking(customer7, LocalDate.parse("2019-07-01"), LocalTime.parse("12:30"), 100, "Wedding's party - all day long", myTables7);
//        bookingRepository.save(booking8);
//        Booking booking9 = new Booking(customer8, LocalDate.parse("2019-06-10"), LocalTime.parse("15:30"), 4, "Window seat if possible", myTables);
//        bookingRepository.save(booking9);
//        Booking booking10 = new Booking(customer9, LocalDate.parse("2019-07-04"), LocalTime.parse("18:00"), 12, "", myTables4);
//        bookingRepository.save(booking10);
//        Booking booking11 = new Booking(customer10, LocalDate.parse("2019-06-10"), LocalTime.parse("17:30"), 8, "", myTables8);
//        bookingRepository.save(booking11);
//        Booking booking12 = new Booking(customer11, LocalDate.parse("2019-07-04"), LocalTime.parse("16:45"), 2, "Anniversary celebration", myTables3);
//        bookingRepository.save(booking12);
//        Booking booking13 = new Booking(customer12, LocalDate.parse("2019-06-11"), LocalTime.parse("19:45"), 5, "", myTables5);
//        bookingRepository.save(booking13);
//        Booking booking14 = new Booking(customer12, LocalDate.parse("2019-06-21"), LocalTime.parse("16:45"), 9, "", myTables8);
//        bookingRepository.save(booking14);
//        Booking booking15 = new Booking(customer13, LocalDate.parse("2019-06-11"), LocalTime.parse("19:45"), 5, "", myTables10);
//        bookingRepository.save(booking15);
//        Booking booking16 = new Booking(customer3, LocalDate.parse("2019-06-11"), LocalTime.parse("17:30"), 10, "", myTables8);
//        bookingRepository.save(booking16);
//        Booking booking17 = new Booking(customer14, LocalDate.parse("2019-07-04"), LocalTime.parse("18:40"), 4, "", myTables);
//        bookingRepository.save(booking17);
//        Booking booking18 = new Booking(customer2, LocalDate.parse("2019-06-21"), LocalTime.parse("16:45"), 25, "E29 Graduation", myTables9);
//        bookingRepository.save(booking18);
//        Booking booking19 = new Booking(customer4, LocalDate.parse("2019-06-11"), LocalTime.parse("14:15"), 5, "", myTables5);
//        bookingRepository.save(booking19);
//        Booking booking20 = new Booking(customer12, LocalDate.parse("2019-06-11"), LocalTime.parse("19:45"), 15, "Job promotion", myTables6);
//        bookingRepository.save(booking20);
//
//        // transactions:
//// LocalDate date, int amountOwing, int amountPaid, Customer customer, Booking booking)
//        Transaction transaction1 = new Transaction(LocalDate.parse("2019-06-10"), 30, 30, customer1, booking1);
//        Transaction transaction2 = new Transaction(LocalDate.parse("2019-06-01"), 150, 50, customer2, booking2);
//        Transaction transaction3 = new Transaction( LocalDate.parse("2019-06-01"), 25, 25, customer3, booking3);
//        Transaction transaction4 = new Transaction(LocalDate.parse("2019-06-05"), 40, 40, customer3, booking4);
//        Transaction transaction5 = new Transaction(LocalDate.parse("2019-06-05"), 500, 100, customer2, booking4);
//        Transaction transaction6 = new Transaction(LocalDate.parse("2019-06-05"), 20, 20, customer1, booking4);
//        Transaction transaction7 = new Transaction(LocalDate.parse("2019-06-05"), 25,25, customer2, booking4);
//        Transaction transaction8 = new Transaction(LocalDate.parse("2019-06-01"), 10, 10, customer5, booking3);
//        Transaction transaction9 = new Transaction(LocalDate.parse("2019-06-01"), 15, 15, customer1, booking3);
//        Transaction transaction10 = new Transaction(LocalDate.parse("2019-06-10"), 20, 20, customer2, booking1);
//
//        transactionRepository.save(transaction1);
//        transactionRepository.save(transaction2);
//        transactionRepository.save(transaction3);
//        transactionRepository.save(transaction4);
//        transactionRepository.save(transaction5);
//        transactionRepository.save(transaction6);
//        transactionRepository.save(transaction7);
//        transactionRepository.save(transaction8);
//        transactionRepository.save(transaction9);
//        transactionRepository.save(transaction10);
//
//    }


//}

