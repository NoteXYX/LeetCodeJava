package com.leetcode;

public class ThreadTest {
    public static class Thread3Print implements Runnable{
        private static Object lock = new Object();
        private static int count = 0;
        private int num;
        public Thread3Print(int num) {
            this.num = num;
        }
        @Override
        public void run() {
            synchronized (lock) {
                while (count <= 100) {
                    if (count % 3 == num) {
                        System.out.println(Thread.currentThread().getName() + "打印" + count);
                        count += 1;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread0 = new Thread(new Thread3Print(0), "线程0");
        Thread thread1 = new Thread(new Thread3Print(1), "线程1");
        Thread thread2 = new Thread(new Thread3Print(2), "线程2");
        thread0.start();
        thread1.start();
        thread2.start();
        thread0.join();
        thread1.join();
        thread2.join();

    }
}
