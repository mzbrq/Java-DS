package MyThread;

public class MyThreadDemo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()-> {
            int n = 5;
            for (int i = 0; i < n; i++) {
                System.out.println("Thread10，正在运行");
            }

            System.out.println("Thread10，结束");
        });

        t.start();

        System.out.println("main线程，开始");

        t.join();

        System.out.println("main线程，结束");

    }
}
