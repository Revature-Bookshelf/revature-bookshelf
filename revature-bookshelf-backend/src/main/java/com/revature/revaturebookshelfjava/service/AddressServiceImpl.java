package com.revature.revaturebookshelfjava.service;

import com.revature.revaturebookshelfjava.entity.Address;
import com.revature.revaturebookshelfjava.entity.AddressType;
import com.revature.revaturebookshelfjava.entity.User;
import com.revature.revaturebookshelfjava.repository.AddressRepository;
import com.revature.revaturebookshelfjava.repository.AddressTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressTypeRepository addressTypeRepository;

    @Override
    public void registerAddress(Address address, User user) {
        // At this point: user entity loaded
        /*
         * Checks:
         *   -incoming address does not exist in database
         *       - if it does
         *           -checking addressTypes (BILLING and/or SHIPPING)
         *
         *
         */
        // TODO: USE STREAM API FOR SUPPORT OF MULTIPLE input TYPES
        // Checking Address Types if can be loaded.
        // incoming addressType does not have entity association so if match found, associate
        AddressType result1 = addressTypeRepository.findByType(address.getTypes().iterator().next().getType());
        if (result1 != null) {
            address.setTypes(List.of(result1));
        }

        // Check for existing address
        Address addressQuery = addressRepository.findAddressByStreetNameAndCityAndStateAndPostalCode(address.getStreetName(), address.getCity(), address.getState(), address.getPostalCode());
        // addressQuery is  null implies address is not in DB
        // addressQuery is !null implies address is in DB -> load existing types into DB
        if (addressQuery != null) {
            List<AddressType> addressTypeList = new ArrayList<>(address.getTypes());
            //addressTypeList.addAll(addressQuery.getTypes());
            //addressQuery.setTypes(addressTypeList);
            address.setTypes(addressTypeList);
            //address = addressQuery;
        }
        // TODO: USE STREAM API
        // Updating User Entity
        List<Address> addyList = new ArrayList<>(user.getAddresses());
        addyList.add(address);
        user.setAddresses(addyList);
        System.out.println("breakpoint");

        //addressRepository.saveAndFlush(address);
        addressRepository.save(address);
    }
}
