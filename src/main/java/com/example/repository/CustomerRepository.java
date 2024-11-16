package com.example.repository;

import com.example.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    @Override
    List<Customer> findAll();

    Customer findByFirstName(String firstName);
}
