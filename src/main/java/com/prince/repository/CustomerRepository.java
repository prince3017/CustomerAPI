package com.prince.repository;


import com.prince.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface CustomerRepository extends JpaRepository<Customer, Long> {
}
