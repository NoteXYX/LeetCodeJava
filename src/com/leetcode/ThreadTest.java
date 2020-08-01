package com.leetcode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadTest {
     /////////////////生产者消费者模型////////////////////////////////////////////////////////
    public static class Goods {
        private String name;
        Goods(String name) {
            this.name = name;
        }
    }
    public static class Producer implements Runnable{
        private BlockingQueue<Goods> queue;
        Producer(BlockingQueue<Goods> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            while (true) {
                Goods good = new Goods("包子");
                try {
                    Thread.sleep(1000);
                    queue.put(good);
                    System.out.println(Thread.currentThread().getName() + "生产完成");
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class Consumer implements Runnable {
        private BlockingQueue<Goods> queue;
        Consumer(BlockingQueue<Goods> queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    Goods good = queue.take();
                    System.out.println(Thread.currentThread().getName() + "消费完成");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /////////////////生产者消费者模型////////////////////////////////////////////////////////
    /////////////////多线程打印奇数和偶数/////////////////////////////////////////////////////
    public static class Number {
        int num;
        Number(int num) {
            this.num = num;
        }
    }
    public static class EvenPrinter implements Runnable {
        Number number;
        EvenPrinter(Number number) {
            this.number = number;
        }
        @Override
        public void run() {
            while (number.num <= 100) {
                synchronized(number) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (number.num % 2 == 0) {
                        System.out.println(number.num);
                        number.num += 1;
                        number.notify();
                    }
                    else {
                        try {
                            number.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public static class OddPrinter implements Runnable {
        Number number;
        OddPrinter(Number number) {
            this.number = number;
        }
        @Override
        public void run() {
            while (number.num <= 100) {
                synchronized(number) {
                    if (number.num % 2 != 0) {
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(number.num);
                        number.num += 1;
                        number.notify();
                    }
                    else {
                        try {
                            number.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
//        BlockingQueue<Goods> queue = new ArrayBlockingQueue<>(5);
//        Producer producer = new Producer(queue);
//        Consumer consumer = new Consumer(queue);
//        for (int i = 0; i < 2; i++) {
//            new Thread(producer, "线程"+i).start();
//        }
//        for (int i = 0; i < 2; i++) {
//            new Thread(consumer, "线程"+i).start();
//        }
        Number number = new Number(0);
        EvenPrinter evenPrinter = new EvenPrinter(number);
        OddPrinter oddPrinter = new OddPrinter(number);
        Thread evenThread = new Thread(evenPrinter);
        Thread oddThread = new Thread(oddPrinter);
        evenThread.start();
        oddThread.start();
    }
}
