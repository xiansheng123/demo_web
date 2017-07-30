package com.example.demo_web.Entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * Created by luxuda on 6/20/2017.
 */
@Entity
@Data
@Table(name = "Tabtest")

@IdClass(PKForPerson.class)
public class PersonDB {
    public PersonDB(String name, Integer age, Boolean sex) {
        this.setName(name);
        this.setAge(age);
        this.setSex(sex);
    }
    //@Column(name = "id")

  //  private int id;

    // @NotNull
    @Id
    @Column(name = "name")
    // @SystemcodeVal(message="Name should be in the DB")
    private String name;
    @Id
    //@Min(message="Age should be great than 10",value = 10)
    // @SystemcodeVal(message="Age should be great than 11", min=11)
    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "addeddate")
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp AddedDate;


    @Column(name = "addeddate2")
    private Timestamp AddedDate2;

    public PersonDB() {
        super();
        // TODO Auto-generated constructor stub
    }


    public PersonDB(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

}

