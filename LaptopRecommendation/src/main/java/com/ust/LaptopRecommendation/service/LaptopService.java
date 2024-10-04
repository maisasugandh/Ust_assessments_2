package com.ust.LaptopRecommendation.service;

import com.ust.LaptopRecommendation.model.Laptopinfo;
import com.ust.LaptopRecommendation.repo.Laptoprepo;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    private Laptoprepo laptopRepo;

    @Autowired
    private JPAStreamer jpaStreamer;


    public Laptopinfo saveLaptop(Laptopinfo laptop) {
        return laptopRepo.save(laptop);
    }


    public List<Laptopinfo> getAllLaptops() {
        return laptopRepo.findAll();
    }


    public List<Laptopinfo> getLaptopsByBrand(String brand) {
        return jpaStreamer.stream(Laptopinfo.class)
                .filter(laptop -> laptop.getBrand().equalsIgnoreCase(brand))
                .toList();
    }


    public List<Laptopinfo> getLaptopsByRam(int ram) {
        return jpaStreamer.stream(Laptopinfo.class)
                .filter(laptop -> laptop.getRam() >= ram)
                .toList();
    }


    public List<Laptopinfo> getLaptopsByPriceRange(double minPrice, double maxPrice) {
        return jpaStreamer.stream(Laptopinfo.class)
                .filter(laptop -> laptop.getPrice() >= minPrice && laptop.getPrice() <= maxPrice)
                .toList();
    }

    public void deleteLaptop(Long id) {
        laptopRepo.deleteById(id);
    }
}
