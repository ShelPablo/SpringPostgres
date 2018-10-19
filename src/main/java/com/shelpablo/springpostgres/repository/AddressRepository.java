package com.shelpablo.springpostgres.repository;

import com.shelpablo.springpostgres.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}