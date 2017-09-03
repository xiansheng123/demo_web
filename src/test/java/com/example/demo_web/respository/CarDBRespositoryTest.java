package com.example.demo_web.respository;

import com.example.demo_web.Entity.CarDB;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarDBRespositoryTest {

    CarDBTemplateRespository carDBRespository =new CarDBTemplateRespository();

    @Test
    public void getCarById() throws Exception {
     CarDB car= carDBRespository.getCarById(1);
      assertEquals(1,car.getId());
    }

}