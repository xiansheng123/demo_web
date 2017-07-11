package com.example.demo_web.model;

import javax.persistence.*;
import java.util.Date;
/**
 * Created by luxuda on 6/20/2017.
 */
@Entity
@Table(name = "Tabtest")
public class PersonDB {
    public PersonDB(){}
    public PersonDB(String name,Integer age,Boolean sex){
      this.setName(name);
     this.setAge(age);
     this.setSex(sex);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Age")
    private Integer age;

    @Column(name = "Sex")
    private Boolean sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}