package com.example.demo_web.Entity;

import lombok.*;
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
public class TabTest {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "addeddate")
    private Timestamp addedDate;

    @OneToOne
    @JoinColumn(name = "country" )
    @NotFound(action = NotFoundAction.IGNORE)
    private SystemCode countryCode;
}

