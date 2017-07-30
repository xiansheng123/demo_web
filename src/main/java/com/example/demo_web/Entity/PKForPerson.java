package com.example.demo_web.Entity;


import java.io.Serializable;

/**
 * Created by luxuda on 7/24/2017.
 */

public class PKForPerson implements Serializable {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
