package com.example.demo_web.schedule;

import com.example.demo_web.Entity.PersonDB;
import lombok.Synchronized;
import org.hibernate.annotations.Synchronize;

import java.time.LocalDateTime;


public interface Itask extends Runnable  {
    PersonDB getPersons(int id);

    @Override
     default void run(){
        System.out.println ("-------begin-------");
        System.out.println(Thread.currentThread().getName() +"线程被调用了。:"+LocalDateTime.now ());
        long sleepTime=500;
        try {
            System.out.println (getPersons (1).getCountryCode ());
            Thread.sleep ( sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
}
