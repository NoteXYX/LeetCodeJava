package com.leetcode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadTest {
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
    public static void main(String[] args) {
        BlockingQueue<Goods> queue = new ArrayBlockingQueue<>(5);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        for (int i = 0; i < 2; i++) {
            new Thread(producer, "线程"+i).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(consumer, "线程"+i).start();
        }
    }
}
