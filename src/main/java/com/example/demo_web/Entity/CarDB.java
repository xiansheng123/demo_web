package com.example.demo_web.Entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.ResourceProperties;


import javax.persistence.*;

@Data
@Entity
@Table(name = "sec_cars")
@Builder
public class CarDB {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;

    public CarDB(int id, String name, String brand, String model) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.model = model;
    }
}
