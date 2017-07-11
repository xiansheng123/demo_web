package com.example.demo_web.controller;

import com.example.demo_web.model.PersonDB;
import com.example.demo_web.service.PersonDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * Created by luxuda on 6/20/2017.
 */
@RestController
public class PersonDBController {


    @Autowired
    private PersonDBRepository personServiceDB;

    @RequestMapping(value = "/getPersons")
    public List<PersonDB> getAll() {
        List<PersonDB> entity = personServiceDB.findAll();
            return entity;
    }

    @RequestMapping(value = "/getOnePerson/{Age}")
    public List<PersonDB> getOneByName(@PathVariable("Age") Integer name) {
        List<PersonDB> entity =  personServiceDB.findById(name);

        System.out.println(personServiceDB.findByName("tom"));
        return entity;
    }
}
