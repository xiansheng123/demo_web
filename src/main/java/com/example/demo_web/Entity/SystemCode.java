package com.example.demo_web.Entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by luxuda on 7/16/2017.
 */
@Entity
@Table(name = "sec_systemcode")
@Data
public class SystemCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "groupname")
    private String groupName;

    @Column(name = "codename")
    private String codename;

}
