package com.example.demo_web.service;

import com.example.demo_web.Entity.PersonDB;
import com.example.demo_web.Entity.SystemCode;
import com.example.demo_web.respository.PersonDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDBService extends PersonCommon {
    private PersonDBRepository personDBRepository;
   @Autowired
    public PersonDBService( PersonDBRepository personDBRepository ) {
       this.personDBRepository = personDBRepository;
       personDBS= personDBRepository.findByName("ZouXuan") ;
    }
    private final List<PersonDB> personDBS ;
    public void test() {
        System.out.println(personDBS);
    }

}
