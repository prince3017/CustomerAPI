package com.prince.repository;


import com.prince.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public  interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT * FROM Customers s where s.first_name like %:keyword% or s.last_name like %:keyword% or s.street like %:keyword% or s.address like %:keyword% or s.city like %:keyword% or s.state like %:keyword% or s.email like %:keyword% or s.phone like %:keyword%", nativeQuery = true)
    public List<Customer> findByKeyword(@Param("keyword") String keyword);



}
