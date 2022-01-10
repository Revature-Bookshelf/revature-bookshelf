package com.revature.revaturebookshelfjava.service;

import com.revature.revaturebookshelfjava.entity.Address;
import com.revature.revaturebookshelfjava.entity.AddressType;
import com.revature.revaturebookshelfjava.entity.User;
import com.revature.revaturebookshelfjava.repository.AddressRepository;
import com.revature.revaturebookshelfjava.repository.AddressTypeRepository;
import com.revature.revaturebookshelfjava.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerAddress(Address address, User user) throws Exception {
//        // At this point: user entity loaded
//        /*
//         * Checks:
//         *   -incoming address does not exist in database
//         *       - if (addressTypes in DB)
//         *           - load (BILLING and/or SHIPPING)
//         *
//         *
//         */
//        // TODO: USE STREAM API FOR SUPPORT OF MULTIPLE input TYPES
//        // Checking Address Types if can be loaded.
//        // incoming addressType does not have entity association so if match found, associate
//        AddressType addressTypeQuery = addressTypeRepository.findByType(address.getTypes().iterator().next().getType());
//        if (addressTypeQuery != null) {
//            address.setTypes(List.of(addressTypeQuery));
//        }
//
//        // Check for existing address
//        Address addressQuery = addressRepository.findAddressByStreetNameAndCityAndStateAndPostalCode(address.getStreetName(), address.getCity(), address.getState(), address.getPostalCode());
//        // addressQuery is  null implies address is not in DB
//        // addressQuery is !null implies address is in DB -> load existing types into DB
//        if (addressQuery != null) {
//            List<AddressType> addressTypeList = new ArrayList<>(address.getTypes());
//            //addressTypeList.addAll(addressQuery.getTypes());
//            //addressQuery.setTypes(addressTypeList);
//            address.setTypes(addressTypeList);
//            //address = addressQuery;
//        }
//
//        // Updating User Entity
//        List<Address> addyList = new ArrayList<>(user.getAddresses());
//        addyList.add(address);
//        user.setAddresses(addyList);
//        System.out.println("breakpoint");
//
//        //addressRepository.saveAndFlush(address);
//        addressRepository.save(address);

//        Optional<Address> optionalAddress = addressRepository.findAddressByStreetNameAndCityAndStateAndPostalCode(address.getStreetName(), address.getCity(), address.getState(), address.getPostalCode());
//        if (optionalAddress.isEmpty()) {
//            addressRepository.save(address);
//        }
//        else {
//            if (optionalAddress.get().getTypes().equals(address.getTypes())) {
//                throw new Exception("Address already exists");
//            }
//            else {
//                Address newAddress = optionalAddress.get();
//                newAddress.setTypes(address.getTypes());
//                addressRepository.save(newAddress);
//            }
//        }
//        Optional<Address> optionalAddress = addressRepository.findAddressByStreetNameAndCityAndStateAndPostalCode(address.getStreetName(), address.getCity(), address.getState(), address.getPostalCode());
//        if (optionalAddress.isEmpty()) {
//            addressRepository.save(address);
//        }
//        else {
//            if (optionalAddress.get().getTypes().equals(address.getTypes())) {
//                throw new Exception("Address already exists");
//            }
//            else {
//                Address newAddress = optionalAddress.get();
//                List<AddressType> newTypes = new ArrayList<>();
//                // Optional<List<AddressType>> allTypes = addressTypeRepository.findAll();
//                for(AddressType addType : address.getTypes()) {
//                    Optional<AddressType> optionAddressType = addressTypeRepository.findByType(addType.getType());
//                    if (optionAddressType.isEmpty()) {
//                        throw new Exception("Invalid address type");
//                    }
//                    newTypes.add(optionAddressType.get());
//                }
//                newAddress.setTypes(newTypes);
//                addressRepository.save(newAddress);
//            }
//        }
//    }
//        Optional<Address> optionalAddress = addressRepository.findAddressByStreetNameAndCityAndStateAndPostalCode(address.getStreetName(), address.getCity(), address.getState(), address.getPostalCode());
//        if (optionalAddress.isEmpty()) {
//            Address newAddress = address;
//            List<AddressType> newTypes = new ArrayList<>();
//            // Optional<List<AddressType>> allTypes = addressTypeRepository.findAll();
//            for (AddressType addType : address.getTypes()) {
//                Optional<AddressType> optionAddressType = addressTypeRepository.findByType(addType.getType());
//                if (optionAddressType.isEmpty()) {
//                    throw new Exception("Invalid address type");
//                }
//                newTypes.add(optionAddressType.get());
//            }
//            /*
//            *
//            * */
//            newAddress.setTypes(newTypes);
//            addressRepository.save(newAddress);
//        } else {
//            if (optionalAddress.get().getTypes().equals(address.getTypes())) {
//                throw new Exception("Address already exists");
//            } else {
//                Address newAddress = optionalAddress.get();
//                List<AddressType> newTypes = new ArrayList<>();
//                // Optional<List<AddressType>> allTypes = addressTypeRepository.findAll();
//                for (AddressType addType : address.getTypes()) {
//                    Optional<AddressType> optionAddressType = addressTypeRepository.findByType(addType.getType());
//                    if (optionAddressType.isEmpty()) {
//                        throw new Exception("Invalid address type");
//                    }
//                    newTypes.add(optionAddressType.get());
//                }
//                newAddress.setTypes(newTypes);
//                addressRepository.save(newAddress);
//            }
//        }
        Optional<Address> optionalAddress = addressRepository.findAddressByStreetNameAndCityAndStateAndPostalCode(address.getStreetName(), address.getCity(), address.getState(), address.getPostalCode());
        if (optionalAddress.isEmpty()) {
            Address newAddress = address;
            List<AddressType> newTypes = new ArrayList<>();
            // Optional<List<AddressType>> allTypes = addressTypeRepository.findAll();
            for (AddressType addType : address.getTypes()) {
                Optional<AddressType> optionAddressType = addressTypeRepository.findByType(addType.getType());
                if (optionAddressType.isEmpty()) {
                    throw new Exception("Invalid address type");
                }
                newTypes.add(optionAddressType.get());
            }
            newAddress.setTypes(newTypes);
            List<Address> addyList = new ArrayList<>(user.getAddresses());
            addyList.add(newAddress);
            user.setAddresses(addyList);
            userRepository.save(user);
            //addressRepository.save(newAddress);
        } else {
            if (optionalAddress.get().getTypes().equals(address.getTypes())) {
                throw new Exception("Address already exists");
            } else {
                Address newAddress = optionalAddress.get();
                List<AddressType> newTypes = new ArrayList<>();
                // Optional<List<AddressType>> allTypes = addressTypeRepository.findAll();
                for (AddressType addType : address.getTypes()) {
                    Optional<AddressType> optionAddressType = addressTypeRepository.findByType(addType.getType());
                    if (optionAddressType.isEmpty()) {
                        throw new Exception("Invalid address type");
                    }
                    newTypes.add(optionAddressType.get());
                }
                newAddress.setTypes(newTypes);
                List<Address> addyList = new ArrayList<>(user.getAddresses());
                addyList.add(newAddress);
                user.setAddresses(addyList);
                //addressRepository.save(newAddress);
                userRepository.save(user);
             }
        }
    }
}
