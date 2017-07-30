package com.example.demo_web.Util;

import com.example.demo_web.Entity.Person;
import org.junit.Test;

import java.time.Period;

import static org.junit.Assert.*;

/**
 * Created by luxuda on 7/30/2017.
 */
public class GenericPersonTest {

    @Test
  public   void genericPerson() {
        GenericPerson<Person> myperson = new GenericPerson<>();
        myperson.setPersonDB(Person.builder()
                .firstname("xuda")
                .lastname("lu")
                .age(28).build()
        );
        System.out.println(myperson.toString());
    }
}