package com.revature.revaturebookshelfjava.service;

import com.revature.revaturebookshelfjava.entity.Address;
import com.revature.revaturebookshelfjava.entity.User;

public interface AddressService {
    void registerAddress(Address address, User user) throws Exception;
}
