package com.spring.learning.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomer() {
        // Given
        Customer pascal = new Customer(1L, "Pascal", "password1234", "test@wp.pl");
        customerRepository.save(pascal);

        // When
        Customer actual = underTest.getCustomer(1L);

        // Then
        assertEquals(1L, actual.getId());
        assertEquals("Pascal", actual.getName());
        assertEquals("password1234", actual.getPassword());
        assertEquals("test@wp.pl", actual.getEmail());
    }

    @Test
    void getAllCustomers() {
        // Given
        Customer pascal = new Customer(1L, "Pascal", "password1234", "test@wp.pl");
        Customer cj = new Customer(2L, "CJ", "1234", "cj@wp.pl");
        customerRepository.saveAll(Arrays.asList(pascal, cj));

        // When
        List<Customer> actual = underTest.getCustomer();

        // Then
        assertEquals(2, actual.size());
    }
}