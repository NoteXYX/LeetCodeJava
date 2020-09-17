package com.leetcode;

import java.util.concurrent.*;

public class ThreadTestOLD {
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
//                if (Thread.currentThread().isInterrupted())
//                    return;
                synchronized(number) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (number.num % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "打印：" + number.num);
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
//                if (Thread.currentThread().isInterrupted())
//                    return;
                synchronized(number) {
                    if (number.num % 2 != 0) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "打印：" + number.num);
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

//        Number number = new Number(0);
//        EvenPrinter evenPrinter = new EvenPrinter(number);
//        OddPrinter oddPrinter = new OddPrinter(number);
//        Thread evenThread = new Thread(evenPrinter, "偶数打印线程");
//        Thread oddThread = new Thread(oddPrinter, "奇数打印线程");
//        evenThread.start();
//        oddThread.start();



//        //创建一个可缓存线程池
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        for (int i = 0; i < 10; i++) {
//            try {
//                // sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            cachedThreadPool.execute(new Runnable() {
//                public void run() {
//                    // 打印正在执行的缓存线程信息
//                    System.out.println(Thread.currentThread().getName()
//                            + "正在被执行");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }

//        //定长线程池
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 10; i++) {
//            fixedThreadPool.execute(new Runnable() {
//                public void run() {
//                    try {
//                        // 打印正在执行的缓存线程信息
//                        System.out.println(Thread.currentThread().getName()
//                                + "正在被执行");
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        //延迟1秒执行
                 /*scheduledThreadPool.schedule(new Runnable() {
                     public void run() {
                        System.out.println("延迟1秒执行");
                     }
                 }, 1, TimeUnit.SECONDS);*/


        //延迟1秒后每3秒执行一次
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("延迟1秒后每3秒执行一次");
            }
        }, 1, 3, TimeUnit.SECONDS);




//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        evenThread.interrupt();
//        oddThread.interrupt();

    }
}
