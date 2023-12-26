package com.kafkazets.customer;

import com.kafkazets.AbstractTestcontainers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import java.util.UUID;


import static org.mockito.Mockito.verify;

class CustomerJPADataAccessServiceTest{

    private CustomerJPADataAccessService underTest;
    private AutoCloseable autoCloseable;
    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CustomerJPADataAccessService(customerRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();

    }

    @Test
    void selectAllCustomers() {
        // When
        underTest.selectAllCustomers();
        //Then
        verify(customerRepository).findAll();
    }

    @Test
    void selectCustomerById() {
        // Given
        int id = 1;

        // When
        underTest.selectCustomerById(id);

        //Then
        verify(customerRepository).findById(id);
    }

    @Test
    void insertCustomer() {
        // Given

        Customer customer = new Customer(
                "Ibrahim Bayramov",
                "ibrahim-bayramov@hotmail.com",
                20
        );

        // When
        underTest.insertCustomer(customer);

        //Then
        verify(customerRepository).save(customer);
    }

    @Test
    void existsCustomerWithEmail() {
        // Given
        String email = "hello@mello.com";

        // When
        underTest.existsCustomerWithEmail(email);

        //Then
        verify(customerRepository).existsCustomerByEmail(email);
    }

    @Test
    void existsCustomerWithId() {
        // Given
        int id = 1;

        // When
        underTest.existsCustomerWithId(id);

        //Then
        verify(customerRepository).existsCustomerById(id);
    }

    @Test
    void deleteCustomerById() {
        // Given
        int id = 1;

        // When
        underTest.deleteCustomerById(id);

        //Then
        verify(customerRepository).deleteById(id);
    }

    @Test
    void updateCustomer() {
        // Given

        Customer customer = new Customer(
                "Ibrahim Bayramov",
                "ibrahim-bayramov@hotmail.com",
                20
        );


        // When
        underTest.updateCustomer(customer);

        //Then
        verify(customerRepository).save(customer);
    }
}