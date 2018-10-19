package com.shelpablo.springpostgres.service;

import com.shelpablo.springpostgres.entity.Address;
import com.shelpablo.springpostgres.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public void createAddress(Address address){
        addressRepository.save(address);
    }
//далее уже допишите сами)
}