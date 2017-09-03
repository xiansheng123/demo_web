package com.example.demo_web.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericPerson<PersonDB> {
    private PersonDB personDB;
}