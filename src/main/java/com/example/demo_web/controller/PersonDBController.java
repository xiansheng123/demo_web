package com.example.demo_web.controller;

import com.example.demo_web.model.PersonDB;
import com.example.demo_web.service.PersonDBRepository;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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

    @RequestMapping(value = "/getPersonByName/{Name}")
    public List<PersonDB> getOneByName(@PathVariable("Name") String name) {
        List<PersonDB> entity =  personServiceDB.findByName(name);
       // System.out.println(personServiceDB.findByName("tom"));
        return entity;
    }

    @RequestMapping(value = "/getPersonByAge/{Age}")
    public List<PersonDB> getOneByName(@PathVariable("Age") Integer age) {
        List<PersonDB> entity =  personServiceDB.findByAge(age);
        // System.out.println(personServiceDB.findByName("tom"));
        return entity;
    }

    @RequestMapping(value = "/addHardPerson")
    public PersonDB AddHardPerson (  ){
        PersonDB person   =new PersonDB("ZouXuan",27,false );
        personServiceDB.save(person);
        return person;
    }

    @RequestMapping(method = RequestMethod.POST ,value = "/addPerson")
    public void AddPerson (@RequestBody PersonDB person ){
        personServiceDB.save(person);
    }
}
