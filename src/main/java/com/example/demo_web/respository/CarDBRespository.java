package com.example.demo_web.respository;

import com.example.demo_web.Entity.CarDB;

import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Cacheable(value="Car",key = "#id+'dataMap'")

@CacheConfig(cacheNames = "Car")

public interface CarDBRespository extends JpaRepository<CarDB, Integer> {
   // @Cacheable(value="findByName")

   // @Cacheable
    List<CarDB> findByName(String name);

    @Cacheable(value="findByBrand")
    List<CarDB> findByBrand(String Brand);
}
