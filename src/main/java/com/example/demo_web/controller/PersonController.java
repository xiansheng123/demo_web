package com.example.demo_web.controller;

/**
 * Created by luxuda on 6/13/2017.
 */
import java.util.Hashtable;

import com.example.demo_web.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo_web.Entity.Person;

@RestController
@RequestMapping("/persons")
public class PersonController {

   @Autowired
 private PersonService ps ;
//right
 //PersonService ps =new PersonService();


    @RequestMapping("/all")
    public Hashtable<String,Person>getAll(){
        return ps.getAll();
    }
    @RequestMapping("/{id}")
    public Person getPerson (@PathVariable("id") String id){
        return ps.getPerson(id);
    }

    //http://localhost:8080/persons/hello?name=123
    @RequestMapping(value = "/hello" ,method=RequestMethod.GET)
    public String getHello (@RequestParam("name")  String name ){
        //    public String getHello ( ){

        return  "Hello 3 " +name ;
    }


    @RequestMapping(method = RequestMethod.POST ,value = "/add")
    public void getPerson (@RequestBody Person person ){
          ps.addPerson(person);
    }

}
