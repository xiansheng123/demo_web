package com.example.demo_web.Util;

import com.example.demo_web.Entity.Human;
import com.example.demo_web.Entity.Person;
import org.junit.Test;

import java.time.Period;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.function.Function;

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

    @Test
    public void test_covariant() {
        Person p1=Person.builder()
                .firstname("xuda2")
                .lastname("lu2")
                .age(29).build();
        System.out.println (printPerson (p1,cc));
    }

    private Function<Human, Person> cc = x -> (Person) x;
    private Human printPerson(Human human,Function<Human,Person> func){
        return func.apply (human);
    }

    ////test
    class Fruit {}
    class Apple extends Fruit {}
    class Jonathan extends Apple {}
    class Orange extends Fruit {}


    @Test
    public void test_逆变() {
        List<? super Apple> flist = new ArrayList<> ();
        flist.add (new Jonathan ());  // 编译错误
        flist.add (new Apple ());  // 编译错误
        // flist.add(new Fruit());  // 编译错误
        //  flist.add(new Object());  // 编译错误
    }

    public void test_协变() {
        List<? extends Apple> flist = new ArrayList<> ();
       // flist.add (new Jonathan ());  // 编译错误
        //flist.add (new Fruit ());  // 编译错误
        // flist.add(new Fruit());  // 编译错误
        //  flist.add(new Object());  // 编译错误
        //  flist.add(new Apple ());  // 编译错误
    }
    @Test
     void readFrom(List<? extends Apple> apples) {
        Apple apple = apples.get(0);
       // Jonathan jonathan = apples.get(0);  // 编译错误
        Fruit fruit = apples.get(0);
    }
    @Test
    void readFrom1(List<? super Apple> apples) {
       // Apple apple = apples.get(0);
         //Jonathan jonathan = apples.get(0);  // 编译错误
        //Fruit fruit = apples.get(0);
    }

}