package com.example.demo_web.controller;

import com.example.demo_web.Entity.CarDB;
import com.example.demo_web.respository.CarDBRespository;
import com.example.demo_web.service.CarService;
import com.example.demo_web.service.CarTest;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Cars")
@Log4j
public class CarDBController {
    @Autowired
    private CarDBRespository carDBRespository;
    @Autowired
    private CarService carService;
    @Autowired
    private CarTest carTest;

    @RequestMapping(value = "/getOneCar")
    public CarDB getOne() {
        return carDBRespository.getOne(10);
    }
    @RequestMapping(value = "/findOneCar")
    public CarDB findOne() {
        return carDBRespository.findOne(10);
    }
    @RequestMapping(value = "/findCarById/{id}")
    public CarDB findCarById(@PathVariable("id") String id) {
        return carDBRespository.findOne(Integer.valueOf(id));
    }

    @RequestMapping(value = "/findCarByName/{name}")
    public CarDB findCarByname(@PathVariable("name") String name) {
        return carService.getCarbyName(name);
    }
    @RequestMapping(value = "/findCarByBrand/{brand}")
    public CarDB findCarByBrand(@PathVariable("brand") String Brand) {
        return carService.getCarbyBrand(Brand);
    }

    @PostMapping(value = "/addxudacar")
    public String addXudaCar() throws Exception {
        carTest.saveCarTest (CarDB.builder ()
                .name ("xudacar")
                .model ("car")
                .brand ("BMW")
                .build ());
        return "ok";
    }
}
