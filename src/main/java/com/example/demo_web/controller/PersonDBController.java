package com.example.demo_web.controller;

import com.example.demo_web.model.PersonDB;
import com.example.demo_web.model.SystemCode;
import com.example.demo_web.service.PersonDBRepository;
import com.example.demo_web.service.SystemCodeDBRepository;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.assertj.core.util.Compatibility;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by luxuda on 6/20/2017.
 */
@RestController
public class PersonDBController {


     @Autowired
     private PersonDBRepository personServiceDB;
     @Autowired
     private SystemCodeDBRepository systemCodeDBRepository;
    @RequestMapping(value = "/getPersons")
    public List<PersonDB> getAll() {
        List<PersonDB> entity = personServiceDB.findAll();
            return entity;
    }
    @RequestMapping(value = "/getSystemCode")
    public List<SystemCode> getALLCodes() {
        List<SystemCode> entity = systemCodeDBRepository.findAll();
        return entity;
    }
    @RequestMapping(value = "/getHardSystemCode")
    public List<SystemCode> getsystemCodes() {
        List<SystemCode> entity = systemCodeDBRepository.findByCodename("ZouXuan");
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
    public PersonDB AddHardPerson ( ){
        PersonDB person =new PersonDB("ZouXuan",27,false );
        personServiceDB.save(person);
        return person;
    }

    @RequestMapping(value = "/runProcedure")
    public void RunProcedure ( ){
        personServiceDB.Demo_Test("benchi",89);
        System.out.print("Successfully!");
    }

    @RequestMapping(value = "/runProcedureout")
    public String RunProcedureout (  ){
       return  personServiceDB.Demo_Test_out("benchiout",90);
    }

    //update and insert
  //  @RequestMapping(method = RequestMethod.POST ,value = "/addPerson")
    @PostMapping(value = "/addPerson")
    public String AddPerson (@Validated @RequestBody PersonDB person, BindingResult br){

        if (br.hasErrors()){
            return "Validate failed :" ;//+br.getAllErrors();
       }else{
            personServiceDB.save(person);
            return "save Successfully ";
        }

    }


}
