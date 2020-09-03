package com.leetcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public void func1() {
        Object object = new Object();
        for (int i = 0; i < 10; i++) {
            synchronized (ThreadPool.class) {
                if (object == null) {
                    try {
                        object = new Object();
                        i -= 1;
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.print(i + " ");
                    object = null;
                    this.notify();
                }
            }
        }
    }
    public static void main(String[] args) {
        ThreadPool t1 = new ThreadPool();
        ThreadPool t2 = new ThreadPool();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> t1.func1());
        executorService.execute(() -> t2.func1());
        executorService.shutdown();
    }
}
