package Mywork;

import java.awt.*;

class MyThread extends Thread {
    static int number = 200;
    @Override
    public void run() {
        while (true) {
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Window.class) {
                if (number > 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + number--);
                } else {
                    break;
                }
            }
        }
    }
}



public class synchronized_test_1 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");
        t1.start();
        t2.start();
        t3.start();
    }
}
