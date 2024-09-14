package MyThread;

public class My_thread_runnable {
    public static void main(String[] args) {
        print_even p1 = new print_even();
        Thread t1 = new Thread(p1);
        t1.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class print_even implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}