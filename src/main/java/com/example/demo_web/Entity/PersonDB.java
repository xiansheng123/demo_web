package com.example.demo_web.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * Created by luxuda on 6/20/2017.
 */
@Entity
@Data
@Table(name = "Tabtest")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(PKForPerson.class)
public class PersonDB {

    // @NotNull
    @Id
    @Column(name = "name")
    @SystemcodeVal(message="Name should be in the DB",isNeedPatch = "YES")
    private String name;
    @Id
    //@Min(message="Age should be great than 10",value = 10)
    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "addeddate")
    private Timestamp AddedDate;


}

