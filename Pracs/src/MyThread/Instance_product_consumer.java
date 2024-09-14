package MyThread;

public class Instance_product_consumer {
    public static void main(String [] args){
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);

        Consumer c1 = new Consumer(clerk);
        Consumer c2 = new Consumer(clerk);
        p1.setName("Producer_1");
        c1.setName("Consumer_1");
        c2.setName("Consumer_2");
        
        p1.start();
        c1.start();
        c2.start();

    }
}

class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("开始生产");
        while(true){
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            clerk.addProduct();
        }

    }
}

class Consumer extends Thread{
    private Clerk clerk ;
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        System.out.println("===========开始消费===========");
        while(true){
            try{
                Thread.sleep(75);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            clerk.minusProduct();

        }
    }
}






class Clerk{
    private int productNumber = 0;
    private static final int MAX_PRODUCT = 20;
    private static final int MIN_PRODUCT = 1;

    // 增加产品
    public synchronized void addProduct(){
        if(productNumber < MAX_PRODUCT){
            productNumber++;
            System.out.println(Thread.currentThread().getName() +"生产了第"+ productNumber + "个产品");
            this.notifyAll();
        }else{
            try{
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    // 减少产品
    public synchronized void minusProduct(){
        if(productNumber >= MIN_PRODUCT){
            System.out.println(Thread.currentThread().getName()+"消费了"+ productNumber-- +"个产品");
            this.notifyAll();
        }else{
            try{
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }


}