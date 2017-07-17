package com.example.demo_web.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
/**
 * Created by luxuda on 6/20/2017.
 */
@Entity
@Table(name = "Tabtest")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "Demo_Test_out", procedureName = "Demo_Test_out", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "Name", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "Age", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "info", type = String.class) })
})

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

   // @NotNull
    @Column(name = "Name")
     @SystemcodeVal(message="Name should be in the DB")
    private String name;

    //@Min(message="Age should be great than 10",value = 10)
  // @SystemcodeVal(message="Age should be great than 11", min=11)
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

