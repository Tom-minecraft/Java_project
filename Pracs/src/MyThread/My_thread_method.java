package MyThread;

public class My_thread_method {
    public static void main(String[] args) {
        Print_number p1 = new Print_number();
        p1.setName("线程1");
        Print_number p2 = new Print_number("线程2");
        p1.start();
        p2.start();
    }
}







class Print_number extends Thread {
    public Print_number() {}
    public Print_number(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

}