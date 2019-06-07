package com.example.demo_web.service;

import com.example.demo_web.Entity.CarDB;
import com.example.demo_web.respository.CarDBRespository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarDBRespository carDBRespository;

    public CarDB getCarbyName(String name) {
        List<CarDB> carlist = carDBRespository.findByName (name);

        return carlist.isEmpty () ? null : carlist.get (0);
    }

    public CarDB getCarbyBrand(String brand) {
        return carDBRespository.findByBrand (brand).get (0);
    }

    public void saveCar(CarDB carDB) {
        carDBRespository.save (carDB);
    }

}
