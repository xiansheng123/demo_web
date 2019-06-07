package com.example.demo_web.service;

import com.example.demo_web.Entity.Person;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.Assert.*;


public class PersonServiceTest {
    @Test
    public void showHuman() throws Exception {
      PersonService personService =new PersonService ();
        Person person =new Person ();
        person.setFirstname ("xuda");
        person.setAge (29);
     // personService.showHuman (person);
    }
}