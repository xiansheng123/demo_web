package com.example.demo_web.Util;

import com.example.demo_web.Entity.Person;
import org.junit.Test;

import java.time.Period;
import java.util.Hashtable;

import static org.junit.Assert.*;

/**
 * Created by luxuda on 7/30/2017.
 */
public class GenericPersonTest {

    @Test
    public void genericPerson() {
        GenericPerson<Person> myperson = new GenericPerson<>();
        myperson.setPersonDB(Person.builder()
                .firstname("xuda")
                .lastname("lu")
                .age(28).build()
        );
        System.out.println(myperson.toString());
    }

    @Test
    public void HashTableTest() {
        Hashtable<String, Person> mytable = new Hashtable<String, Person>() {{
            put("First", Person.builder()
                    .firstname("xuda")
                    .lastname("lu")
                    .age(28).build());
            put("Second", Person.builder()
                    .firstname("xuda2")
                    .lastname("lu2")
                    .age(29).build());
        }};
        System.out.println(mytable.get("First"));
        System.out.println(mytable.get("Second"));
    }

    @Test
    public void mytest1()
    {
        int test1=1;
        int test2=0;
        for(int m=0;m<10;m++){
            test1=test1++;
            test2=++test2;
        }
        System.out.println(test1);
        System.out.println(test2);
    }
}