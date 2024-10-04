package com.ust.LaptopRecommendation.controller;

import com.ust.LaptopRecommendation.model.Laptopinfo;
import com.ust.LaptopRecommendation.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;


    @PostMapping("/add")
    public ResponseEntity<Laptopinfo> addLaptop(@RequestBody Laptopinfo laptop) {
        Laptopinfo savedLaptop = laptopService.saveLaptop(laptop);
        return new ResponseEntity<>(savedLaptop, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Laptopinfo>> getAllLaptops() {
        List<Laptopinfo> laptops = laptopService.getAllLaptops();
        return new ResponseEntity<>(laptops, HttpStatus.OK);
    }


    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Laptopinfo>> getLaptopsByBrand(@PathVariable String brand) {
        List<Laptopinfo> laptops = laptopService.getLaptopsByBrand(brand);
        return new ResponseEntity<>(laptops, HttpStatus.OK);
    }

    @GetMapping("/ram/{ram}")
    public ResponseEntity<List<Laptopinfo>> getLaptopsByRam(@PathVariable int ram) {
        List<Laptopinfo> laptops = laptopService.getLaptopsByRam(ram);
        return new ResponseEntity<>(laptops, HttpStatus.OK);
    }


    @GetMapping("/price")
    public ResponseEntity<List<Laptopinfo>> getLaptopsByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        List<Laptopinfo> laptops = laptopService.getLaptopsByPriceRange(minPrice, maxPrice);
        return new ResponseEntity<>(laptops, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLaptop(@PathVariable Long id) {
        laptopService.deleteLaptop(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
