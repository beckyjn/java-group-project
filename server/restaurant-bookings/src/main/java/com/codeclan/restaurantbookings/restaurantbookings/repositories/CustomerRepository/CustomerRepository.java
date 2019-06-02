package com.codeclan.restaurantbookings.restaurantbookings.repositories.CustomerRepository;

import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomerByName(String name);
}
