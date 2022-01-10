package com.revature.revaturebookshelfjava.repository;

import com.revature.revaturebookshelfjava.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    // save() is native to JpaRepository
    Address findAddressByStreetNameAndCityAndStateAndPostalCode(String streetName,String city, String state, int postalCode);
}
