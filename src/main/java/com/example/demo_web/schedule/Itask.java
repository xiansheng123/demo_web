package com.example.demo_web.schedule;

import com.example.demo_web.Entity.PersonDB;

import java.time.LocalDateTime;


public interface Itask extends Runnable {
      PersonDB getPersons(int id);

    @Override
    default void run(){
        System.out.println(Thread.currentThread().getName() +"线程被调用了。");
        System.out.println ("run interface:" + LocalDateTime.now ());
                    long sleeptime=500;
        try {
            System.out.println (getPersons (1).getCountryCode ().getCodename ());
            Thread.sleep ( sleeptime);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
}
