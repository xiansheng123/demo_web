package com.example.demo_web.Util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by luxuda on 7/30/2017.
 */
@Data
public class GenericPerson<PersonDB> {
    private PersonDB personDB;
}