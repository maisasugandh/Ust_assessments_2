package com.ust.LaptopRecommendation.repo;

import com.ust.LaptopRecommendation.model.Laptopinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Laptoprepo extends JpaRepository<Laptopinfo,Long> {

}
