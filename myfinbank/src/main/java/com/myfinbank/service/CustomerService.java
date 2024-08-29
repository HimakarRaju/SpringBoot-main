package com.myfinbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfinbank.entity.Account;
import com.myfinbank.entity.Customer;
import com.myfinbank.repository.AccountRepository;
import com.myfinbank.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer loginCustomer(String Email, String password) {
        Customer customer = customerRepository.findByEmail(Email);
        if (customer != null && password.equals(customer.getPassword())) {
            return customer;
        }
        return null;
    }

    public List<Account> getAccountsByCustomerId(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null) {
            return accountRepository.findByCustomer(customer);
        }
        return null;
    }

    // Adding this method to retrieve all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Adding this method to retrieve all accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
