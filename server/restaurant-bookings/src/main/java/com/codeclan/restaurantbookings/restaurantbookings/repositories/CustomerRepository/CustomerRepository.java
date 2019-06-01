package com.codeclan.restaurantbookings.restaurantbookings.repositories.CustomerRepository;

import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
