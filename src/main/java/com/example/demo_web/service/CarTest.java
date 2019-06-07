package com.example.demo_web.service;

import com.example.demo_web.Entity.CarDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import javax.transaction.Transactional;

@Service
public class CarTest {
    @Autowired
    private CarService carService;

    @Transactional
    public void saveCarTest(CarDB carDB)  {

        if (carService.getCarbyName ("xudacar") == null) {
            carService.saveCar (carDB);
        }

      throw new RuntimeException ("happ error ");

    }

}
