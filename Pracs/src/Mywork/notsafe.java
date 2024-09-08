package Mywork;

class SaleTicket implements Runnable{
    static int ticket = 100;

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            //同步
            //synchronized(){}
            synchronized (this) {
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName()+':'+ticket--);
                }else {
                    break;
                }
            }

        }
        System.out.println("Ticket is empty");
    }
    public SaleTicket() {}
}















public class notsafe {
    public static void main(String[] args) {
        SaleTicket s = new SaleTicket();
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);
        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");
        t1.start();
        t2.start();
        t3.start();
    }
}