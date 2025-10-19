package MyThread;

public class MyThreadDemo7 {
    public static void main(String[] args) {
        Thread t = new Thread(()-> {
            while (true) {
                System.out.println("hello thread7");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //一个线程只能 start 一次
        //t.start();
        t.start();
        //t.run(); 没有创建新的线程，而是直接调用 run() 方法

        while (true) {
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
