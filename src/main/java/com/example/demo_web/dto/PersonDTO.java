package com.example.demo_web.dto;

import com.example.demo_web.Entity.SystemcodeVal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by luxuda on 7/18/2017.
 */
@Getter
@Setter
public class PersonDTO {
    private String name;
    private int age;
    private String sex;
    @Valid
    @NotNull
    private Abctr abcrt;
}
