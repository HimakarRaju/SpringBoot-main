package com.myfinbank.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfinbank.entity.Account;
import com.myfinbank.entity.Address;
import com.myfinbank.entity.Customer;
import com.myfinbank.repository.AddressRepository;
import com.myfinbank.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
        if (customer.getAddress() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Address information is required.");
        }
        Address address = customer.getAddress();
        if (address.getAddress_id() == null || !addressRepository.existsById(address.getAddress_id())) {
            addressRepository.save(address);
        }

        customer.setAddress(address);
        Customer registeredCustomer = customerService.registerCustomer(customer);
        if (registeredCustomer != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Registration successful.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestBody Map<String, String> loginData) {
        String emailId = loginData.get("email");
        String password = loginData.get("password");
        Customer loggedInCustomer = customerService.loginCustomer(emailId, password);
        if (loggedInCustomer != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Login successful. Welcome to your dashboard!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials.");
        }
    }
    
    @GetMapping("/accounts/{customerId}")
    public List<Account> getAccountsByCustomerId(@PathVariable Integer customerId) {
        return customerService.getAccountsByCustomerId(customerId);
    }
}


