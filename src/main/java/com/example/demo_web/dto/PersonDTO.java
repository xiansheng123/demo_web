package com.example.demo_web.dto;

import com.example.demo_web.Entity.SystemcodeVal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by luxuda on 7/18/2017.
 */
@Getter
@Setter
public class PersonDTO {
    private String Name;
    private int age;
    private Boolean select;
    private String sex;
    private boolean sss;
    private Abctr abcrt;

    private List<SystemCodeDTO> demo;
}
