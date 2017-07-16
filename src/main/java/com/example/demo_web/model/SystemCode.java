package com.example.demo_web.model;

import javax.persistence.*;

/**
 * Created by luxuda on 7/16/2017.
 */
@Entity
@Table(name = "sec_systemcode")
public class SystemCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "Groupname")
    private String groupName;

    @Column(name = "Codename")
    private String codename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }
}
