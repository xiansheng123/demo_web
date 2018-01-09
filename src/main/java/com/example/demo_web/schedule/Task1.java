package com.example.demo_web.schedule;

import com.example.demo_web.Entity.PersonDB;
import com.example.demo_web.respository.PersonDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope("prototype")
public class Task1 implements Itask {
    private PersonDBRepository personDBRepository;

    @Autowired
    public Task1(PersonDBRepository personDBRepository) {
        this.personDBRepository = personDBRepository;
        System.out.println ("init:" + LocalDateTime.now ());
    }

    @Override
    public PersonDB getPersons(int id) {
        PersonDB onePerson = personDBRepository.findOne (id);
        return onePerson;
    }

}
