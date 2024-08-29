package com.myfinbank.entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer account_no;

    private String account_type;
    private Date account_opened_date;
    private Double balance;
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    // Default Constructor
    public Account() {
    }

    // Parameterized Constructor
    public Account(String account_type, Date account_opened_date, Double balance, String status, Customer customer) {
        this.account_type = account_type;
        this.account_opened_date = account_opened_date;
        this.balance = balance;
        this.status = status;
        this.customer = customer;
    }

    // Getters and Setters
    public Integer getAccount_no() {
        return account_no;
    }

    public void setAccount_no(Integer account_no) {
        this.account_no = account_no;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public Date getAccount_opened_date() {
        return account_opened_date;
    }

    public void setAccount_opened_date(Date account_opened_date) {
        this.account_opened_date = account_opened_date;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
