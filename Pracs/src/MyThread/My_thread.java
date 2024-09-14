package MyThread;

//Java Thread_class
public class My_thread {
    public static void main(String[] args) {
        even_test e1 = new even_test();
        odd_test s1 = new odd_test();
        e1.start(); //使用start() 开启新线程
        s1.start();
        //匿名线程创建
        new Thread(){
            public void run(){

            }
        }.start();

    }
}

class even_test extends Thread{
    public even_test() {}
    @Override
    public void run() {
        for (int i = 0; i <=20 ;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

}

class odd_test extends Thread{
    public odd_test() {}

    @Override
    public void run() {
        for (int j = 0; j <=20 ;j++){
            if (j%2!=0){
                System.out.println(Thread.currentThread().getName() + ":" + j);
            }
        }
    }
}

