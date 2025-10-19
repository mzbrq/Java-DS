package MyThread;

public class MyThreadDemo9 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()-> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("hello Thread9");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            System.out.println("Thread9 结束");
        });

        t.start();

        System.out.println("hello main");
        Thread.sleep(3000);

        //结束 Thread9 线程
        t.interrupt();

        System.out.println("main 结束");

    }
}
