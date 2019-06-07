package com.example.demo_web.service;



import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest {

    public static void TestThread() throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        System.out.println ("we have " + executor.getMaximumPoolSize () + " thread");
        System.out.println("after-1: "+Thread.activeCount ());
//        Task task = new Task("Task " + 2);
//        System.out.println("before "+task.getName ());
//        System.out.println("Created : " + task.getName());
//        executor.execute(task);
        System.out.println("after1: "+Thread.activeCount ());


        for (int i = 1; i <= 10; i++)
        {
            Task task = new Task("Task " + i);
            System.out.println("Created : " + task.getName());
            executor.execute(task);
        }

        Thread.sleep (5000);
        System.out.println("after2: "+Thread.activeCount ());
        executor.shutdown();

    }

    public static void monitorThread(Thread monitorMe) {

        while(monitorMe.isAlive())
        {
            try{
                StackTraceElement[] threadStacktrace=monitorMe.getStackTrace();

                System.out.println(monitorMe.getName() +" is Alive and it's state ="+monitorMe.getState()+" ||  Execution is in method : ("+threadStacktrace[0].getClassName()+"::"+threadStacktrace[0].getMethodName()+") @line"+threadStacktrace[0].getLineNumber());

                TimeUnit.MILLISECONDS.sleep(700);
            }catch(Exception ex){}
            /* since threadStacktrace may be empty upon reference since Thread A may be terminated after the monitorMe.getStackTrace(); call*/
        }
        System.out.println(monitorMe.getName()+" is dead and its state ="+monitorMe.getState());
    }

}
