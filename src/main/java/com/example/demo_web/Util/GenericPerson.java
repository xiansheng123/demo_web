package com.example.demo_web.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by luxuda on 7/30/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericPerson<PersonDB> {
    private PersonDB personDB;
}