package com.example.demo_web.controller;

/**
 * Created by luxuda on 6/13/2017.
 */

import com.example.demo_web.Entity.Person;
import com.example.demo_web.Entity.SystemCode;
import com.example.demo_web.Entity.TabTest;
import com.example.demo_web.service.PersonDBService;
import com.example.demo_web.service.PersonService;
import com.example.demo_web.service.TabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService ps;

    @Autowired
    private PersonDBService psd;

    @Autowired
    private TabTestService tabTestService;

    @Value("${com.neo.description}")
    private String getProperties;

    @RequestMapping("/all")
    public Hashtable<String,Person>getAll(){
        return ps.getAll();
    }
    @RequestMapping("/getProperty")
    public String personBean(){
        System.out.println(getProperties);
        return getProperties ;
    }

    @RequestMapping("/{id}")
    public Person getPerson (@PathVariable("id") String id){
        return ps.getPerson(id);
    }

    @RequestMapping("Test/{id}")
    public Object getSystemCode (@PathVariable("id") String id){
       return tabTestService.getSystemCodeById(new Integer(id));
    }


    @RequestMapping(method = RequestMethod.POST ,value = "/add")
    public void getPerson (@RequestBody Person person ){
          ps.addPerson(person);
    }


}
