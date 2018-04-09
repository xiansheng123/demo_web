package com.example.demo_web.service;

import com.example.demo_web.Entity.PersonDB;
import lombok.AllArgsConstructor;
import org.junit.Test;
import org.omg.CORBA.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
@Service
@AllArgsConstructor
public class PersonDBServiceTest {

@Test
  public   void AddListTest(){
    List<Integer> stringList =new ArrayList(){
        {
            add (1);
            add (2);
            add (3);
            add (4);
            add (5);
        }
    };
    List<String> cc=  stringList.stream ().map (x -> returnStr (x))
            .filter (Objects::nonNull)
            .collect (Collectors.toList ());
    cc.addAll (Collections.EMPTY_LIST);
    cc.addAll (Collections.EMPTY_LIST);
    System.out.println (cc);

}
@Test
    public void AddListTest2(){

}
private  String returnStr(int i){
        if(i<2){
            return null;
        }else {
            return "the code " + i;
        }
}

}