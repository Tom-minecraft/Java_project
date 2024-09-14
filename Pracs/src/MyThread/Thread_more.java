package MyThread;

class Bank {
    public Bank(){}
    private static Bank instance = null ;
    public static  Bank getInstance(){
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null){
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    instance = new Bank();

                }

            }
        }
        return instance;
    }

}



public class Thread_more {
    static Bank b1 = null;
    static Bank b2 = null;
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                b1 = Bank.getInstance() ;
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                b2 = Bank.getInstance() ;
            }
        };
        t1.start();
        t2.start();
        try{
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1 == b2);

    }
}

