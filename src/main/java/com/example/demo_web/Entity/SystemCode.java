package com.example.demo_web.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sec_systemcode", uniqueConstraints = {@UniqueConstraint(columnNames = "groupName")})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
