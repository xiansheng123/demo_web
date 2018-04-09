package com.example.demo_web.schedule;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;


@Service
@AllArgsConstructor
public class AllSchedule {

    private ApplicationContext context;
    private ExecutorService executorService;
    private Task1 task111;

    @Scheduled(fixedDelay = 30000)
    public void taskAge() throws InterruptedException {

        for (int a = 0; a < 4; a++) {
            Task1 task1 = context.getBean (Task1.class);
            Future future = this.executorService.submit (task1);
            System.out.println (future.isDone ());
        }
    }

//    @Scheduled(fixedDelay = 30000)
//    public void task2() {
//        for (int a = 0; a < 4; a++) {
//            Task1 task1 = context.getBean (Task1.class);
//            System.out.println (task1.getPersons (2));
//            this.executorService.submit (task1);
//            System.out.println(Thread.currentThread().getName() +"线程被调用了2。");
//        }
//    }


}
