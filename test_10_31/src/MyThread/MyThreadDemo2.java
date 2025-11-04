package MyThread;

public class MyThreadDemo2 {
    private static long count;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()-> {
            for (long i = 0; i < 5_000_000; i++) {
                count++;
            }
        });

        Thread t2 = new Thread(()-> {
            for (long i = 5_000_000; i < 10_000_000; i++) {
                count++;
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
    }
}
