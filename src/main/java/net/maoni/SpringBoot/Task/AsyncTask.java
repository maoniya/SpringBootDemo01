package net.maoni.SpringBoot.Task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Async
public class AsyncTask {
    public void task1(){
        System.out.println("task1");
        try {
            Thread.sleep(4000L);
            System.out.println("task1休息结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void task2(){
        System.out.println("task2");
        try {
            Thread.sleep(4000L);
            System.out.println("task2休息结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void task3(){
        System.out.println("task3");
        try {
            Thread.sleep(4000L);
            System.out.println("task3休息结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public Future<String> task4(){
        System.out.println("task4");
        try {
            Thread.sleep(4000L);
            System.out.println("task4休息结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<String>("task4");
    }

    public Future<String> task5(){
        System.out.println("task5");
        try {
            Thread.sleep(4000L);
            System.out.println("task5休息结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<String>("task5");
    }


}
