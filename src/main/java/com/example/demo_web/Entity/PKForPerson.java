package com.example.demo_web.Entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class PKForPerson implements Serializable {

    private int age;
    private String name;
}
