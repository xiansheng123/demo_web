package com.example.demo_web.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person1 extends Human{
    String id2;
    String firstname;
    String lastname;
    Integer age;
}
