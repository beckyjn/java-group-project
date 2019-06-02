package com.codeclan.restaurantbookings.restaurantbookings.repositories.TransactionRepository;

import com.codeclan.restaurantbookings.restaurantbookings.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository  extends JpaRepository<Transaction, Long>, TransactionRepositoryCustom{
    List<Transaction> findTransactionsByCustomerId(Long customerId);
    List<Transaction> findTransactionsByBookingId(Long bookingId);

}

