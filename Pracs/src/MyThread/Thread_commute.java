package MyThread;

class print_num implements Runnable {
    private int number = 1;

    @Override
    public void run() {
       while(true){
           synchronized (this) {
               if (number <=100){
                   try {
                       Thread.sleep(10);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(Thread.currentThread().getName()+":"+number++);
               }else{
                   break;
               }
           }
       }
    }
}

public class Thread_commute {
    public static void main(String[] args) {
        print_num p = new print_num();
        Thread t1 = new Thread(p,"Thread-1");
        Thread t2 = new Thread(p,"Thread-2");
        t1.start();
        t2.start();
    }
}
