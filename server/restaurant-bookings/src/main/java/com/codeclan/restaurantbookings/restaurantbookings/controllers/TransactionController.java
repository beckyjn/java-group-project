package com.codeclan.restaurantbookings.restaurantbookings.controllers;

import com.codeclan.restaurantbookings.restaurantbookings.models.Transaction;
import com.codeclan.restaurantbookings.restaurantbookings.repositories.TransactionRepository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping
    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }
}
