package com.example.demo_web.Entity;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name="sec_cars")
public class CarDB {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;

    public CarDB() {
    }
    public CarDB(int id, String name, String brand, String model) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.model = model;
    }
}
