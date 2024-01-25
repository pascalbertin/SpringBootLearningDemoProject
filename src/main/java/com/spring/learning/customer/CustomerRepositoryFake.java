package com.spring.learning.customer;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
@Repository(value = "fake") // no needed due to bean configuration
public class CustomerRepositoryFake implements CustomerRepo {

    @Override
    public List<Customer> getCustomer() {
        return Arrays.asList(
                new Customer(1L, "Pascal", "12345", "email@wp.pl"),
                new Customer(2L, "CJ", "qwerty", "mail@email.com")
        );
    }
}
