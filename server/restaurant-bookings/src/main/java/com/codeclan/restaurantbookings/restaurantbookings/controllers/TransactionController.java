package com.codeclan.restaurantbookings.restaurantbookings.controllers;

import com.codeclan.restaurantbookings.restaurantbookings.models.Transaction;
import com.codeclan.restaurantbookings.restaurantbookings.repositories.TransactionRepository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;

//    @GetMapping
//    public List<Transaction> getAllTransactions(){
//        return transactionRepository.findAll();
//    }

    // TODO date not working, check format
    @GetMapping(value="/date/{date}")
    public List<Transaction> getAllTransactionsForDate(@PathVariable String date) {
        return transactionRepository.findAllTransactionsByDate(date);
    }

    @GetMapping(value="/booking-id/{bookingId}")
    public List<Transaction> getTransactionsByBookingId(@PathVariable Long bookingId){
        return transactionRepository.getTransactionsByBookingId(bookingId);
    }


    @GetMapping(value="/customer-id/{customerId}")
    public List<Transaction> getTransactionsByCustomerId(@PathVariable Long customerId){
        return transactionRepository.getTransactionsByCustomerId(customerId);
    }

    @GetMapping(value="/customer-name/{customerName}")
    public List<Transaction> getTransactionsByCustomerName(@PathVariable String customerName){
        return transactionRepository.getTransactionsByCustomerName(customerName);
    }
}
