package com.example.demo_web.controller;

import com.example.demo_web.Entity.CarDB;
import com.example.demo_web.respository.CarDBRespository;
import com.example.demo_web.respository.CarDBTemplateRespository;
import com.example.demo_web.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Cars")
public class CarDBController {
    @Autowired
    private CarDBRespository carDBRespository;
    @Autowired
    private CarService carService;
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
}
