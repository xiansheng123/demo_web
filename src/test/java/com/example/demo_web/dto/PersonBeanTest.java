package com.example.demo_web.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by luxuda on 8/9/2017.
 */

@AllArgsConstructor
public class PersonBeanTest {

    private  PersonBean personBean;

    @Test
    public void getPersonBean ()
    {
        System.out.println(personBean.getDescription());
        System.out.println(personBean.getTitle());
    }

}