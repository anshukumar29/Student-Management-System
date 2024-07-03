package com.Anish.Create.a.Portal.service;

import com.Anish.Create.a.Portal.model.Laptop;
import com.Anish.Create.a.Portal.repository.LaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    @Autowired
    LaptopRepo laptopRepo;
    public List<Laptop> getAllLaptops() {
        return laptopRepo.findAll();
    }

    public Laptop getLaptopById(String id) {
        return laptopRepo.findById(id).orElse(null);
    }

    public void saveLaptop(Laptop laptop) {
        laptopRepo.save(laptop);
    }

    public void updateLaptop(String id, Laptop updatedLaptop) {
        Laptop laptop = laptopRepo.findById(id).orElse(null);
        if (laptop != null) {
            // Update laptop fields here
            laptop.setName(updatedLaptop.getName());
            laptop.setBrand(updatedLaptop.getBrand());
            laptop.setPrice(updatedLaptop.getPrice());

             laptopRepo.save(laptop);
        }
    }

    public void deleteLaptop(String id) {
        laptopRepo.deleteById(id);
    }
}
