package com.Anish.Create.a.Portal.controller;

import com.Anish.Create.a.Portal.model.Laptop;
import com.Anish.Create.a.Portal.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptops")

public class LaptopController {
    @Autowired
    LaptopService laptopService;

    @GetMapping
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laptop> getLaptopById(@PathVariable String id) {
        Laptop laptop = laptopService.getLaptopById(id);
        if (laptop != null) {
            return ResponseEntity.ok(laptop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> saveLaptop(@RequestBody Laptop laptop) {
        laptopService.saveLaptop(laptop);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLaptop(@PathVariable String id, @RequestBody Laptop updatedLaptop) {
        if (laptopService.getLaptopById(id) != null) {
            laptopService.updateLaptop(id, updatedLaptop);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaptop(@PathVariable String id) {
        if (laptopService.getLaptopById(id) != null) {
            laptopService.deleteLaptop(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
