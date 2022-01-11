package com.revature.revaturebookshelfjava.service;

import com.revature.revaturebookshelfjava.entity.Address;
import com.revature.revaturebookshelfjava.entity.AddressType;
import com.revature.revaturebookshelfjava.entity.User;
import com.revature.revaturebookshelfjava.repository.AddressRepository;
import com.revature.revaturebookshelfjava.repository.AddressTypeRepository;
import com.revature.revaturebookshelfjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final AddressTypeRepository addressTypeRepository;

    private final UserRepository userRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, AddressTypeRepository addressTypeRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.addressTypeRepository = addressTypeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void registerAddress(Address address, User user) throws Exception {

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
                //List<Address> addyList = new ArrayList<>(user.getAddresses());
                List<Address> addyList = new ArrayList<>();
                addyList.add(newAddress);
                user.setAddresses(addyList);
                //addressRepository.save(newAddress);
                userRepository.save(user);
            }
        }
    }
}
