package com.example.demo_web.dto;

import lombok.Data;

import java.util.List;

@Data
public class PersonDTO {
    private String Name;
    private int age;
    private Boolean select;
    private String sex;
    private boolean sss;
    private Abctr abcrt;

    private List<SystemCodeDTO> demo;
}
