package com.example.demo_web.service;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            Long duration = (long) (Math.random () * 2);
            System.out.println ("Executing : " + name + " threadId: " + Thread.currentThread ().getId ());
            int a = 1;
            int b = 0;
            if(this.getName ().equals ("Task 2")){
                int c = a / b;
            }
            TimeUnit.SECONDS.sleep (duration);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }catch (Exception e){

            e.printStackTrace ();
        }
    }
}
