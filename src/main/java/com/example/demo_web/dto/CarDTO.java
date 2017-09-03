package com.example.demo_web.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
public class CarDTO {
    private String id;
    private String name;
    private String brand;
    private String model;
}
