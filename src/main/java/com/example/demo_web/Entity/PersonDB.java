package com.example.demo_web.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Data
@Table(name = "Tabtest")
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@IdClass(PKForPerson.class)
public class PersonDB {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
//    @SystemcodeVal(message="Name should be in the DB",isNeedPatch = "YES")
    private String name;

    //@Id
    //@Min(message="Age should be great than 10",value = 10)
    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "addeddate")
    private Timestamp addedDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country" )
    @NotFound(action = NotFoundAction.IGNORE)
    private SystemCode countryCode;
}

