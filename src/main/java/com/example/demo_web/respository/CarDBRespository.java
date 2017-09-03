package com.example.demo_web.respository;

import com.example.demo_web.Entity.CarDB;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Cacheable(value="Car",key = "#id+'dataMap'")
@Cacheable(value="CarDBRespository")
public interface CarDBRespository extends JpaRepository<CarDB, Integer> {
    List<CarDB> findByName(String name);
    List<CarDB> findByBrand(String Brand);
}
