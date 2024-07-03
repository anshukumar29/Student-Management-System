package com.Anish.Create.a.Portal.service;

import com.Anish.Create.a.Portal.model.Address;
import com.Anish.Create.a.Portal.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepo addressRepo;

    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepo.findById(id).orElse(null);
    }

    public void saveAddress(Address address) {
        addressRepo.save(address);
    }

    public void updateAddress(Long id, Address updatedAddress) {
        Address address = addressRepo.findById(id).orElse(null);
        if (address != null) {
            // Update address fields here
            address.setLandmark(updatedAddress.getLandmark());
            address.setZipcode(updatedAddress.getZipcode());
            address.setDistrict(updatedAddress.getDistrict());
            address.setState(updatedAddress.getState());
            address.setCountry(updatedAddress.getCountry());

            addressRepo.save(address);
        }
    }

    public void deleteAddress(Long id) {
         addressRepo.deleteById(id);
    }
}
