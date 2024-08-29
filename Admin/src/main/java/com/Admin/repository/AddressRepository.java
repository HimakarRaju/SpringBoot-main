package com.Admin.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Admin.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
